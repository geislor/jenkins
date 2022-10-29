seed_repos = [
        "https://github.com/ci-pipeline/example_multibranch"
]

seed_repos.each { repo ->
    def name = repo.split("/").takeRight(2)

    multibranchPipelineJob(name.join("/")) {

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
