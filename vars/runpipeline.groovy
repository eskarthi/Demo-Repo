def call (String name = 'human') {

    node {
	
		def mvnHome
		stage('Preparation') { // for display purposes
		// Get some code from a GitHub repository
		git 'https://github.com/jglick/simple-maven-project-with-tests.git'
		// Get the Maven tool.
		// ** NOTE: This maven tool configured
		// **       in the global configuration.           
		mvnHome = tool 'Maven3.5.2'
		}
        
		stage ('Build') {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
			bat(/"${mvnHome}\bin\mvn" -B -DskipTests clean package/)
          }
        }
}