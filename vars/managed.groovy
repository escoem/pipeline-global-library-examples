
// vars/managed.groovy
def call(String userId, Closure body) {
  String builder = currentBuild.rawBuild.getActions(hudson.model.CauseAction.class).get(0).
        findCause(hudson.model.Cause.UserIdCause.class).getUserId()
  if (builder == userId) {
     body()
  } else {
     echo "skiping because $builder is not allowed ($builder != $userId)" 
  }
}
