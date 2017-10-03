// vars/pattern.groovy
def call(nodeName, notifyFailureGroup, script, body) {
    echo nodeName
    body()
    echo notifyFailureGroup
    script.echo nodeName
}
