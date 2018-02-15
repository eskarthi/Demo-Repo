def call (String name = 'human') {
	pipeline {
		agent any
		environment { // global settings
				mvnHome = tool 'Maven3.5.2'
		}	
		 // Scripted Pipeline
    	echo "Triggered by, ${name}."
		
	}
}