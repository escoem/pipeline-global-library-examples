package org.foo

import groovy.json.JsonSlurperClassic
import java.io.Serializable


class Builder extends Helper implements Serializable {
	def buildType
	def buildParams
	def buildOpts
	def branch
	def gitCred
	def gitRepo
	//private def defaultConfig
	

	Builder(script, String buildType, String buildParams, String branch, String gitCred, String gitRepo){
		super(script)
		this.buildType = buildType
		this.buildParams = buildParams
		this.branch = branch
		this.gitCred = gitCred
		this.gitRepo = gitRepo
	}
	
	Builder(){}
	
	def build() throws Exception{
		if(buildType == null || buildType  == ""){
			throw new Exception("buildType parameter cannot be blank")
		}
		if(buildParams == null || buildParams  == ""){
			throw new Exception("buildParams parameter cannot be blank")
		}
		if(script == null || script  == ""){
			throw new Exception("script parameter cannot be blank")
		}
		
		script.env.JAVA_HOME = "${script.tool defaultConfig.java.jenkins.version}"
		syncGit()
		compileCode()
		
	}
	
	protected def compileCode(){
		String buildCommand = constructBuildCommand()
		script.sh buildCommand
	}
	
	
	 String constructBuildCommand(){
		def toolConfig = defaultConfig[buildType]
		def opts = ''
		
		//Get our default arguments
		for(option in toolConfig.opts){
			opts <<= option + ' '
		}
		
		//Add user args 
		opts <<= buildParams
			
		//construct jenkins commands 
		String command = "${script.tool toolConfig.jenkins.version}${toolConfig.jenkins.exec_path} ${opts}"
		
		//println("${toolConfig.jenkins.version}${toolConfig.jenkins.exec_path} ${opts}")
		return command
	}
	
	protected def syncGit(){
		script.git branch: branch,
			credentialsId: gitCred,
			url: gitRepo
	}

}

