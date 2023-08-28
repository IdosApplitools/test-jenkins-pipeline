pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository using the SSH URL
                checkout([$class: 'GitSCM',
                  branches: [[name: '*/main']],
                  userRemoteConfigs: [[url: 'https://github.com/IdosApplitools/test-jenkins-pipeline.git']]])
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
