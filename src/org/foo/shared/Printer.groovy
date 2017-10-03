package org.foo.shared


public class Printer {
  def script;
  
  public Printer(script) {
    this.script = script;
  }

  public void print(msg) {
    script.echo(msg)
  }

}
