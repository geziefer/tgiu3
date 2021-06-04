package de.tgiu.game.service;

import de.tgiu.game.entity.Game;
import de.tgiu.game.entity.Size;
import de.tgiu.game.repository.GameRepository;
import org.apache.commons.lang3.EnumUtils;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/games")
public class GameService {
    @Inject
    Logger log;

    @Inject
    GameRepository gameRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGames() {
        Collection<Game> games = gameRepository.getGames();
        log.info(games.size() + " games requested");
        return Response.ok().entity(games).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGame(@PathParam("name") String name) {
        Game game = gameRepository.getGame(name);
        if (game == null) {
            log.info("Game " + name + " not found");
            return Response.status(404).build();
        } else {
            log.info("Game " + name + " requested");
            return Response.ok().entity(game).build();
        }
    }

    @PUT
    @Path("{name}")
    public Response saveGame(@PathParam("name") String name, @QueryParam("size") String sizeValue) {
        if (!EnumUtils.isValidEnum(Size.class, sizeValue)) {
            return Response.status(400).entity("Invalid size value").build();
        }

        Size size = Size.valueOf(sizeValue);
        Game game = gameRepository.getGame(name);
        if (game != null) {
            game.size = size;
        } else {
            game = new Game(name, size);
        }
        gameRepository.saveOrUpdateGame(game);
        return Response.status(201).entity("Game saved successfully").build();
    }

    @DELETE
    @Path("{name}")
    public Response deleteGame(@PathParam("name") String name) {
        Game game = gameRepository.deleteGame(name);
        if (game != null) {
            return Response.status(200).entity("Game deleted successfully").build();
        }
        return Response.status(404).entity("Game not found").build();
    }
}