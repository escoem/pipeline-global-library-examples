package org.foo

class DotnetlibBuild {
    
    String projectName
    String projectDir
    def steps
    
    DotnetlibBuild(steps) {
        this.steps = steps
    }
    
def execute()
{
    steps.echo "Executing dotnetlibBuild. Project name: ${projectName}; Project dir: ${projectDir}"

    steps.dotnet.restore "path"
    
    /*
    dotnet.restore path, jfrog.url_all_nuget
    dotnet.publish config.projectName, config.target
    rpm.build(config.projectName)
    jfrog.publish(config.projectName)
    */
}

}
