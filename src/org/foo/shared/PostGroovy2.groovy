package org.foo.shared

class PostGroovy2{

    def steps

    def PostGroovy2(steps){
        this.steps = steps
    }
	
    def please(){
	    steps.echo
	if (steps.manager.logContains("foo = bar")){
                steps.manager.buildFailure()
                steps.manager.addErrorBadge("found")
                steps.manager.createSummary("warning.gif").appendText("<h1>found</h1>", false, false, false, "red")
     
        } 
   }
}
