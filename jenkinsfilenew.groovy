pipeline {
    agent { label 'SHOPIZER'}
    triggers { cron '42 7 * * *'}
    stages{
        stage('vcs') {
            steps {
            git branch:'promote',
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
