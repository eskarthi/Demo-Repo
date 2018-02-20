def call(body) {

	def config = [:]
	body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
	body()


	node {
		def mvnHome
		def demo_utils = new com.cicd.practice.Utilities()
		// Clean workspace before doing anything
		//deleteDir()

		try {
			stage ('Preparation') {
				//checkout scm
				echo "Triggered by, ${config.user}"
			
				demo_utils.checkOutFrom("${config.projectName}")
				//simple-java-maven-app

				mvnHome = tool 'Maven3.5.2'
			}

			stage ('Build') {
				echo "building ${config.projectName} ..."
				bat(/"${mvnHome}\bin\mvn" -B -DskipTests clean package/)
			}

			stage ('Tests') {
				echo "shell scripts to run unit tests..."
				bat(/"${mvnHome}\bin\mvn" test/)
			}
			stage ('Test Result') {
				echo "Generate test report..."
				junit '**/target/surefire-reports/*.xml'
			}

			stage ('Deploy') {  echo "deploying to server ${config.serverDomain}..."  }

		} catch (err) {
			currentBuild.result = 'FAILED'
			throw err
		}
	}

}

