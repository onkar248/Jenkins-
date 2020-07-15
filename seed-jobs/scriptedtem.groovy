pipelineJob('scripted-pipeline2') {
  displayName('scripted-pipeline2')
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {

      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://gitlab.com/atulyw/devops-b3.git')
            'credentialsId'('GitLab')
          }
        }
        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
        'doGenerateSubmoduleConfigurations'(false)
        'submoduleCfg'(class:'list')
        'extensions'()
      }
      'scriptPath'('scripted.groovy')
      'lightweight'(true)
    }
  }
}
