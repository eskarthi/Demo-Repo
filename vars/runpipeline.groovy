def call(body) {
	
			def config = [:]
			body.resolveStrategy = Closure.DELEGATE_FIRST
			body.delegate = config
			body()
	
			pipeline {
				agent any
			
			node {
				def mvnHome
				// Clean workspace before doing anything
				//deleteDir()
	
				try {
					stage ('Preparation') {
						//checkout scm
						echo "Triggered by, ${config.user}"
						// Get some code from a GitHub repository
						git 'https://github.com/eskarthi/simple-java-maven-app.git'
	
						mvnHome = tool 'Maven3.5.2'
					}
					stage ('Build') {
						echo "building ${config.projectName} ..."
						bat(/"${mvnHome}\bin\mvn" -B -DskipTests clean package/)
					}
					stage ('Tests') {
						parallel 'static': {
							echo "shell scripts to run static tests..."
						},
						'unit': {
							echo "shell scripts to run unit tests..."
							bat(/"${mvnHome}\bin\mvn" test/)
							
						},
						'close': {
							echo "Generate test report..."
							junit '**/target/surefire-reports/*.xml'
						}
					}
					stage ('Deploy') {
						echo "deploying to server ${config.serverDomain}..."
					}
				} catch (err) {
					currentBuild.result = 'FAILED'
					throw err
				}
			}
			}
		}

