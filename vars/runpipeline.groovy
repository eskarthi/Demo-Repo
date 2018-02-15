def call (String name = 'human') {

        stage('Build') {
          steps {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
          }
        }
	
      
    
}