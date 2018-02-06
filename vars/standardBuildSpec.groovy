// vars/standardBuildSpec.groovy
import org.foo.*

//Map allBuilds = [:]
//builds = [:]
    
def call(cfg)
{
    def builds = [:]
    def build = new StandardBuild(builds)
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()

    build.execute()
}

return
