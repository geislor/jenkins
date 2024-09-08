FROM alpine:3.19.4 AS installer

ARG JENKINS_VERSION="latest"

RUN apk add --no-cache curl
RUN apk add --no-cache --repository http://dl-cdn.alpinelinux.org/alpine/edge/community docker-cli
RUN curl -SL -o jenkins.war http://mirrors.jenkins.io/war-stable/$JENKINS_VERSION/jenkins.war

# Jenkins
FROM alpine:3.19.4

# jenkins deps
RUN apk add --no-cache \
    bash \
    coreutils \
    git \
    openjdk11 \
    openssh-client \
    ttf-dejavu \
    unzip

# compose deps
RUN apk add --no-cache \
    gcc \
    libc-dev \
    libffi-dev \
    make \
    openssl-dev

ARG JENKINS_VERSION="latest"
ENV JENKINS_VERSION=${JENKINS_VERSION} \
    JENKINS_HOME="/data"

VOLUME ${JENKINS_HOME}


COPY --from=installer /usr/bin/docker /usr/bin/docker
COPY --from=installer /jenkins.war /jenkins/jenkins.war

COPY ./jenkins.install.UpgradeWizard.state ${JENKINS_HOME}/
COPY ./scripts/ ${JENKINS_HOME}/init.groovy.d/
COPY ./job-dsl-scripts/ ${JENKINS_HOME}/job-dsl-scripts/
COPY ./casc_config.yaml ${JENKINS_HOME}/casc_config.yaml

EXPOSE 8080
ENTRYPOINT java -Duser.home=${JENKINS_HOME} -Dpermissive-script-security.enabled=true \
 				-Djenkins.install.runSetupWizard=false -Dcasc.jenkins.config=${JENKINS_HOME}/casc_config.yaml \
 				-jar /jenkins/jenkins.war
