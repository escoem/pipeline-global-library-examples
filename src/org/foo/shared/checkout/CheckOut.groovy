package org.foo.shared.checkout
import hudson.plugins.git.GitSCM  
  
class CheckOut implements Serializable { 
  def steps 
  
  CheckOut(steps) {this.steps = steps} 
  
  def getGitObject(GitSCM scmEngine) { 
    steps.checkout scmEngine 
  } 
}
