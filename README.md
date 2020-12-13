# Jenkins docker configuration

Run using docker-compose as:
```
docker-compose -f docker-compose.yml up -d
```

After the server restarts, you need to add managed file as follows:

`Manage Jenkins` > `Managed files` then add the following under file id `Jenkinsfile`

```groovy
library identifier: 'ci-pipeline@master',
        retriever: modernSCM([$class: 'GitSCMSource', remote: 'https://github.com/ci-pipeline/ci-pipeline.git'])

node {
  checkout scm
  ci('.ci-pipeline.yaml')
}
```

<img src="https://github.com/ci-pipeline/jenkins/raw/master/etc/Jenkinsfile-managed_file.png" width="800px">
