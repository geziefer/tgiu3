package de.tgiu.game.service;

import de.tgiu.game.entity.Game;
import de.tgiu.game.entity.Size;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/games")
public class GameService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGames() {
        List<Game> games = Game.listAll();
        return Response.ok().entity(games).build();
    }

    @PUT
    @Path("{name}")
    public Response createGame(@PathParam("name") String name, @QueryParam("size") Size size) {
        Game game = new Game();
        game.name = name;
        game.size = size;
        Game.persist(game);
        return Response.noContent().build();
    }
}
