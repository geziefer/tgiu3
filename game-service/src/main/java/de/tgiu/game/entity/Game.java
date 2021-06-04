package de.tgiu.game.entity;

public class Game {
    public String name;
    public Size size;

    public Game(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
