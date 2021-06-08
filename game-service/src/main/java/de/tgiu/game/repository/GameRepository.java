package de.tgiu.game.repository;

import de.tgiu.game.entity.Game;
import de.tgiu.game.entity.Size;

import javax.enterprise.context.RequestScoped;
import java.util.Collection;
import java.util.HashMap;

@RequestScoped
public class GameRepository {
    // TODO: in-memory storage for Game objects as 1st step, needs to be replaced by database
    private HashMap<String, Game> games;

    {
        games = new HashMap<>();
        // insert initial games for getting an answer since it is currently stateless
        games.put("game1", new Game("game1", Size.LARGE));
        games.put("game2", new Game("game2", Size.MEDIUM));
        games.put("game3", new Game("game3", Size.SMALL));
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
