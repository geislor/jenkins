[
        "https://github.com/ci-pipeline/example_multibranch"
].each { repo ->
    multibranchPipelineJob(repo.split("/").last()) {

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
            periodic(1)
        }
    }
}
