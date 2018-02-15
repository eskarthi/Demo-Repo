def call (String name = 'human') {

    node {
		def mvnHome
		stage('Preparation') { // for display purposes
	        echo "The build number is ...."
			echo "Triggered by, ${name}."
			// Get some code from a GitHub repository
			git 'https://github.com/eskarthi/simple-java-maven-app.git'
			// Get the Maven tool.
			// ** NOTE: This maven tool configured
			// **       in the global configuration.           
			mvnHome = tool 'Maven3.5.2'
		}
        
		stage ('Build') {
    		bat(/"${mvnHome}\bin\mvn" -B -DskipTests clean package/)
          }
		
		stage('Test') {
				steps {
					bat(/"${mvnHome}\bin\mvn" test/)
				}
				post {
					always {
					   junit '**/target/surefire-reports/*.xml'
					}
				}
			}
        }
}