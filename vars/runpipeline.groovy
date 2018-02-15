def call (String name = 'human') {

		node {
        stage('Pre Build') {
          steps {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
          }
        }
      }
    
}