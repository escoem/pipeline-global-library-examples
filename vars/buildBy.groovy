//vars/buildBy.groovy
def call () {
  echo currentBuild.rawBuild.getActions(hudson.model.CauseAction.class).get(0).
        findCause(hudson.model.Cause.UserIdCause.class).getUserId()
  return currentBuild.rawBuild.getActions(hudson.model.CauseAction.class).get(0).
        findCause(hudson.model.Cause.UserIdCause.class).getUserId()
}
