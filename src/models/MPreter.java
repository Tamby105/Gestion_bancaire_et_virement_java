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

/**
 *
 * @author Andrianarivony Tamby
 */
public class MPreter {
    private int num_pret;
    private int num_Compte;
    private int montant_prete;
    private String datepret;
    
    public MPreter() {
        
    }
    public MPreter(int num_pret) 
    {
        this.num_pret = num_pret;
    }
    
    public MPreter(int num_pret,int num_Compte) {
        this.num_pret = num_pret;
        this.num_Compte = num_Compte;
    }
    public MPreter(int num_pret,String datepret) {
        this.num_pret = num_pret;
        this.datepret = datepret;
    }
    public MPreter(int num_Compte,int montant_prete,String datepret) {
        this.num_Compte = num_Compte;
        this.montant_prete = montant_prete;
        this.datepret = datepret;
    }
    
    public MPreter(int num_pret,int num_Compte,int montant_prete,String datepret) {
        this.num_pret = num_pret;
        this.num_Compte = num_Compte;
        this.montant_prete = montant_prete;
        this.datepret = datepret;
    }
    public void ajoutPreter()
    {
        Connection objconnex = MConnexion.SiConnectionDB();
        try {
            String request = "INSERT INTO preter (num_Compte, montant_prete, datepret) VALUES (?, ?, ?)";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_Compte);
            Stat.setInt(2, this.montant_prete);
            Stat.setString(3, this.datepret);
            
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
     
     
     public void modifPreter()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "UPDATE preter SET  montant_prete = ? WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            
            Stat.setInt(1, this.num_Compte);
            Stat.setInt(2, this.num_pret);

            
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
     
     public void supprPreter()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "DELETE FROM preter WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_pret);
            
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
     
     public void supprPreterClient()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "DELETE FROM preter WHERE num_Compte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_pret);
            
            //int lignesModifiees = statement.executeUpdate();
            /*if (ligneModif > 0) {
                System.out.println("OK ni Fandeani Delete!!!");
            } else {
                System.out.println("KO ni Fandeani Delete!!!");
            }*/
               boolean requestOk = Stat.execute();
            System.out.println(requestOk);
            if (!requestOk) {
                System.out.println("Insertion reussie");
                System.out.println("Nombre de ligne modifie : " + Stat.getUpdateCount());
            } else {
                System.out.println("echec de la modification");
            }
        } catch (SQLException e) {
            System.out.println("Echec de connexion a la base de donnee : " + e.getMessage());
        }
    }
      public int montantpret()
    {
            int montantretourner = 0;
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT montant_prete FROM preter WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_pret);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getInt("montant_prete");
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.num_pret);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
       public int numcompte_pret()
    {
            int montantretourner = 0;
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT num_Compte FROM preter WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_pret);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getInt("num_Compte");
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.num_pret);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
       public int num_pret()
    {
            int montantretourner = 0;
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT num_pret FROM preter WHERE num_Compte = ? AND datepret = ? ";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_pret);
            Stat.setString(2, this.datepret);
            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getInt("num_pret");
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.num_pret);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
       public String date_preter()
    {
            String montantretourner = "";
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT datepret FROM preter WHERE num_Compte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_pret);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getString("datepret");
            } else {
                System.out.println("Aucun résultat trouvé pour num_pret : " + this.num_pret);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
       public int total_preter() {
    int montantRetourner = 0;
    try (Connection objconnex = MConnexion.SiConnectionDB()) {
        // Requête SQL pour obtenir la somme totale de montant_rendu et reste_paye
        String request = "SELECT SUM(montant_prete) AS total FROM preter";
        PreparedStatement Stat = objconnex.prepareStatement(request);

        // Exécuter la requête et récupérer le résultat
        ResultSet rs = Stat.executeQuery();

        // Vérifier si le résultat contient des lignes
        if (rs.next()) {
            // Récupérer la valeur de la somme
            montantRetourner = rs.getInt("total");
        } else {
            System.out.println("Aucun résultat trouvé.");
        }

        // Fermer le ResultSet et le Statement
        rs.close();
        Stat.close();

    } catch (SQLException e) {
        System.out.println("Echec de connexion à la base de données : " + e.getMessage());
    }

    return montantRetourner;
}
}

