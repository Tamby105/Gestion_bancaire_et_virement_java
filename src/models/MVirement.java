/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrianarivony Tamby
 */
public class MVirement {
    private int num_Compte_env;
    private int num_virement;
    private int num_Compte_recep;
    private int montant;
    private String dateTransfert;
    
    public MVirement() {
        
    }
    
    public MVirement(int num_Compte_env, int num_Compte_recep, String dateTransfert ) {
        this.num_Compte_env = num_Compte_env;
        this.num_Compte_recep = num_Compte_recep;
        this.dateTransfert = dateTransfert;
    }
    
    public MVirement(int num_Compte_env, int num_Compte_recep, int montant, String dateTransfert) {
        this.num_Compte_env = num_Compte_env;
        this.num_Compte_recep = num_Compte_recep;
        this.montant = montant;
        this.dateTransfert = dateTransfert;
    }
public void ajoutVirement()
    {
        Connection objconnex = MConnexion.SiConnectionDB();
        try {
            String request = "INSERT INTO virement (num_Compte_env,num_Compte_recep, montant, dateTransfert) VALUES (?, ?, ?, ?)";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_Compte_env);
            Stat.setInt(2, this.num_Compte_recep);
            Stat.setInt(3, this.montant);
            Stat.setString(4, this.dateTransfert);
            
            //int lignesModifiees = statement.executeUpdate();
            /*if (ligneModif > 0) {
                System.out.println("OK ni Fandeani Insert!!!");
            } else {
                System.out.println("KO ni Fandeani Insert!!!");
            }*/
            boolean requestOk = Stat.execute();
            System.out.println(requestOk);
            if (!requestOk) {
                System.out.println("Insertion reussie");
                System.out.println("Nombre de ligne inseree : " + Stat.getUpdateCount());
            } else {
                System.out.println("echec de l'insertion");
            }
        } catch (SQLException e) {
            System.out.println("Echec de connexion a la base de donnee : " + e.getMessage());
        }
    }
     public void supprVirement()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "DELETE FROM virement WHERE num_Compte_env = ? AND num_Compte_recep = ? AND dateTransfert = ? ";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_Compte_env);
            Stat.setInt(2, this.num_Compte_recep);
            Stat.setString(3, this.dateTransfert);
            //int lignesModifiees = statement.executeUpdate();
            /*if (ligneModif > 0) {
                System.out.println("OK ni Fandeani Delete!!!");
            } else {
                System.out.println("KO ni Fandeani Delete!!!");
            }*/
               boolean requestOk = Stat.execute();
            System.out.println(requestOk);
            if (!requestOk) {
                System.out.println("Suppression reussie");
            } else {
                System.out.println("echec de la Suppression");
            }
        } catch (SQLException e) {
            System.out.println("Echec de connexion a la base de donnee : " + e.getMessage());
        }
    }
     
     
     

public void modifVirement()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "UPDATE virement SET montant = ? WHERE num_Compte_env = ? AND num_Compte_recep = ? AND dateTransfert = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.montant);
            Stat.setInt(2, this.num_Compte_env);
            Stat.setInt(3, this.num_Compte_recep);
            Stat.setString(4, this.dateTransfert);
            
            //int lignesModifiees = statement.executeUpdate();
            /*if (ligneModif > 0) {
                System.out.println("OK ni Fandeani Update!!!");
            } else {
                System.out.println("KO ni Fandeani Update!!!");
            }*/
            boolean requestOk = Stat.execute();
            System.out.println(requestOk);
            if (!requestOk) {
                System.out.println("Modification reussie");
                System.out.println("Nombre de ligne modifie : " + Stat.getUpdateCount());
            } else {
                System.out.println("echec de la modification");
            }
        } catch (SQLException e) {
            System.out.println("Echec de connexion a la base de donnee : " + e.getMessage());
        }
    }
     public int num_virement()
    {
        int montantretourner = 0;
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT num_virement FROM virement WHERE num_Compte_env = ? AND num_Compte_recep = ? AND dateTransfert = ? ";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_Compte_env);
            Stat.setInt(2, this.num_Compte_recep);
            Stat.setString(3, this.dateTransfert);
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getInt("num_virement");
            } else {
                System.out.println("Aucun résultat trouvé pour le montant en question!");
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();
        } catch (SQLException e) {
            System.out.println("Echec de connexion a la base de donnee : " + e.getMessage());
        }
        return montantretourner;
    }
     
     public ResultSet afficheVirement()
    {
        ResultSet siResultSet = null;
        List<List<Object>> siList = new ArrayList<>();
        try (Connection objconnex = MConnexion.SiConnectionDB()) 
        {
            String request = "SELECT * FROM virement";
            Statement Stat = objconnex.createStatement();
             siResultSet = Stat.executeQuery(request);
            
            while(siResultSet.next())
            {
                //System.out.println(siResultSet.getRow());
                List<Object> siListLign = new ArrayList<>();
                siListLign.add(siResultSet.getInt("num_Compte_env"));
                siListLign.add(siResultSet.getInt("num_Compte_recep"));
                siListLign.add(siResultSet.getInt("montant"));
                siListLign.add(siResultSet.getString("dateTransfert"));

                siList.add(siListLign);
            }
            //System.out.println(siList);
            /*for(List<Object> siLigne : siList){
                //System.out.println(siLigne);
                for(Object siCol : siLigne){
                    System.out.println(siCol);
                }
            }*/
        return siResultSet; 

        } 
        catch (SQLException e) 
        {
            System.out.println("Echec de connexion a la base de donnee : " + e.getMessage());
        return siResultSet; 

        }
    }
      public int montantmvmt_virement()
    {
            int montantretourner = 0;
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT montant FROM virement WHERE num_Compte_env = ? AND num_Compte_recep = ? AND dateTransfert = ? ";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_Compte_env);
            Stat.setInt(2, this.num_Compte_recep);
            Stat.setString(3, this.dateTransfert);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getInt("montant");
            } else {
                System.out.println("Aucun résultat trouvé pour le montant en question!");
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
}

