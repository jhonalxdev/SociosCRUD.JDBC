/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

/**
 *
 * @author Jhon Alex
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
* Clase que permite conectar con la base de datos
* @author alejo
*/
public class DbConnection {
   static String bd = "baloncesto";
   static String login = "alex";
   static String pass = "alex";
   static String url = "jdbc:mysql://localhost:3306/"+bd;

   Connection conn = null;
   
   Statement s ;

   /** Constructor de DbConnection */
   public DbConnection() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,pass);
         if (conn!=null){
            System.out.println("Conección a base de datos "+bd+" OK");
         }
         
          s = conn.createStatement();
         
      }catch(SQLException | ClassNotFoundException e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexió
     * @return n*/
   public Connection getConnectionBD(){
 
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
   
   
   
   
   
   public ResultSet listadoTabla(String nameTable) {
        
                   ResultSet listado = null; 	
       try {
           listado = s.executeQuery ("SELECT * FROM "+ nameTable);
       } catch (SQLException ex) {
           Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        return  listado;
        
   }
 
}

