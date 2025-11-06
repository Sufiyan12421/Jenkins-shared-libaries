def call(Map config = [:]) {
    def repoUrl = config.repoUrl ?: error("Repository URL is required")
    def branch = config.branch ?: 'main'

    echo "This is cloning the code"
    git url: repoUrl, branch: branch
    echo "Code cloned successfully"
}
