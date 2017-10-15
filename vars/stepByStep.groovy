// vars/stepByStep.groovy

def call() {

  def echoer = new org.foo.shared.Echoer(steps)

  echoer.print("hola")
}
