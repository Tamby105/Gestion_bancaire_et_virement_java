/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.sql.DriverManager;

/**
 *
 * @author Andrianarivony Tamby
 */
public class MClient {
    private int numCompte;
    private String Nom;
    private String Prenoms;
    private String Tel;
    private String Mail;
    private String Statut;
    private int Solde;
    private int SoldeMvmt;

    
    public MClient(){

    }
    
    public MClient(int numCompte){
        this.numCompte = numCompte;
    }
    public MClient(int numCompte,int SoldeMvmt){
        this.numCompte = numCompte;
        this.SoldeMvmt = SoldeMvmt;
    }
    
    public MClient(String Nom,String Prenoms,String Tel,String Mail,int Solde,int SoldeMvmt, String statut){
        this.Nom = Nom;
        this.Prenoms = Prenoms;
        this.Tel = Tel;
        this.Mail = Mail;
        this.Solde = Solde;
        this.SoldeMvmt = SoldeMvmt;
        this.Statut = statut;

    }
    public MClient(String Nom,String Prenoms,String Tel,String Mail,int Solde,int SoldeMvmt,int numCompte){
        this.Nom = Nom;
        this.Prenoms = Prenoms;
        this.Tel = Tel;
        this.Mail = Mail;
        this.Solde = Solde;
        this.SoldeMvmt = SoldeMvmt;
        this.numCompte = numCompte;

    }
    
    
     public void ajoutCLient()
    {
        Connection objconnex = MConnexion.SiConnectionDB();
        try {
            String request = "INSERT INTO Client (Nom, Prenoms, Tel, Mail, Solde, SoldeMvmt, Statut) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setString(1, this.Nom);
            Stat.setString(2, this.Prenoms);
            Stat.setString(3, this.Tel);
            Stat.setString(4, this.Mail);
            Stat.setInt(5, this.Solde);
            Stat.setInt(6, this.SoldeMvmt);
            Stat.setString(7, this.Statut);

            
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
     
     
     public void modifClient()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "UPDATE Client SET Nom = ?, Prenoms = ?, Tel = ?, Mail = ?, Solde = ?, SoldeMvmt = ? WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setString(1, this.Nom);
            Stat.setString(2, this.Prenoms);
            Stat.setString(3, this.Tel);
            Stat.setString(4, this.Mail);
            Stat.setInt(5, this.Solde);
            Stat.setInt(6, this.SoldeMvmt);
            Stat.setInt(7, this.numCompte);
            
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
     public void modifClient_virement()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "UPDATE Client SET SoldeMvmt = ? WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.SoldeMvmt);
            Stat.setInt(2, this.numCompte);
           
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
     
     /*public void supprClient()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "DELETE FROM Client WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.numCompte);
            
            //int lignesModifiees = statement.executeUpdate();
            if (ligneModif > 0) {
                System.out.println("OK ni Fandeani Delete!!!");
            } else {
                System.out.println("KO ni Fandeani Delete!!!");
            }
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
    }*/
     public void activation()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "UPDATE Client SET Statut = 'oui' WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.numCompte);
            
            //int lignesModifiees = statement.executeUpdate();
            
            Stat.execute();
            
        } catch (SQLException e) {
            System.out.println("Echec de connexion a la base de donnee : " + e.getMessage());
        }
    }
     public void desactivation()
    {
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "UPDATE Client SET Statut = 'non' WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.numCompte);
            
            //int lignesModifiees = statement.executeUpdate();
            
            Stat.execute();
            
        } catch (SQLException e) {
            System.out.println("Echec de connexion a la base de donnee : " + e.getMessage());
        }
    }
     
     public ResultSet afficheClient()
    {
        ResultSet siResultSet = null;
        List<List<Object>> siList = new ArrayList<>();
        try (Connection objconnex = MConnexion.SiConnectionDB()) 
        {
            String request = "SELECT * FROM client";
            Statement Stat = objconnex.createStatement();
             siResultSet = Stat.executeQuery(request);
            
            while(siResultSet.next())
            {
                //System.out.println(siResultSet.getRow());
                List<Object> siListLign = new ArrayList<>();
                siListLign.add(siResultSet.getString("numCompte"));
                siListLign.add(siResultSet.getString("Nom"));
                siListLign.add(siResultSet.getString("Prenoms"));
                siListLign.add(siResultSet.getString("Tel"));
                siListLign.add(siResultSet.getString("Mail"));
                siListLign.add(siResultSet.getInt("Solde"));
                siListLign.add(siResultSet.getInt("SoldeMvmt"));

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
     public int montantmvmt()
    {
            int montantretourner = 0;
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT SoldeMvmt FROM client WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.numCompte);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getInt("SoldeMvmt");
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.numCompte);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
     public String nom_client()
    {
            String montantretourner = "";
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT Nom FROM client WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.numCompte);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getString("Nom");
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.numCompte);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
     public String prenom_client()
    {
            String montantretourner = "";
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT Prenoms FROM client WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.numCompte);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getString("Prenoms");
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.numCompte);
            }

            // Fermer le ResultSet et le Statement
            rs.close();
            Stat.close();

        } catch (SQLException e) {
            System.out.println("Echec de connexion à la base de données : " + e.getMessage());
        }

        return montantretourner;
    }
     public String mail_client()
    {
            String montantretourner = "";
        try (Connection objconnex = MConnexion.SiConnectionDB()) {
            String request = "SELECT Mail FROM client WHERE numCompte = ?";
            PreparedStatement Stat = objconnex.prepareStatement(request);
            Stat.setInt(1, this.numCompte);

            // Exécuter la requête et récupérer le résultat
            ResultSet rs = Stat.executeQuery();

            // Vérifier si le résultat contient des lignes
            if (rs.next()) {
                // Récupérer la valeur de SoldeMvmt
                montantretourner = rs.getString("Mail");
            } else {
                System.out.println("Aucun résultat trouvé pour numCompte : " + this.numCompte);
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
