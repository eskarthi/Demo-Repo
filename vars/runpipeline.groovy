def call (String name = 'human') {

		stages {
        stage('Even Stage') {
          steps {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
          }
        }
      }
    
}