package tk.felipe.modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private final String base = "tienda";
    private final String user = "root";
    private final String pass = "";
    private final String URL = "jdbc:mysql://localhost:3306/" + base;
    private Connection cnx = null;
    
    public Connection conexionMySQL(){
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection(this.URL, this.user, this.pass);
            
        }catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }
    
}
