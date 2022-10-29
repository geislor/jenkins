seed_repos = "${jm.envVars['GIT_REPOS']}".split(',')

seed_repos.each { repo ->

    repo = "${jm.envVars['GIT_BASEURL']}/$repo";

    def name = repo.split("/").last()
    def display = repo.split("/").takeRight(2).join('/')

    multibranchPipelineJob(name) {

        displayName(display.toString())

        branchSources {
            git {
                id(UUID.randomUUID().toString())
                remote(repo)
                credentialsId("ci-pipeline-git")
            }
        }

        factory {
            pipelineBranchDefaultsProjectFactory {
                scriptId 'Jenkinsfile'
                useSandbox true
            }
        }

        triggers {
            cron('* * * * *')
        }
    }
}
