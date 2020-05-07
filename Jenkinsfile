pipeline{
  agent none
  tools {
    maven 'M3'
  }
  stages{
    stage('Test'){
    agent{ label 'master' }
      steps{
        sh 'mvn test'
      }
    }
  }
}
