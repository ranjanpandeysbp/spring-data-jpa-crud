pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                bat "rmdir  /s /q spring-data-jpa-crud"
                bat "git clone https://github.com/ranjanpandeysbp/spring-data-jpa-crud.git"
                bat "mvn clean -f spring-data-jpa-crud"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f spring-data-jpa-crud"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f spring-data-jpa-crud"
            }
        }
        stage('SonarQube Analysis') {
                    steps {
                        script{
                            withSonarQubeEnv('SonarQubeServer'){
                                bat "mvn clean deploy sonar:sonar"
                            }
                            timeout(time: 1, unit: 'HOURS'){
                            def qg = waitForQualityGate()
                                if(qg.status != 'OK'){
                                    error "Pipeline aborted quality gate failure: ${qg.status}"
                                }
                            }
                            bat "mvn clean install"
                        }
                    }
        }
        stage('package') {
            steps {
                bat "mvn package -f spring-data-jpa-crud"
            }
        }
    }
}