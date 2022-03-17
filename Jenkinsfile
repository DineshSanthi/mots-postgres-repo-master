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

        stage("Docker build"){
                              sh 'docker version'
                              sh 'docker build -t mots-postgres-repo .'
                              sh 'docker image list'
                              sh 'docker tag mots-postgres-repo dineshsanthi05/mots-postgres-repo'
        } 

        stage("Push Image to Docker Hub"){
                                          withDockerRegistry(credentialsId: 'dockerhub', url: 'https://hub.docker.com/') {
                                          sh 'docker push dineshsanthi05/mots-postgres-repo'
                                          }
        }

        stage('Kubernetes Deploy') {
                                   withKubeConfig(caCertificate: '', clusterName: 'Kubernetes', contextName: '', credentialsId: 'kubeconfig', namespace: 'kube-system', serverUrl: 'https://192.168.1.131:6443') {
                                   sh 'kubectl apply -f deployment.yaml'
                                   }
	}
}
} 
