def call(appenviron_properties) {

  echo appenviron_properties.getModuleDir()
  testCheckpoint ('first')

  node ('master') {
    echo 'inside master'
    echo appenviron_properties.getModuleDir()
    echo 'yes'
  }

}

@NonCPS
def testCheckpoint(state){
    try {
        checkpoint(state)
    } catch (NoSuchMethodError _) {
        echo 'Checkpoint feature available in CloudBees Jenkins Enterprise.'
    }
}
Contact GitHub API Training Shop Blog About
