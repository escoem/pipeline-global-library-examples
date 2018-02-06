package org.foo
    
class StandardBuild {

    def api; 
    def lib;
    def builds;
    
    StandardBuild(builds) {
        this.builds = builds
    }
    
    
    def dotnetapi(cfg)
    {
        def build = new dotnetApiBuild()
        cfg.resolveStrategy = Closure.DELEGATE_FIRST
        cfg.delegate = build
        cfg()
        //api = build
        builds[build.projectName] = build
    }

    def dotnetlib(cfg)
    {
        def build = new dotnetlibBuild()
        cfg.resolveStrategy = Closure.DELEGATE_FIRST
        cfg.delegate = build
        cfg()
        lib = build
        builds[build.projectName] = build
    }

    def execute()
    {
        node ()
        {
            for (build in builds)
            {
                stage (build.projectName) 
                {
                    build.execute()
                }
            }
        }
    }
}
