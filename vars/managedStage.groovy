// vars/managedStage.groovy
def call(String stageName, String userId, Closure body) {
  String builder = currentBuild.rawBuild.getActions(hudson.model.CauseAction.class).get(0).
        findCause(hudson.model.Cause.UserIdCause.class).getUserId()
  if (builder == userId) {
    stage(stageName) {
      body()
    }
  } else {
     echo "skiping stage $stageName because $builder is not allowed $builder != $userId" 
  }
}
