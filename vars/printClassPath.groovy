@NonCPS def call(classLoader) {
  System.out.print ("$classLoader")
  //((groovy.lang.GroovyClassLoader.InnerLoader)classLoader).getURLs().each {url->
  /*classLoader.getURLs().each {url->
     System.out.println ("- ${url.toString()}")
  }*/
  if (classLoader.parent) {
     printClassPath(classLoader.parent)
  }
}
//printClassPath this.class.classLoader
