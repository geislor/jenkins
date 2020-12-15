seed_repos = [
        "https://github.com/ci-pipeline/example_multibranch"
]

seed_repos.each { repo ->
    def name = repo.split("/").last()

    multibranchPipelineJob(name) {

        branchSources {
            git {
                id(UUID.randomUUID().toString())
                remote(repo)
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
