package project.connection;
import java.sql.*;
 
/**
 * Clase que permite conectar con la base de datos
 * @author chenao
 *
 */
public class DbConnection {
   /**Parametros de conexion*/
   static String bd = "kriptsof_heredin";
   static String login = "kriptsof_admin1";
   static String password = "admin";
   static String url = "jdbc:mysql://192.254.225.120:3306/"+bd;
 
   Connection connection = null;
 
   /** Constructor de DbConnection */
   public DbConnection() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexi�n
         connection = DriverManager.getConnection(url,login,password);
 
         if (connection!=null){
            System.out.println("Conexi�n a base de datos "+bd+" OK\n");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexi�n*/
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}
