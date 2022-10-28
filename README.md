# Jenkins docker configuration

An jenkins instance preconfigured to run for https://github.com/ci-pipeline/ci-pipeline

Build:
```
docker build -t ci-pipeline/jenkins . 
```

Run:
```
docker run -p 80:8080 -v /var/run/docker.sock:/var/run/docker.sock -d ci-pipeline/jenkins
```

username/password: `ci-pipeline`/`ci-pipeline`
