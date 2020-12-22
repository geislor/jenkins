# Jenkins docker configuration

An jenkins instance preconfigured to run for https://github.com/ci-pipeline/ci-pipeline

Build:
```
docker build -t ci-pipeline/jenkins . 
```

Run:
```
docker run -p 8080:8080 -v /var/run/docker.sock:/var/run/docker.sock -d ci-pipeline/jenkins
```

username/password: `ci-pipeline`/`ci-pipeline`

### Demo
You can find a demo jenkins installation [here](http://ec2-3-16-158-55.us-east-2.compute.amazonaws.com:8080/)
