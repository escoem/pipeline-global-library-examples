package org.foo

import foo.internal

class internal2 {

 def i = new internal()

def justSay(speech) {
  i.justSay(speech)
}

def hello(str) {
  i.hello(str)
}
}
