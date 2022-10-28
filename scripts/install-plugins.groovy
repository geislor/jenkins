#!groovy
import jenkins.model.Jenkins;

pm = Jenkins.instance.pluginManager
uc = Jenkins.instance.updateCenter

pm.doCheckUpdatesServer()

["git",
 "docker-workflow",
 "workflow-aggregator",
 "blueocean",
 "pipeline-multibranch-defaults",
 "ansicolor",
 "pipeline-utility-steps",
 "permissive-script-security",
 "job-dsl",
 "configuration-as-code"
].each {
    if (!pm.getPlugin(it)) {
        deployment = uc.getPlugin(it).deploy(true)
        deployment.get()
    }
}
