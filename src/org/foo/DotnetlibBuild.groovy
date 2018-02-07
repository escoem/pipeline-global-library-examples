package org.foo

class DotnetlibBuild {
    
    String projectName
    String projectDir
    def script
    
    DotnetlibBuild(script) {
        this.script = script
    }
    
def execute()
{
    script.echo "Executing dotnetlibBuild. Project name: ${projectName}; Project dir: ${projectDir}"

    script.dotnet.restore "path"
    
    /*
    dotnet.restore path, jfrog.url_all_nuget
    dotnet.publish config.projectName, config.target
    rpm.build(config.projectName)
    jfrog.publish(config.projectName)
    */
}

}
