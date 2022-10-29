# Jenkins docker configuration

A jenkins instance preconfigured to run for https://github.com/ci-pipeline/ci-pipeline

### Build:
```
make build 
```

### Run:

1. You need to configure two env vars: `GIT_BASEURL` and `GIT_REPOS`
    ```
    docker run -p 3333:8080 \
        -v /var/run/docker.sock:/var/run/docker.sock \
        -e GIT_BASEURL=<put base url here, e.g https://github.com> \
        -e GIT_REPOS=<put comma seperated of repos here, e.g. mhewedy/spwrap,kubernetes/kubernetes > \
        --restart=always \
        -d ci-pipeline/jenkins
    ```
2. Login to Jenkins at IP:3333 and login with following credentials:  
    username: `ci-pipeline`  
    password: auto-generated (search for `****** password: <the password> ` in the logs)
   
3. Optional: You might need to configure git credentials by creating a credentials by the id **"ci-pipeline-git"**
    see [using credentials](https://www.jenkins.io/doc/book/using/using-credentials/)
   
    <img src="https://github.com/ci-pipeline/jenkins/raw/master/etc/git_cred.png"  width="700px"/>

4. Now go into each Jenkins repo and click *Scan Multibranch Pipeline Log* on the left 

