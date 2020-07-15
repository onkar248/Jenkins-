`yum install epel-release -y`

`yum install java-1.8.0-openjdk.x86_64 -y`

`cp /etc/profile /etc/profile_backup`

`echo 'export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk' | tee -a /etc/profile`

`echo 'export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk' | tee -a /etc/profile`

`echo 'export JRE_HOME=/usr/lib/jvm/jre' | tee -a /etc/profile`

` wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo`

`rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key`

`yum install jenkins -y`

`systemctl start jenkins`

`systemctl enable jenkins`

