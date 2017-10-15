package org.foo.shared


public class Echoer {
  def steps;
  
  public Echoer(steps) {
    this.steps = steps;
  }

  public void print(msg) {
    steps.echo(msg)
  }

}
