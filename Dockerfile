FROM bellsoft/liberica-openjdk-alpine:17
ADD . /action
RUN cd /action && ./gradlew --no-daemon installDist
ENTRYPOINT ["/action/build/dist/bin/issue-action"]
