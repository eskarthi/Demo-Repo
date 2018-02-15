def call (String name = 'human') {
	pipeline {
		agent any
		environment { // global settings
				mvnHome = tool 'Maven3.5.2'
		}	
		 // Scripted Pipeline
		stages {
        stage('Even Stage') {
          steps {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
          }
        }
      }
    }
}