def call (String name = 'human') {
	def  mvnHome = 'C:\Tools\apache-maven-3.5.2'
    node {
          stage ('Build') {
            echo "The build number is ...."
			echo "Triggered by, ${name}."
			bat(/"${mvnHome}\bin\mvn" -B -DskipTests clean package/)
          }
        }
}