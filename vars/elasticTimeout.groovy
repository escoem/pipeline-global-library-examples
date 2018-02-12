// vars/elasticTimeout.groovy

def call(percent, maxBuilds, maxTimeout, Closure body) {
    def et = getElasticTimeout(percent, maxBuilds, maxTimeout)
    timeout (time: et, unit: 'MILLISECONDS') {
        body()
    }
}

def getElasticTimeout(percent, maxBuilds, maxTimeout) {
    def average = getAverage(maxBuilds)
    
    if (average == 0) {
        return maxTimeout
    } else {
        return percent * average
    }
    
}

def getAverage(maxBuilds) {
    def nonFailingBuilds = 0
    def duration = 0 
    def build = currentBuild.previousBuild
    
    if ( build != null && maxBuilds > 0) {
        if (build.resultIsBetterOrEqualTo("UNSTABLE")) {
            nonFailingBuilds = nonFailingBuilds + 1
            duration = duration + build.duration
        }
        
        while ( build != null && currentBuild.previousBuild != null && nonFailingBuilds < maxBuilds) {
            build = build.previousBuild
            if (build != null && build.resultIsBetterOrEqualTo("UNSTABLE")) {
                nonFailingBuilds = nonFailingBuilds + 1
                duration = duration + build.duration
            }
        }
    }
    
    return nonFailingBuilds > 0 ? duration / nonFailingBuilds : 0
}


