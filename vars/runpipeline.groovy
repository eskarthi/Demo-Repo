def call (String name = 'human') {

    node {
		def mvnHome
		stage('Preparation') { // for display purposes
		    workspace ='C:\My Data\Jenkins\workspace\Java-Projects\'
	        echo "The build number is ...."
			echo "Triggered by, ${name}."
			// Get some code from a GitHub repository
			//git 'https://github.com/eskarthi/simple-java-maven-app.git'
			bat(/"cd ${workspace}\simple-java-maven-app"/)
			// Get the Maven tool.
			// ** NOTE: This maven tool configured
			// **       in the global configuration.           
			mvnHome = tool 'Maven3.5.2'
		}
        
		stage ('Build') {
    		bat(/"${mvnHome}\bin\mvn" -B -DskipTests clean package/)
        }
		
		stage('Test') {
			bat(/"${mvnHome}\bin\mvn" test/)
		}
		stage ('close') {
			junit '**/target/surefire-reports/*.xml'
		}
			
        }
}