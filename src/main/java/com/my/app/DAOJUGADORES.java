import java.sql.*;
import java.util.*;

public class DAOJUGADORES {
    
    private static Conexion conexion = new Conexion();

    public static String crearJugador(Jugador jugador) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "insert into jugadores values (null,?,?,?,?,?)";
            
            st = con.prepareStatement(sql);
            st.setString(1, jugador.getNombre());
            st.setString(2, jugador.getFecha());
            st.setString(3, jugador.getNumero());
            st.setString(4, jugador.getEquipo());
            st.setString(5, jugador.getTorneo());

            if(st.executeUpdate() > 0){
                msj = "El usuario fue agregado";
            }
            else{
                msj = "No se pudo agregar el usuario";
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(st != null) {
                try {
                    st.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
                st = null;
            }
            try {
                con.close();
                System.out.println("conexion cerrada");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return msj;
    }

    public static List<Jugador> getJugadores() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        List<Jugador> resultados = new ArrayList<Jugador>();

        con = conexion.getConnection();

        try {
            String sql = "select * from jugadores";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                Jugador c = new Jugador();

                c.setID(rs.getString("idJugador"));
                c.setNombre(rs.getString("nmJugador"));
                c.setFecha(rs.getString("fechaNacim"));
                c.setNumero(rs.getString("numeroJug"));
                c.setEquipo(rs.getString("Equipo"));
                c.setTorneo(rs.getString("Torneo"));

                resultados.add(c);
            }  
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {

            if(rs != null) {
                try {
                    rs.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }

            if(st != null) {
                try {
                    st.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                st = null;
            }
            
            try {
                con.close();
                System.out.println("conexion cerrada");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultados;
    }

    public static String eliminarJugador(String id) {
        
        PreparedStatement st = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();

        try{

            String sql = "delete from jugadores where idJugador = ?";
            st = con.prepareStatement(sql);
            st.setString(1, id);

            if(st.executeUpdate() > 0) {
                msj = "El usuario fue eliminado";
            }
            else {
                msj = "No se pudo eliminar el usuario";
            }
        }
        catch(Exception e){
         
            e.printStackTrace();
        }
        finally{
            if(st != null){
                try {
                    st.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
                st = null;
            }
            try {
                con.close();
                System.out.println("conexion cerrada");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return msj;
    }

    public static String actualizarJugador(Jugador jugador) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "update jugadores set nmJugador=?, fechaNacim=?, numeroJug=?, Equipo=?, torneo=? where idJugador=?";
            
            st = con.prepareStatement(sql);
            st.setString(1, jugador.getNombre());
            st.setString(2, jugador.getFecha());
            st.setString(3, jugador.getNumero());
            st.setString(4, jugador.getEquipo());
            st.setString(5, jugador.getTorneo());
            st.setString(6, jugador.getID());

            if(st.executeUpdate() > 0){
                msj = "La jugador fue actualizada";
            }
            else{
                msj = "No se pudo actualizar la jugador";
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(st != null) {
                try {
                    st.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
                st = null;
            }
            try {
                con.close();
                System.out.println("conexion cerrada");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return msj;
    }
}
