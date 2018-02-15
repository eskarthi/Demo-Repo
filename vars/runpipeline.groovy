def call (String name = 'human') {
	pipeline {
		agent any
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