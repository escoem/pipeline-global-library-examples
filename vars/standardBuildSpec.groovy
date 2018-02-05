// vars/standardBuildSpec.groovy
import org.foo.*

//Map allBuilds = [:]
builds = [:]
    
def call(cfg)
{
    def build = new standardBuild(this)
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()

    build.execute()
}

return
