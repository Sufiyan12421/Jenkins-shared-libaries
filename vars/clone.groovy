def call(String url, String branch = 'main') {
    echo "🔄 Cloning repository from ${url} (branch: ${branch})"
    
    checkout([
        $class: 'GitSCM',
        branches: [[name: branch]],
        userRemoteConfigs: [[url: url]]
    ])
    
    echo "✅ Code cloned successfully."
}
