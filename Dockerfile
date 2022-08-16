FROM openjdk:jre-alpine
VOLUME /tmp
ADD  ./target/roman-numerals-1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT exec java -jar /app.jar
