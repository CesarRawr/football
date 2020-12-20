import java.sql.*;
import java.util.*;

public class DAOEQUIPOS {
    
    private static Conexion conexion = new Conexion();

    public static String crearEquipo(Equipo equipo) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "insert into equipos values (?,?,?,?,null)";
            
            st = con.prepareStatement(sql);
            st.setString(1, equipo.getNmEquipo());
            st.setString(2, equipo.getSlogan());
            st.setString(3, equipo.getDT());
            st.setString(4, equipo.getTorneo());

            if(st.executeUpdate() > 0){
                msj = "El equipo fue agregado";
            }
            else{
                msj = "No se pudo agregar el equipo";
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

    public static List<Equipo> getEquipos() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        List<Equipo> resultados = new ArrayList<Equipo>();

        con = conexion.getConnection();

        try {
            String sql = "select * from equipos";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                Equipo c = new Equipo();

                c.setID(rs.getString("idEquipo"));
                c.setNmEquipo(rs.getString("nmEquipo"));
                c.setSlogan(rs.getString("slogan"));
                c.setDT(rs.getString("dt"));
                c.setTorneo(rs.getString("torneo"));

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

    public static String eliminarEquipo(String id) {
        
        PreparedStatement st = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();

        try{

            String sql = "delete from equipos where idEquipo = ?";
            st = con.prepareStatement(sql);
            st.setString(1, id);

            if(st.executeUpdate() > 0) {
                msj = "El equipo fue eliminado";
            }
            else {
                msj = "No se pudo eliminar el equipo";
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

    public static String actualizarEquipo(Equipo equipo) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "update equipos set nmEquipo=?, slogan=?, dt=?, torneo=? where idEquipo=?";
            
            st = con.prepareStatement(sql);
            st.setString(1, equipo.getNmEquipo());
            st.setString(2, equipo.getSlogan());
            st.setString(3, equipo.getDT());
            st.setString(4, equipo.getTorneo());
            st.setString(5, equipo.getID());

            if(st.executeUpdate() > 0){
                msj = "La equipo fue actualizada";
            }
            else{
                msj = "No se pudo actualizar la equipo";
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
