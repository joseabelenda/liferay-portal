FROM liferay/jar-runner:latest

COPY --chown=liferay:liferay *.jar /opt/liferay/jar-runner.jar
COPY --chown=liferay:liferay *9.json /opt/liferay/resources.json

#ENV JAVA_VERSION="zulu21"
#ENV LIFERAY_JAR_RUNNER_JAVA_OPTS="-Xmx512m"