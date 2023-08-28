pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository using the SSH URL
                checkout([$class: 'GitSCM',
                  branches: [[name: '*/master']],
                  userRemoteConfigs: [[url: 'git@github.com:applitools/tutorial-images-java.git']]])
            }
        }
        stage('Start Applitools') {
          steps {
            Applitools () {
              echo "Starting Applitools"
              mvn test
            }
        }
    }
}