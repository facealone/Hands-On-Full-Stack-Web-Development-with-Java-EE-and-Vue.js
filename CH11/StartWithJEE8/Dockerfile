FROM airhacks/glassfish

ARG ENV_ARG
ENV ENV=$ENV_ARG

RUN curl -o ${INSTALL_DIR}/mysql-connector-java-8.0.18.zip -L https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.18.zip \ 
    && unzip ${INSTALL_DIR}/mysql-connector-java-8.0.18.zip -d ${INSTALL_DIR} \ 
    && rm ${INSTALL_DIR}/mysql-connector-java-8.0.18.zip \ 
    && cp ${INSTALL_DIR}/mysql-connector-java-8.0.18/mysql-connector-java-8.0.18.jar ${GLASSFISH_HOME}/domains/${DOMAIN_NAME}/lib/mysql-connector-java-8.0.16.jar \ 
    && rm -R ${INSTALL_DIR}/mysql-connector-java-8.0.18

COPY docker .

RUN keytool -import -trustcacerts -alias awsidp -storepass changeit -noprompt -file ${GLASSFISH_HOME}/bin/cacerts/cognito-idp.us-east-1.amazonaws.com -keystore ${GLASSFISH_HOME}/domains/domain1/config/cacerts.jks \ 
    && keytool -import -trustcacerts -alias awsauth -storepass changeit -noprompt -file ${GLASSFISH_HOME}/bin/cacerts/_.auth.us-east-1.amazoncognito.com -keystore ${GLASSFISH_HOME}/domains/domain1/config/cacerts.jks \ 
    && keytool -import -trustcacerts -alias awss3g -storepass changeit -noprompt -file ${GLASSFISH_HOME}/bin/cacerts/_.s3.amazonaws.com -keystore ${GLASSFISH_HOME}/domains/domain1/config/cacerts.jks \ 
    && keytool -import -trustcacerts -alias awss3 -storepass changeit -noprompt -file ${GLASSFISH_HOME}/bin/cacerts/s3.amazonaws.com -keystore ${GLASSFISH_HOME}/domains/domain1/config/cacerts.jks
   
COPY StartWithJEE8-ear/target/StartWithJEE8-ear-1.0-SNAPSHOT.ear .

ENTRYPOINT sh docker-entrypoint.sh
