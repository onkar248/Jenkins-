node {
    a=10
    stage('stage1'){
        git 'https://github.com/atulyw/hello-world.git'
    }
    stage('stage2'){
        sh label: '', script: 'echo "welcome to cbz"'
    }
    stage('stage3'){
        print '$a'
    }
}
