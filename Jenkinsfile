pipeline{
  agent any
  tools{
    maven 'default'
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
