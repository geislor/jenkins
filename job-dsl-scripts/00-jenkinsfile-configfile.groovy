configFiles {
    groovyScript {
        id("Jenkinsfile")
        name("Jenkinsfile")
        comment("Jenkinsfile to be used by pipeline-multibranch-defaults plugin")
        content("""
            library identifier: 'ci-pipeline@master',
                    retriever: modernSCM([\$class: 'GitSCMSource', remote: 'https://github.com/ci-pipeline/ci-pipeline.git'])
            
            node {
              checkout scm
              ci('.ci-pipeline.yaml')
            }
        """)
    }
}
