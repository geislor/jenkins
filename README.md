# Jenkins docker configuration

A jenkins instance preconfigured to run for https://github.com/ci-pipeline/ci-pipeline

### Build:
```
make build 
```

### Run:

```
docker run -p 3333:8080 \
	-v /var/run/docker.sock:/var/run/docker.sock \
	-e GIT_BASEURL=<put base url here, e.g https://github.com> \
	-e GIT_REPOS=<put comma seperated of repos here, e.g. mhewedy/spwrap,kubernetes/kubernetes > \
	--restart=always \
	-d ci-pipeline/jenkins
```

username: `ci-pipeline`
password: generated in the logs (search for `****** password: <the password> `)
