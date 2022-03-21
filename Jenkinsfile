pipeline {
agent any
tools {
maven 'Maven3.6.3'
jdk 'jdk11'
}
stages {
stage ('Initialize') {
steps {
bat """
echo "PATH = ${path}"
echo "M2_HOME = ${M2_HOME}"
"""
}
}



stage ('Build') {
steps {
bat "mvn clean install"
}
}
}
}