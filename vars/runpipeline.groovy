def call (String name = 'human') {

    node {
          stage ('Build') {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
			bat(/"C:\Tools\apache-maven-3.5.2\bin\mvn" -B -DskipTests clean package/)
          }
        }
}