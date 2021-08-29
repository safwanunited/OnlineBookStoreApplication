# we will use tomcat 9
FROM tomcat:9.0
# copy the packaged war file into webapps directory of tomcat
COPY target/BookStore-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/
# set the startup command to execute the tomcat server
CMD ["java", "-jar", "BookStore-0.0.1-SNAPSHOT.jar "]