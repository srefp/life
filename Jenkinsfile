pipeline {
    agent any

    stages {
        stage('拉取代码') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'eeadecc6-32ca-4c6d-95ab-3ee1303aeec0', url: 'http://gitlab.webj.top:88/sr_group/frp_demo.git']]])
            }
        }
        stage('代码审查') {
            steps {
                script {
                    // 引入SonarQubeScanner工具
                    scannerHome = tool 'sonar-scanner'
                }
                // 引入SonarQube的服务器环境
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
            }
        }
        stage('编译打包') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
    post {
        always {
            emailext(
                    subject: '构建通知：${PROJECT_NAME} - Build # ${BUILD_NUMBER} - ${BUILD_STATUS}!',
                    body: '${FILE,path="email.html"}',
                    to: '1903994095@qq.com'
            )
        }
    }
}