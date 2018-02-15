def call (String name = 'human') {
        node {
          stage ('build') {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
          }
        }
}