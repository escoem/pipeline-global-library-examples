package org.foo.shared

class Art{

    def Artifactory

    def Art(Artifactory){
        this.Artifactory = Artifactory
    }
	
    def please(){
	    def server = Artifactory.newServer url: 'artifactory-url', username: 'username', password: 'password'
   }
}
