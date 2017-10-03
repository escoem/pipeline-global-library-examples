// vars/pattern.groovy
def call(nodeName, notifyFailureGroup, script, body) {
    echo nodeName
    body()
    echo notifyFailureGroup
    (new org.foo.shared.Printer(script)).print(nodeName)
}
