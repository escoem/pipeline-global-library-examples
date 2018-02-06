package org.foo
    
class StandardBuild {

    def api; 
    def lib;
    java.util.Map builds;
    def steps;
    
    StandardBuild(builds, steps) {
        this.builds = builds
        this.steps = steps
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

    def execute()
    {
        //steps.node ()
        //{
            //for (build in builds)
            for (entry in builds.entrySet())
            //{

                steps.stage (entry.getKey()) 
                {
                    entry.getValue().execute()
                }
            //}
        //}
    }
}
