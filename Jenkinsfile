pipeline {
    agent none
    stages {
        stage('RUN TEST') {
            agent {  label 'master'}
            steps {
              sh 'echo foo = bar'  
            }
        }
    }
    
    post { 
        always {
            echo "Post"
            node('master'){
              @Library('post') 
              //import src.org.post.PostGroovy
              def PG = new src.org.post.PostGroovy(manager)
              PG.run()
                    
            }
            }
                
            
        }
}
    
