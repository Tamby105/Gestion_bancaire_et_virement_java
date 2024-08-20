 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andrianarivony Tamby
 */
public class MConnexion implements MConfigBDD {
    public static Connection SiConnectionDB()
    {
       
        Connection objconnex = null;
        try {
            objconnex = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connexion a la base de donne reussi");
        }
        catch (SQLException e) {
            System.out.println("Echec de connexiona la base de donnee : " + e.getMessage());
        }
        return objconnex;
    }
}
