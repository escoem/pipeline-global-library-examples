import org.foo.Builder

def call(buildType, buildParams, branch, gitCred, gitRepo){	
	def builder = new Builder(this, buildType, buildParams, branch, gitCred, gitRepo)
	builder.build()
}
