package mx.uv;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class DAO {
    private static Conexion conexion = new Conexion();

    public static List<Equipos> dameEquipos(){
            Statement stm = null;
            Connection con = null;
            ResultSet rs = null;
            List<Equipos> resultado = new ArrayList<>();
    
            con = Conexion.getConnection(); 
            try{
                String sql = "SELECT * FROM equipos";
                stm = (Statement) con.createStatement();
                rs = ((java.sql.Statement) stm).executeQuery(sql);

                while(rs.next()){
                    Equipos u = new Equipos(rs.getString("nmEquipo"), rs.getString("slogan"), rs.getString("dt"), rs.getInt("torneo"), rs.getString("idEquipo"));
                    resultado.add(u);  
                }
    
            }catch (Exception e){
                e.printStackTrace();
    
            }finally {
               if(rs != null){
                   try{
                       rs.close();
    
                   }catch(SQLException e){
                       e.printStackTrace();
    
                   }
                   rs = null;
               }
               if(stm != null){
                try{
                    //stm.close();
                    System.out.println("Hello");
     
                }catch(Exception e){
                    e.printStackTrace();
     
                }
                stm = null;
               }
               try{
                   con.close();
                   System.out.println("Closed Connection");
    
               }catch(Exception e){
                   e.printStackTrace();
    
               }
            }
        return resultado;
    }   
}
