emp# DevOps-B3

# DevOps-B1

Jenkins Installation

    yum install epel-release wget -y
    yum install java-1.8.0-openjdk.x86_64 -y
    java -version
    cp /etc/profile /etc/profile_backup
    echo 'export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk' | tee -a /etc/profile
    echo 'export JRE_HOME=/usr/lib/jvm/jre' | tee -a /etc/profile
    tail /etc/profile
	source /etc/profile
    echo $JAVA_HOME
    echo $JRE_HOME
    wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo
    rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
    yum install jenkins -y
    systemctl start jenkins
	systemctl enable jenkins
	
	
	
Declarative:

    Declarative pipeline syntax offers an easy way to create pipelines. 
    It contains a predefined hierarchy to create Jenkins pipelines. 
    It gives you the ability to control all aspects of a pipeline execution in a simple, straight-forward manner.

Scripted:

    Scripted Jenkins pipeline runs on the Jenkins master with the help of a lightweight executor.
    It uses very few resources to translate the pipeline into atomic commands. 
    Both declarative and scripted syntax are different from each other and are defined totally differently. 	


seed jobs / Job Recovery:
    
    plugin name : 1.seed jobs
                  2.authorized project and configure it from global config | Access Control for Builds

seed jobs templet making:
        https://github.com/atulyw/jenkinsxml2jobdsl
        java and maven in required in jenkins server

        git clone https://github.com/atulyw/jenkinsxml2jobdsl
        cd jenkinsxml2jobdsl
        ./gradlew build
        java -jar build/libs/jenkinsxml2jobdsl.jar -u <jenkins username> -a <password> -j <jenkins server> -p <jenkins port> job1 job2 ... jobN


GitHub WebHook:
       
    ``    setting -> webhooks -> addwebhooks -> http://3.135.241.237:8080/github-webhook/  ``
