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
public class MRendre {
    
    private int num_rendu;
    private int num_pret;
    private int montant_rendu;
    private String situation;
    private int rest_paye;
    private String date_rendu;
    
    
    public MRendre() {
        
    }
    
    public MRendre(int num_rendu) {
        this.num_rendu = num_rendu;
    }

    public MRendre(int num_rendu,int num_pret) {
        this.num_rendu = num_rendu;
        this.num_pret = num_pret;
    }
    public MRendre(int num_pret,int montant_rendu,String situation,int rest_paye) {
        this.num_pret = num_pret;
        this.montant_rendu = montant_rendu;
        this.situation = situation;
        this.rest_paye = rest_paye;
        
    }
    public MRendre(int num_pret,int montant_rendu,String situation,int rest_paye,String date_rendu) {
        this.num_pret = num_pret;
        this.montant_rendu = montant_rendu;
        this.situation = situation;
        this.rest_paye = rest_paye;
        this.date_rendu = date_rendu;
    }
    public MRendre(int num_rendu,int num_pret,int montant_rendu,String situation,int rest_paye,String date_rendu) {
        this.num_rendu = num_rendu;
        this.num_pret = num_pret;
        this.montant_rendu = montant_rendu;
        this.situation = situation;
        this.rest_paye = rest_paye;
        this.date_rendu = date_rendu;
    }
    public void ajoutRendre()
    {
        Connection objconnex = MConnexion.SiConnectionDB();
        try {
            String request = "INSERT INTO rendre (num_pret, montant_rendu, situation, rest_paye, date_rendu) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_pret);
            Stat.setInt(2, this.montant_rendu);
            Stat.setString(3, this.situation);
            Stat.setInt(4, this.rest_paye);
            Stat.setString(5, this.date_rendu);
            
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
     
     
     public void modifRendre()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "UPDATE rendre SET   montant_rendu = ?, situation = ?, rest_paye = ? WHERE num_rendu = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_pret);
            Stat.setString(2, this.situation);
            Stat.setInt(3, this.rest_paye);
            //Stat.setString(4, this.date_rendu);
            Stat.setInt(4, this.montant_rendu);

            //int num_pret=montant_rendu,int montant_rendu=num_rendu,String situation,int rest_paye
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
     
     public void supprRendre()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "DELETE FROM rendre WHERE num_rendu = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_rendu);
            
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
     
     public void supprRendreViaPret()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "DELETE FROM rendre WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_rendu);
            
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
     public int montant_annulation()
    {
            int montantretourner = 0;
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT montant_rendu FROM rendre WHERE num_rendu = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_rendu);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getInt("montant_rendu");
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.num_rendu);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
     public int somme_deja_payee()
    {
            int montantretourner = 0;
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT SUM(montant_rendu) FROM rendre WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_rendu);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getInt(1);
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.num_rendu);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
     public String num_rendre()
    {
            String montantretourner = "";
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT num_rendu FROM rendre WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_rendu);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getString("num_rendu");
            } else {
                System.out.println("Aucun résultat trouvé pour num_pret : " + this.num_rendu);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
     public String situation()
    {
            String montantretourner = "";
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT situation FROM rendre WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_rendu);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getString("situation");
            } else {
                System.out.println("Aucun résultat trouvé pour num_pret : " + this.num_rendu);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
     public String date_rendu()
    {
            String montantretourner = "";
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT date_rendu FROM rendre WHERE num_pret = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.num_rendu);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getString("date_rendu");
            } else {
                System.out.println("Aucun résultat trouvé pour num_pret : " + this.num_rendu);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
    public int total_rendre() {
    int montantRetourner = 0;
    try (Connection objconnex = MConnexion.SiConnectionDB()) {
        // Requête SQL pour obtenir la somme totale de montant_rendu et reste_paye
        String request = "SELECT SUM(montant_rendu + rest_paye) AS total FROM rendre";
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

