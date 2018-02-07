package org.foo
    
class StandardBuild {

    def api; 
    def lib;
    java.util.Map builds;
    def script;
    
    StandardBuild(builds, script) {
        this.builds = builds
        this.steps = script
    }
    
    
    def dotnetapi(cfg)
    {
        def build = new DotnetApiBuild(steps)
        cfg.resolveStrategy = Closure.DELEGATE_FIRST
        cfg.delegate = build
        cfg()
        //api = build
        //builds[build.projectName] = build
        builds.put(build.projectName, build)
    }

    def dotnetlib(cfg)
    {
        def build = new DotnetlibBuild(steps)
        cfg.resolveStrategy = Closure.DELEGATE_FIRST
        cfg.delegate = build
        cfg()
        lib = build
        //builds[build.projectName] = build
        builds.put(build.projectName, build)
    }

    def execute(scm)
    {
        script.node ()
        {
            script.checkout scm
            for (entry in builds.entrySet())
            {
                script.stage (entry.getKey()) 
                {
                    entry.getValue().execute()
                }
            }
        }
    }
}
