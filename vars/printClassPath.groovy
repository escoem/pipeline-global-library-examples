def printClassPath(classLoader) {
  System.out.print ("$classLoader")
  classLoader.getURLs().each {url->
     System.out.println ("- ${url.toString()}")
  }
  if (classLoader.parent) {
     printClassPath(classLoader.parent)
  }
}
//printClassPath this.class.classLoader
