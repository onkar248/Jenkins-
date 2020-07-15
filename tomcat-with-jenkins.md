vim /opt/tomcat/conf/tomcat-users.xml
 
 
    <role rolename="admin-gui"/>
    <role rolename="manager-gui"/>
    <role rolename="manager-status"/>
    <role rolename="manager-script"/>
    <role rolename="manager-jmx"/>
    <user username="tomcat" password="redhat" roles="admin-gui,manager-gui,manager-status,manager-script,manager-jmx"/>


