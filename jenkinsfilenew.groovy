pipeline {
    agent { label 'SHOPIZER'}
    triggers { cron '10 8 * * *'}
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
        stage('merge') {
            steps {
                sh """
                git checkout release
                git merge develop --no-ff
                """
            }
        }
    }
}
