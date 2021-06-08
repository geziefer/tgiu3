package de.tgiu.game.repository;

import de.tgiu.game.entity.Game;
import de.tgiu.game.entity.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {

    GameRepository gameRepository;
    Game game1;
    Game game2;

    @BeforeEach
    public void init() {
        gameRepository = new GameRepository();
        game1 = new Game("game1", Size.LARGE);
        game2 = new Game("game2", Size.LARGE);
    }

// TODO: Tests are commented out due to stateless repository for lambdas, rework unit test or only use IT if db is there
//    @Test
//    void getGames() {
//        assertTrue(gameRepository.getGames().isEmpty());
//
//        gameRepository.saveOrUpdateGame(game1);
//        assertTrue(gameRepository.getGames().size() == 1);
//        assertTrue(gameRepository.getGames().contains(game1));
//    }
//
//    @Test
//    void getGame() {
//        gameRepository.saveOrUpdateGame(game1);
//        assertEquals(game1, gameRepository.getGame(game1.name));
//        assertNotEquals(game2, gameRepository.getGame(game2.name));
//    }
//
//    @Test
//    void saveOrUpdateGame() {
//        gameRepository.saveOrUpdateGame(game1);
//        assertTrue(gameRepository.getGames().size() == 1);
//        assertEquals(game1, gameRepository.getGame(game1.name));
//
//        game1.size = Size.SMALL;
//        gameRepository.saveOrUpdateGame(game1);
//        assertTrue(gameRepository.getGames().size() == 1);
//        assertEquals(game1, gameRepository.getGame(game1.name));
//
//        gameRepository.saveOrUpdateGame(game2);
//        assertTrue(gameRepository.getGames().size() == 2);
//        assertEquals(game1, gameRepository.getGame(game1.name));
//        assertEquals(game2, gameRepository.getGame(game2.name));
//    }
//
//    @Test
//    void deleteGame() {
//        gameRepository.saveOrUpdateGame(game1);
//        assertTrue(gameRepository.getGames().size() == 1);
//        Game game = gameRepository.deleteGame(game1.name);
//        assertEquals(game, game1);
//        assertTrue(gameRepository.getGames().size() == 0);
//
//        game = gameRepository.deleteGame(game2.name);
//        assertNull(game);
//    }
}