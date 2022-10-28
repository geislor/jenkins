build:
	docker build -t ci-pipeline/jenkins.

deploy:
	docker image push ci-pipeline/jenkins

run:
	docker run -p 3333:8080 -v /var/run/docker.sock:/var/run/docker.sock -d ci-pipeline/jenkins
