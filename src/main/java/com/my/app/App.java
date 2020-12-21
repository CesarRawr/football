import static spark.Spark.*;

import java.util.*;
import com.google.gson.*;

public class App {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        
        port(getHerokuAssignedPort());

        String projectDir = System.getProperty("user.dir");
        staticFiles.externalLocation(projectDir + "/src/main/resources/public");

        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });

        get("/admin", (req, res) -> {
            String user = req.queryParams("user");
            String pass = req.queryParams("pass");
            if(user.equals("javier") && pass.equals("8462")) {
                res.status(200);
                res.redirect("https://fball2.herokuapp.com/admin.html");
            }else {
                System.out.println("Permiso denegado");
                res.status(404);
            }

            return res;
        });

        get("/equipo", (req, res) -> {
            return gson.toJson(DAOEQUIPOS.getEquipos());
        });

        post("/equipo", (req, res) -> {

            String data = req.body();
            Equipo equipo = gson.fromJson(data, Equipo.class);

            return DAOEQUIPOS.crearEquipo(equipo);
        });
        
        delete("/equipo/:id", (req, res) -> {
            return DAOEQUIPOS.eliminarEquipo(req.params("id"));
        });

        put("/equipo", (req, res) -> {
            String data = req.body();
            Equipo equipo = gson.fromJson(data, Equipo.class);

            return DAOEQUIPOS.actualizarEquipo(equipo);
        });

        //                     Jugadores
        //------------------------------------------------------------

        get("/jugador", (req, res) -> {
            return gson.toJson(DAOJUGADORES.getJugadores());
        });

        post("/jugador", (req, res) -> {

            String data = req.body();
            Jugador jugador = gson.fromJson(data, Jugador.class);

            return DAOJUGADORES.crearJugador(jugador);
        });
        
        delete("/jugador/:id", (req, res) -> {
            return DAOJUGADORES.eliminarJugador(req.params("id"));
        });

        put("/jugador", (req, res) -> {
            String data = req.body();
            Jugador jugador = gson.fromJson(data, Jugador.class);

            return DAOJUGADORES.actualizarJugador(jugador);
        });

        //                    Noticias
        //--------------------------------------------------------------
        
        get("/noticia", (req, res) -> {
            return gson.toJson(DAONOTICIAS.getNoticias());
        });

        post("/noticia", (req, res) -> {

            String data = req.body();
            Noticia noticia = gson.fromJson(data, Noticia.class);

            return DAONOTICIAS.crearNoticia(noticia);
        });
        
        delete("/noticia/:id", (req, res) -> {
            return DAONOTICIAS.eliminarNoticia(req.params("id"));
        });

        put("/noticia", (req, res) -> {
            String data = req.body();
            Noticia noticia = gson.fromJson(data, Noticia.class);

            return DAONOTICIAS.actualizarNoticia(noticia);
        });

        //                         Partidos
        //---------------------------------------------------------------

        get("/partido", (req, res) -> {
            return gson.toJson(DAOPARTIDOS.getPartidos());
        });

        post("/partido", (req, res) -> {

            String data = req.body();
            Partido partido = gson.fromJson(data, Partido.class);

            return DAOPARTIDOS.crearPartido(partido);
        });
        
        delete("/partido/:id", (req, res) -> {
            return DAOPARTIDOS.eliminarPartido(req.params("id"));
        });

        put("/partido", (req, res) -> {
            String data = req.body();
            Partido partido = gson.fromJson(data, Partido.class);

            return DAOPARTIDOS.actualizarPartido(partido);
        });

        //                      Torneos
        //-----------------------------------------------------------
        
        get("/torneo", (req, res) -> {
            return gson.toJson(DAOTORNEOS.getTorneos());
        });

        post("/torneo", (req, res) -> {

            String data = req.body();
            Torneo torneo = gson.fromJson(data, Torneo.class);

            return DAOTORNEOS.crearTorneo(torneo);
        });
        
        delete("/torneo/:id", (req, res) -> {
            return DAOTORNEOS.eliminarTorneo(req.params("id"));
        });

        put("/torneo", (req, res) -> {
            String data = req.body();
            Torneo torneo = gson.fromJson(data, Torneo.class);

            return DAOTORNEOS.actualizarTorneo(torneo);
        });
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 7072;
    }
}
