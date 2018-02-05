package org.foo

String projectName
String projectDir

def execute()
{
    echo "Executing dotnetlibBuild. Project name: ${projectName}; Project dir: ${projectDir}"

    /*
    dotnet.restore path, jfrog.url_all_nuget
    dotnet.publish config.projectName, config.target
    rpm.build(config.projectName)
    jfrog.publish(config.projectName)
    */
}

return this
