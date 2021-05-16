package de.tgiu.game.service;

import de.tgiu.game.entity.Game;
import de.tgiu.game.entity.Size;
import org.apache.commons.lang3.EnumUtils;

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
    public Response saveGame(@PathParam("name") String name, @QueryParam("size") String size) {
        if (!EnumUtils.isValidEnum(Size.class, size)) {
            return Response.status(400).entity("Invalid size").build();
        }

        Game game = Game.findByName(name);
        if (game != null) {
            game.size = Size.valueOf(size);
            game.update();
        } else {
            game = new Game();
            game.name = name;
            game.size = Size.valueOf(size);
            Game.persist(game);
        }
        return Response.status(201).entity("Game saved successfully").build();
    }

    @DELETE
    @Path("{name}")
    public Response deleteGame(@PathParam("name") String name) {
        Game game = Game.findByName(name);
        if (game != null) {
            game.delete();
            return Response.status(200).entity("Game deleted successfully").build();
        }
        return Response.status(404).entity("Game not found").build();
    }
}