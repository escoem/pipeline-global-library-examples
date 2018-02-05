package org.foo
    
def api; 
def lib;

    
def dotnetapi(cfg)
{
    def build = new dotnetApiBuild()
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()
    //api = build
    Builds.builds[build.projectName] = build
}

def dotnetlib(cfg)
{
    def build = new dotnetlibBuild()
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()
    lib = build
    Builds.builds[build.projectName] = build
}

def execute()
{
    node ()
    {
       for (build in Builds.builds)
       {
            stage (build.projectName) 
            {
                build.execute()
            }
        }
    }
}

