FROM amazoncorretto:17

WORKDIR /app

# jar 파일 이동
COPY build/libs/ReviewApplication-0.0.1-SNAPSHOT.jar /app/review.jar
COPY entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh

ENTRYPOINT ["/app/entrypoint.sh"]



