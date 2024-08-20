/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbancaireetvirement;
import vues.*;
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Andrianarivony Tamby
 */
public class GestionBancaireEtVirement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       affichage prod = new affichage() ;
        prod.show();
        //vues.ajoutpreter ajout = new vues.ajoutpreter();
        /*vues.ajoutclient ajout = new vues.ajoutclient();
        ajout.show();*/
        
    }
    
}
