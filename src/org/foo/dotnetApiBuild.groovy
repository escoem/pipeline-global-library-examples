package org.foo

class dotnetApiBuild {

String projectName
String projectDir

def execute()
{
    echo "Executing dotnetapiBuild. Project name: ${projectName}; Project dir: ${projectDir}"

    /*
    dotnet.restore path, jfrog.url_all_nuget
    dotnet.publish config.projectName, config.target
    rpm.build(config.projectName)
    jfrog.publish(config.projectName)
    */
}

}
