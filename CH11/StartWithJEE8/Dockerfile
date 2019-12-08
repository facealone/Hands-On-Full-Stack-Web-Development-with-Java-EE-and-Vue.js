FROM airhacks/glassfish

RUN curl -o ${INSTALL_DIR}/mysql-connector-java-8.0.18.zip -L https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.18.zip \ 
    && unzip ${INSTALL_DIR}/mysql-connector-java-8.0.18.zip -d ${INSTALL_DIR} \ 
    && rm ${INSTALL_DIR}/mysql-connector-java-8.0.18.zip \ 
    && cp ${INSTALL_DIR}/mysql-connector-java-8.0.18/mysql-connector-java-8.0.18.jar ${GLASSFISH_HOME}/domains/${DOMAIN_NAME}/lib/mysql-connector-java-8.0.16.jar \ 
    && rm -R ${INSTALL_DIR}/mysql-connector-java-8.0.18

COPY StartWithJEE8-ear/target/StartWithJEE8-ear-1.0-SNAPSHOT.ear .
COPY docker .
ENTRYPOINT sh docker-entrypoint.sh
