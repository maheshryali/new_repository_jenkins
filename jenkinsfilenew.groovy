pipeline {
    agent { label 'SHOPIZER'}
    stages{
        stage('vcs') {
            steps {
            git branch:'master',
                   url: 'https://github.com/maheshryali/shopizer.git'
            }
        }
        stage('maven') {
            steps {
                sh 'mvn package'
            }

        }
    }
}