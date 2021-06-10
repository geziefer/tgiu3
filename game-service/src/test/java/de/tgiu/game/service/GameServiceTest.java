package de.tgiu.game.service;

import de.tgiu.game.entity.Size;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class GameServiceTest {
    @Test
    void crudGames() {
        // 0) delete possibly existing test values
        given().pathParam("name", "test_game1").when().delete("games/{name}");

        // 1) empty games at start
        when().get("/games").then().statusCode(200).assertThat().body("size()", is(0));
        given().pathParam("name", "test_game1").when().get("/games/{name}").then().statusCode(404);

        // 2) persist a game
        given().pathParam("name", "test_game1").queryParam("size", "LARGE").when().put("games/{name}").then().statusCode(201);
        when().get("/games").then().statusCode(200).assertThat().body("size()", is(1));
        given().pathParam("name", "test_game1").get("/games/{name}").then().statusCode(200).assertThat().body("size", equalTo(Size.LARGE.name()));

        // 3) update a game
        given().pathParam("name", "test_game1").queryParam("size", "SMALL").when().put("games/{name}").then().statusCode(201);
        when().get("/games").then().statusCode(200).assertThat().body("size()", is(1));
        given().pathParam("name", "test_game1").when().get("/games/{name}").then().statusCode(200).assertThat().body("size", equalTo(Size.SMALL.name()));

        // 4) delete a game
        given().pathParam("name", "test_game1").when().delete("games/{name}").then().statusCode(200);
        given().pathParam("name", "test_game1").when().delete("games/{name}").then().statusCode(404);
        when().get("/games").then().statusCode(200).assertThat().body("size()", is(0));
        given().pathParam("name", "test_game1").get("/games/{name}").then().statusCode(404);
    }
}