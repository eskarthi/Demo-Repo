def call (String name = 'human') {

        stage('Pre Build') {
          steps {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
          }
        }
      
    
}