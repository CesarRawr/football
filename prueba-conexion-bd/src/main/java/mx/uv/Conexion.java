package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
    private static String url = "jdbc:mysql://db4free.net:3306/ligafutbol";
    private static String user = "equipotres";
    private static String password = "paginafutbol";
    private static Connection con = null;

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("CONEXION A LA BD ESTABLECIDA :3!");
            
        }catch(SQLException e){
            System.out.println("FALLO AL CONECTARSE A LA BD ):!");

        }catch(ClassNotFoundException e){
            System.out.println("Driver not found!");
        }
        return con;

    }
}