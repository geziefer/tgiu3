# game-service project

docker network create tgiu
docker network inspect tgiu

docker run --name mongo_container --network=tgiu -ti --rm -p 27017:27017 mongo:4.0

docker run --name gameservice_container --network=tgiu -e quarkus.mongodb.connection-string=mongodb://mongo_container:27017 -ti --rm -p 8080:8080 alexander.ruehl/game-service:1.0.0-SNAPSHOT

docker container ls
