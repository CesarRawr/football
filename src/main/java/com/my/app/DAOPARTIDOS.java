import java.sql.*;
import java.util.*;

public class DAOPARTIDOS {
    
    private static Conexion conexion = new Conexion();

    public static String crearPartido(Partido partido) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "insert into partidos values (null,?,?,?,?)";
            
            st = con.prepareStatement(sql);
            st.setString(1, partido.getEquipoL());
            st.setString(2, partido.getEquipoV());
            st.setString(3, partido.getFechaP());
            st.setString(4, partido.getHoraP());
            
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

    public static List<Partido> getPartidos() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        List<Partido> resultados = new ArrayList<Partido>();

        con = conexion.getConnection();

        try {
            String sql = "select * from partidos";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                Partido c = new Partido();

                c.setID(rs.getString("idPartido"));
                c.setEquipoL(rs.getString("equipoL"));
                c.setEquipoV(rs.getString("equipoV"));
                c.setFechaP(rs.getString("fechaP"));
                c.setHoraP(rs.getString("horaP"));
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

    public static String eliminarPartido(String id) {
        
        PreparedStatement st = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();

        try{

            String sql = "delete from partidos where idPartido = ?";
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

    public static String actualizarPartido(Partido partido) {

        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();

        try {
            String sql = "update partidos set equipoL=?, equipoV=?, fechaP=?, horaP=? where idPartido=?";
            
            st = con.prepareStatement(sql);
            st.setString(1, partido.getEquipoL());
            st.setString(2, partido.getEquipoV());
            st.setString(3, partido.getFechaP());
            st.setString(4, partido.getHoraP());
            st.setString(5, partido.getID());

            if(st.executeUpdate() > 0){
                msj = "La partido fue actualizada";
            }
            else{
                msj = "No se pudo actualizar la partido";
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
