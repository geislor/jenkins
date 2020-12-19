# Jenkins docker configuration

Build:
```
docker build -t ci-pipeline/jenkins . 
```

Run:
```
docker run -p 8080:8080 -v /var/run/docker.sock:/var/run/docker.sock  ci-pipeline/jenkins -d
```

username/password: `ci-pipeline`/`ci-pipeline`
