pipeline{
  agent any
  tools{
    maven 'default'
  }
  stages{
    stage('Integration Test'){
    agent{ label 'master' }
      steps{
        sh "mvn '-Dtest=*/rsvp/*' test"
      }
    }
    tage('Cucumber Test'){
    agent{ label 'master' }
      steps{
        sh "mvn '-Dtest=*/RunCucumberTest.java' test"
      }
    }
  }
}
