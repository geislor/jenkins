repos = [
        "https://github.com/ci-pipeline/example_multibranch"
]

/*job("__seed") {

    List<hudson.model.Item> allItems =
            Jenkins.instance.getAllItems(jenkins.branch.MultiBranchProject.class)
*/
repos.each { repo ->
    def name = repo.split("/").last()

    /*
    if (allItems.find { name.equals(it.name) } != null) {
        return
    }*/

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
/*

    triggers {
        cron('* * * * *')
    }
}
*/

