// vars/stringToMap.groovy
def call(data) {

  def result = data.split('\n').inject([:]) { map, token -> 
    token.split('=').with { map[it[0]] = it[1] }
    map 
  }

  return result
}
