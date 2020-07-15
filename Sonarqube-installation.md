### sonarqube_installation

```yum install epel-release wget unzip vim -y

yum install java

rpm -ivh https://download.bell-sw.com/java/11.0.4/bellsoft-jdk11.0.4-linux-amd64.rpm

rpm -ivh http://repo.mysql.com/mysql57-community-release-el7.rpm
```
-------------------------
### mysql_setup


```yum install mysql-server -y ```

```echo 'vm.max_map_count=262144' >/etc/sysctl.conf ```

```sysctl -p ```

```echo '* - nofile 80000' >>/etc/security/limits.conf```

```sed -i -e '/query_cache_size/ d' -e '$ a query_cache_size = 15M' /etc/my.cnf ```

```systemctl start mysqld```

```grep 'password' /var/log/mysqld.log ##to get temp passwd from logs```

```mysql_secure_installation```

```
mysql -p u root
	
    create database if not exists sonarqube;
	grant all privileges on sonarqube.* to 'sonarqube'@'localhost' identified by 'Cloudblitz@123';
	flush privileges; 
```    

### sonarqube_setup
```
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-7.9.1.zip

unzip sonarqube-7.9.1.zip

mv /sonarqube-7.9.1/* /opt/sonar
	
sed -i -e '/^sonar.jdbc.username/ d' -e '/^sonar.jdbc.password/ d' -e '/^sonar.jdbc.url/ d' -e '/^sonar.web.host/ d' -e '/^sonar.web.port/ d' /opt/sonar/conf/sonar.properties	

sed -i -e '/#sonar.jdbc.username/ a sonar.jdbc.username=sonarqube' -e '/#sonar.jdbc.password/ a sonar.jdbc.password=Cloudblitz@123' -e '/InnoDB/ a sonar.jdbc.url=jdbc:mysql://localhost:3306/sonarqube?useUnicode=true&amp;characterEncoding=utf8&amp;rewriteBatchedStatements=true&amp;useConfigs=maxPerformance' -e '/#sonar.web.host/ a sonar.web.host=0.0.0.0' /opt/sonar/conf/sonar.properties

useradd sonar

chown sonar:sonar /opt/sonar -R

sed -i -e '/^#RUN_AS_USER/ c RUN_AS_USER=sonar' /opt/sonar/bin/linux-x86-64/sonar.sh

vim /opt/sonar/conf/wrapper.conf
     wrapper.java.command=/usr/lib/jvm/bellsoft-java11.x86_64/bin/java

to start sonarqube
    /opt/sonar/bin/linux-x86-64/sonar.sh start
	
to check status 
    /opt/sonar/bin/linux-x86-64/sonar.sh status

If facing any issue
    /opt/sonar/logs/sonar.log    
```