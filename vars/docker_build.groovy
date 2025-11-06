def call(Map config = [:]) {
    def imageName = config.imageName
    def imageTag = config.imageTag ?: 'latest'
    def dockerfile = config.dockerfile ?: 'Dockerfile'
    def context = config.context ?: '.'

    if (!imageName) {
        error("Image name is required")
    }

    echo "🚀 Building Docker image: ${imageName}:${imageTag} using ${dockerfile}"

    sh """
        docker build -t ${imageName}:${imageTag} -t ${imageName}:latest -f ${dockerfile} ${context}
    """
}
