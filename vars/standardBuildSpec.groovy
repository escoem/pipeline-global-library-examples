// vars/standardBuildSpec.groovy
import org.foo.*

//Map allBuilds = [:]
//builds = [:]
    
def call(cfg)
{
    java.util.Map builds = new java.util.HashMap()
    def build = new StandardBuild(builds, this)
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()

    build.execute(scm)
}

return this
