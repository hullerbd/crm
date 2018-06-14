pipeline {
  agent {
    docker {
      image 'jamesbusyqa/crm'
    }

  }
  stages {
    stage('docker') {
      steps {
        build 'docker'
      }
    }
  }
}