pipeline{
  agent none
  stages{
    stage('Test'){
    agent{ label 'master' }
      steps{
        sh 'export M2_HOME=/usr/local/Cellar/maven/3.6.3_1/libexec'
        sh 'export PATH=$PATH:$M2_HOME/bin'
        sh 'mvn test'
      }
    }
  }
}
