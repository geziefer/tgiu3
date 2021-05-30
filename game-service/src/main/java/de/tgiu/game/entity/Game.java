package de.tgiu.game.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Game extends PanacheMongoEntity {
    public String name;
    public Size size;

    public Game() {

    }

    public Game(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    public static Game findByName(String name) {
        return find("name", name).firstResult();
    }

}
