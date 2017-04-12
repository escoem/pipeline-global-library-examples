package org.foo.shared

import hudson.model.*
import jenkins.model.*
import java.util.concurrent.atomic.AtomicInteger
import groovy.io.FileType


class PostGroovy{

    def manager

    def PostGroovy(manager){
        this.manager = manager
    }
	
    def run(){
	if (manager.logContains("foo = bar")){
                manager.buildFailure()
                manager.addErrorBadge("found")
                manager.createSummary("warning.gif").appendText("<h1>found</h1>", false, false, false, "red")
     
        } 
   }
}
