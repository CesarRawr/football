import java.sql.*;
import java.util.*;

public class DAOTORNEOS {
    
    private static Conexion conexion = new Conexion();

    public static String crearTorneo(Torneo torneo) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "insert into torneos values (null,?,?)";
            
            st = con.prepareStatement(sql);
            st.setString(1, torneo.getTipoTorneo());
            st.setString(2, torneo.getNmTorneo());
            
            if(st.executeUpdate() > 0){
                msj = "El torneo fue agregado";
            }
            else{
                msj = "No se pudo agregar el torneo";
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

    public static List<Torneo> getTorneos() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        List<Torneo> resultados = new ArrayList<Torneo>();

        con = conexion.getConnection();

        try {
            String sql = "select * from torneos";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                Torneo c = new Torneo();

                c.setID(rs.getString("idTorneo"));
                c.setTipoTorneo(rs.getString("tipoTorneo"));
                c.setNmTorneo(rs.getString("nmTorneo"));
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

    public static String eliminarTorneo(String id) {
        
        PreparedStatement st = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();

        try{

            String sql = "delete from torneos where idTorneo = ?";
            st = con.prepareStatement(sql);
            st.setString(1, id);

            if(st.executeUpdate() > 0) {
                msj = "El torneo fue eliminado";
            }
            else {
                msj = "No se pudo eliminar el torneo";
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

    public static String actualizarTorneo(Torneo torneo) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "update torneos set tipoTorneo=?, nmTorneo=? where idTorneo=?";
            
            st = con.prepareStatement(sql);
            st.setString(1, torneo.getTipoTorneo());
            st.setString(2, torneo.getNmTorneo());
            st.setString(3, torneo.getID());

            if(st.executeUpdate() > 0){
                msj = "La torneo fue actualizada";
            }
            else{
                msj = "No se pudo actualizar la torneo";
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
