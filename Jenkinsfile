pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B clean package'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
             }
        }
    }
}