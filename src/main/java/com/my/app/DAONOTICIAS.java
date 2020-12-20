import java.sql.*;
import java.util.*;

public class DAONOTICIAS {
    
    private static Conexion conexion = new Conexion();

    public static String crearNoticia(Noticia noticia) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "insert into noticias values (null,?,?)";
            
            st = con.prepareStatement(sql);
            st.setString(1, noticia.getTituloN());
            st.setString(2, noticia.getInfoN());

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

    public static List<Noticia> getNoticias() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        List<Noticia> resultados = new ArrayList<Noticia>();

        con = conexion.getConnection();

        try {
            String sql = "select * from noticias";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                Noticia c = new Noticia();

                c.setID(rs.getString("idNoticia"));
                c.setTituloN(rs.getString("tituloN"));
                c.setInfoN(rs.getString("infoN"));
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

    public static String eliminarNoticia(String id) {
        
        PreparedStatement st = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();

        try{

            String sql = "delete from noticias where idNoticia = ?";
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

    public static String actualizarNoticia(Noticia noticia) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "update noticias set tituloN=?, infoN=? where idNoticia=?";
            
            st = con.prepareStatement(sql);
            st.setString(1, noticia.getTituloN());
            st.setString(2, noticia.getInfoN());
            st.setString(3, noticia.getID());

            if(st.executeUpdate() > 0){
                msj = "La noticia fue actualizada";
            }
            else{
                msj = "No se pudo actualizar la noticia";
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
