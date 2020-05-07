pipeline{
  agent none
  stages{
    stage('Test'){
    agent{ label 'master' }
      steps{
        sh 'export MAVEN_HOME=/usr/local/Cellar/maven/3.6.3_1/libexec'
        sh 'export PATH=$PATH:$MAVEN_HOME/bin'
        sh 'mvn test'
      }
    }
  }
}
