def call(Map config = [:]) {
    def imageName = config.imageName ?: error("Image name is required")
    def imageTag = config.imageTag ?: 'latest'
    def credentials = config.credentials ?: 'docker-hub-credentials'
    
    echo "Pushing Docker image: ${imageName}:${imageTag}"
    
    withCredentials([usernamePassword(
        credentialsId: 'dockerHubCred',
        usernameVariable: 'dockerHubuser',
        passwordVariable: 'dockerHubPass'
    )]) {
        sh """
            echo "\$DOCKER_PASSWORD" | docker login -u ${dockerhubuser} -p ${dockerhubpass}"
            docker push ${imageName}:${imageTag}
            docker push ${imageName}:latest
        """
    }
}
