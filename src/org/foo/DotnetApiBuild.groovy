package org.foo

class DotnetApiBuild {

    String projectName
    String projectDir
    def script
    
    DotnetApiBuild(script) {
        this.script = script
    }
    
def execute()
{
    script.echo "Executing dotnetapiBuild. Project name: ${projectName}; Project dir: ${projectDir}"

    /*
    dotnet.restore path, jfrog.url_all_nuget
    dotnet.publish config.projectName, config.target
    rpm.build(config.projectName)
    jfrog.publish(config.projectName)
    */
}

}
