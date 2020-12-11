package mx.uv;

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;


/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson = new Gson();
    private static Map<String, Equipos> equipos = new HashMap<>();
    public static void main( String[] args )
    {
        get("/equipos", (req, res) -> gson.toJson(DAO.dameEquipos()));

        /*post("/equipos", (re, res) -> {
            String query = re.body();
            System.out.println( "Petcicion " + query);   
            Equipos u = gson.fromJson(query, Equipos.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);   
            equipos.put(id, u);
            
            return "Se creo el equipo con id: "+ id;
        });*/

        /*DAO dao = new DAO();

        dao.imprimirEquipos();*/



    }

}
