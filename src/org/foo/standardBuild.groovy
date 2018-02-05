package org.foo

class standardBuild implements Serializable {
    
def api; 
def lib;
def script;
    
standardBuild (script) {
    this.script = script
}
    
def dotnetapi(cfg)
{
    def build = new dotnetApiBuild()
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()
    //api = build
    script.standardBuildSpec.builds[build.projectName] = build
}

def dotnetlib(cfg)
{
    def build = new dotnetlibBuild()
    cfg.resolveStrategy = Closure.DELEGATE_FIRST
    cfg.delegate = build
    cfg()
    lib = build
    script.standardBuildSpec.builds[build.projectName] = build
}

def execute()
{
    node ()
    {
       for (build in standardBuildSpec.builds)
       {
            stage (build.projectName) 
            {
                build.execute()
            }
        }
    }
}
}
