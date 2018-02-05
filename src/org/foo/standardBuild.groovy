package org.foo

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
