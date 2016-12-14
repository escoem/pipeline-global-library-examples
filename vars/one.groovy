@GrabConfig( systemClassLoader=true )
def groovy_app

def call(def buildnumber, def environment) {

  node ('slave'){
    
    checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '037dbe61-9a5b-417e-a7fd-25ebf9249ab7', url: 'git@github.com:escoem/pipeline-global-library-examples.git']]]
    
    groovy_app=load 'my_properties.groovy'
    echo groovy_app.moduleDir
  }

  two(groovy_app)

}
