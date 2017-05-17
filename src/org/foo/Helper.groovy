package org.foo

@GrabResolver(name='rnd-rpo', root='https://rpo-rnd.pncint.net/artifactory/rpo-maven-release/', m2compatible = 'true' )
//@Grab('xerces:xercesImpl:2.62')
@Grab('org.yaml:snakeyaml:1.17')

//@GrabExclude('xml-apis:xml-apis')
//@GrabExclude('xerces:xercesImpl')
//@GrabExclude('joda-time:joda-time')

import groovy.json.JsonSlurperClassic
import org.yaml.snakeyaml.Yaml

class Helper {
	public def script
	public def defaultConfig
	
	Helper(script){
		this.script = script
		defaultConfig = loadDefaults()
	}
	
	Helper(){
		//defaultConfig = loadDefaults()
	}
	
	@NonCPS
	protected HashMap loadDefaults(){
		def json = '''{
	"artifactory": {
		"url": "https://artifactory"
	},
    	"java": {
		"jenkins": {
			"version": "Oracle JDK 1.8.0_92"
		}
	}
}'''
		//def json = getClass().getResource('defaults.json').text
		//def json = new File('../resources/com/pnc/defaults.json').text
		//def json = new File(getClass().getResource('resources/defaults.json').toURI()).text
		def defaultConfig = new JsonSlurperClassic().parseText(json)
		return defaultConfig
	}
	

	protected checkParam(param, String paramName) throws Exception{
		if(param == null || param  == ""){
			throw new Exception("${paramName} parameter cannot be blank")
		}
	}
	
	protected getCredsById(cred){
		/* This is a workaround function to get around the artifactory plugin passing credentials along as NA */
		
		script.withCredentials([
			[$class: 'UsernamePasswordMultiBinding', credentialsId: cred,
				usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']
		]) {

			return ['user' : script.USERNAME, 'pass': script.PASSWORD]
		}
		

	}
	

}
