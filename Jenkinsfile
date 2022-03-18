pipeline {
    agent any
	tools {
	       maven 'Maven'
	}

stages {
        stage('SCM Checkout'){
               steps {
	               checkout scm
	       }
        }
 
        stage('Build') {
               steps {
                       container('maven') {
                       sh 'mvn package'
                       }
               }
        }

} 
}
