pipeline {
    agent { label 'SHOPIZER'}
    triggers { cron '23 7 * * *'}
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
        stage('mergechanges') {
            steps {
                sh """
                git merge develop --no-ff
                """
            }
        }
    }
}
