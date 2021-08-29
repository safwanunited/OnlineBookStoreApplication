pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3.8.1"
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: "main", url: 'https://github.com/safwanunited/OnlineBookStoreApplication.git'
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
                 // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                  sh "docker build -t OBSproject2 ."
                sh "docker container stop OBSproject2 || true"
                sh "docker container run --rm -d -p 8082:9090 --name OBSproject2 OBSproject2"
            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
