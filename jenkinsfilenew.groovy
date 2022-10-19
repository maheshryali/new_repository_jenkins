pipeline {
    agent { label 'SHOPIZER'}
    triggers { cron '30 7 * * *'}
    stages{
        stage('vcs') {
            steps {
            git branch:'release',
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
