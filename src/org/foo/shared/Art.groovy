package org.foo.shared

class Art{

    def steps

    def Art(steps){
        this.steps = steps
    }
	
    def please(){
      steps.echo 'p1'
	    def server = steps.Artifactory.newServer url: 'artifactory-url', username: 'username', password: 'password'
	    steps.echo 'p2'
   }
}
