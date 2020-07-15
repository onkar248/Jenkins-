pipelineJob('scripted-pipeline2_converted') {
  displayName('scripted-pipeline2_converted')
  configure { flowdefinition ->
    flowdefinition / 'properties' << 'com.dabsquared.gitlabjenkins.connection.GitLabConnectionProperty'(plugin:'gitlab-plugin@1.5.13') {
      'gitLabConnection'()
    }
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition',plugin:'workflow-cps@2.76') {
      'script'('''pipeline {
          agent any
          stages {
              stage(\'Gitlab-Pull\') {
                  steps {
                        git credentialsId: \'GitLab\', url: \'https://gitlab.com/atulyw/cbz-student-ui.git\'
                  }
              }
              stage(\'List files\') {
                  steps {
                        sh label: \'\', script: \'ls\'
                  }
              }
              stage(\'Test\') {
                  steps {
                        echo \'test succeful\'
                  }
              }
              stage(\'Pre-Prod-Dept\') {
                  steps {
                        echo \'Deployed to pre-prod\'
                  }
              }
              stage(\'Prod-Dept\') {
                  steps {
                        echo \'Deployed to prod\'
                  }
              }
          }
      }''')

      'sandbox'(true)
    }
  }
}
