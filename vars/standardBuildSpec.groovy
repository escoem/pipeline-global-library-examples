// vars/standardBuildSpec.groovy
import org.foo.*

//Map allBuilds = [:]
//builds = [:]
java.util.Map builds = new java.util.HashMap()
    
    
def call(cfg)
{
    def build = new standardBuild()
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()

    build.execute()
}
