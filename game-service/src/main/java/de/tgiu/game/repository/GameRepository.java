package de.tgiu.game.repository;

import de.tgiu.game.entity.Game;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;

@ApplicationScoped
public class GameRepository {
    // TODO: in-memory storage for Game objects as 1st step, needs to be replaced by database
    private HashMap<String, Game> games;

    {
        games = new HashMap<>();
    }

    public Collection<Game> getGames() {
        return games.values();
    }

    public Game getGame(String name) {
        Game game = games.get(name);
        return game;
    }

    public void saveOrUpdateGame(Game game) {
        games.put(game.name, game);
    }

    public Game deleteGame(String name) {
        return games.remove(name);
    }
}
