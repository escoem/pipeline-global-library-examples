//vars/buildBy.groovy
def call () {
  return currentBuild.rawBuild.getActions(hudson.model.CauseAction.class).get(0).
        findCause(hudson.model.Cause.UserIdCause.class).getUserId()
}
