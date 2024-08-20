/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Calendar;
/**
 *
 * @author Andrianarivony Tamby
 */
public class ajoutvirement extends javax.swing.JFrame {
//private javax.swing.JComboBox<String> cbnumcompteenv;    /**
     /* Creates new form ajoutvirement
     */
    public ajoutvirement() {
        initComponents();
        //cbnumcompteenv = new JComboBox<>();
        Calendar aujourdHui = Calendar.getInstance();
        datetranfert.setDate(aujourdHui.getTime());
        remplirComboBox();
    }
    public ajoutvirement(String numcompte_env,String numcompte_rec, String montant_virement, String datevirement)
    {
        initComponents();
        //cbnumcompteenv = new JComboBox<>();
        
        cbnumcompteenv.removeAllItems();
        cbnucompterec.removeAllItems();
        cbnumcompteenv.addItem(numcompte_env);
        cbnucompterec.addItem(numcompte_rec);
        txtmontanttransfert.setText(montant_virement);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(datevirement);
            datetranfert.setDate(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Format de date invalide: " + e.getMessage());
        }
        btn_enregistrer_virement.setText("MODIFIER");
        lblvirement.setText("MODIFICATION");
        
        
        //remplirComboBox();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmontantvirement = new javax.swing.JLabel();
        lbldatetransfert = new javax.swing.JLabel();
        lblvirement = new javax.swing.JLabel();
        txtmontanttransfert = new javax.swing.JTextField();
        btn_enregistrer_virement = new javax.swing.JButton();
        btn_annuler_virement = new javax.swing.JButton();
        lblnumcopterecep = new javax.swing.JLabel();
        lblnumcompteenv = new javax.swing.JLabel();
        datetranfert = new com.toedter.calendar.JDateChooser();
        cbnumcompteenv = new javax.swing.JComboBox<>();
        cbnucompterec = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(190, 221, 226));
        setLocation(new java.awt.Point(1365, 223));
        setPreferredSize(new java.awt.Dimension(520, 660));

        lblmontantvirement.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblmontantvirement.setForeground(new java.awt.Color(45, 95, 95));
        lblmontantvirement.setText("Montant");

        lbldatetransfert.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lbldatetransfert.setForeground(new java.awt.Color(45, 95, 95));
        lbldatetransfert.setText("Date transfert");

        lblvirement.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        lblvirement.setForeground(new java.awt.Color(45, 95, 95));
        lblvirement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblvirement.setText("Ajout Virement");

        txtmontanttransfert.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        txtmontanttransfert.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 95, 95), 1, true));
        txtmontanttransfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontanttransfertActionPerformed(evt);
            }
        });

        btn_enregistrer_virement.setBackground(new java.awt.Color(66, 173, 155));
        btn_enregistrer_virement.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btn_enregistrer_virement.setForeground(new java.awt.Color(45, 95, 95));
        btn_enregistrer_virement.setText("Enregistrer");
        btn_enregistrer_virement.setFocusable(false);
        btn_enregistrer_virement.setPreferredSize(new java.awt.Dimension(200, 40));
        btn_enregistrer_virement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enregistrer_virementActionPerformed(evt);
            }
        });

        btn_annuler_virement.setBackground(new java.awt.Color(45, 95, 95));
        btn_annuler_virement.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btn_annuler_virement.setForeground(new java.awt.Color(192, 223, 228));
        btn_annuler_virement.setText("Annuler");
        btn_annuler_virement.setFocusable(false);
        btn_annuler_virement.setPreferredSize(new java.awt.Dimension(200, 40));
        btn_annuler_virement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_annuler_virementActionPerformed(evt);
            }
        });

        lblnumcopterecep.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblnumcopterecep.setForeground(new java.awt.Color(45, 95, 95));
        lblnumcopterecep.setText("Numero compte du recepteur");

        lblnumcompteenv.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblnumcompteenv.setForeground(new java.awt.Color(45, 95, 95));
        lblnumcompteenv.setText("Numero compte de l' evoyeur");

        datetranfert.setBackground(new java.awt.Color(255, 255, 255));
        datetranfert.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 95, 95), 1, true));
        datetranfert.setEnabled(false);
        datetranfert.setFocusable(false);
        datetranfert.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N

        cbnumcompteenv.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        cbnumcompteenv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbnucompterec.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        cbnucompterec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblnumcompteenv)
                    .addComponent(lbldatetransfert)
                    .addComponent(lblmontantvirement)
                    .addComponent(lblnumcopterecep)
                    .addComponent(cbnumcompteenv, 0, 400, Short.MAX_VALUE)
                    .addComponent(cbnucompterec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datetranfert, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmontanttransfert, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblvirement, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btn_enregistrer_virement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_annuler_virement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblvirement)
                .addGap(27, 27, 27)
                .addComponent(lblnumcompteenv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbnumcompteenv, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnumcopterecep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbnucompterec, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblmontantvirement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmontanttransfert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbldatetransfert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datetranfert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_enregistrer_virement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_annuler_virement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void remplirComboBox() {
        try {
            Connection conn = models.MConnexion.SiConnectionDB();
            String sql = "SELECT numcompte FROM client WHERE Statut = 'oui'"; // Modifier la requête selon vos besoins
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            cbnumcompteenv.removeAllItems();
            cbnucompterec.removeAllItems();
            while (rs.next()) {
                String numcompte = rs.getString("numcompte");
                cbnumcompteenv.addItem(numcompte);
                cbnucompterec.addItem(numcompte);

            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(); // Affiche l'exception dans la console
        }
    }
    private void txtmontanttransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontanttransfertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontanttransfertActionPerformed

    private void btn_enregistrer_virementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enregistrer_virementActionPerformed
       try {
            // Vérifier que tous les champs sont remplis
            if (txtmontanttransfert.getText().isEmpty()  ) {
                javax.swing.JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis.", "Erreur de saisie", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!txtmontanttransfert.getText().matches("\\d+"))
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur de saisie", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            int montanttransfer = Integer.parseInt(txtmontanttransfert.getText());

            if(montanttransfer <=0)
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur de saisie", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Récupérer les données d'entrée des champs de texte
            String numCompte_env_str = (String) cbnumcompteenv.getSelectedItem();
            String numCompte_rec_str = (String) cbnucompterec.getSelectedItem();
            
            int numCompte_env_int=Integer.parseInt(numCompte_env_str);
            int numCompte_rec_int=Integer.parseInt(numCompte_rec_str);
            Date dateSelectionnee = datetranfert.getDate();
            String datetransfert = "0000-00-00" ;
            if (numCompte_env_int == numCompte_rec_int)
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Virement impossible.", "Erreur de choix", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
            if (dateSelectionnee != null)
                {
                    SimpleDateFormat formatPourMySQL = new SimpleDateFormat("yyyy-MM-dd");
                    datetransfert = formatPourMySQL.format(dateSelectionnee);

                    // Utiliser 'dateFormatee' pour l'insertion ou la mise à jour dans MySQL
                    System.out.println("Date formatée pour MySQL : " + datetransfert);
                } 
            else
                {
                    System.out.println("Aucune date sélectionnée.");
                }
                           // Créer une nouvelle instance de MClient avec les entrées fournies
            if(btn_enregistrer_virement.getText().equals("MODIFIER"))
            {
               // models.MClient modif = new models.MClient(nom, prenoms, tel, mail, montant, numcompte);
                //modif.modifClient();
                models.MVirement supp = new models.MVirement(numCompte_env_int,numCompte_rec_int,datetransfert);
                
                int montant_virement = supp.montantmvmt_virement();
                    
                    models.MClient vola_env = new models.MClient(numCompte_env_int);
                    models.MClient vola_rec = new models.MClient(numCompte_rec_int);
                    
                    int plus_env =  vola_env.montantmvmt() - (montanttransfer - montant_virement) ;
                    int reste_rec = vola_rec.montantmvmt() - (montant_virement - montanttransfer) ;
                    
                    models.MClient modif_montant_env = new models.MClient(numCompte_env_int,plus_env);
                    models.MClient modif_montant_rec = new models.MClient(numCompte_rec_int,reste_rec);
                    modif_montant_env.modifClient_virement();
                    modif_montant_rec.modifClient_virement();
                    models.MVirement mod = new models.MVirement(numCompte_env_int,numCompte_rec_int,montanttransfer,datetransfert);
                    mod.modifVirement();
                javax.swing.JOptionPane.showMessageDialog(this, "Modification avec succès.", "Succès", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            }
            else
            {
                models.MClient vola_env = new models.MClient(numCompte_env_int);
                models.MClient vola_rec = new models.MClient(numCompte_rec_int);
                if(montanttransfer > vola_env.montantmvmt())
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "La solde est insufisante pour le virement.", "Erreur", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int reste_env =  vola_env.montantmvmt()- montanttransfer ;
                int plus_rec = vola_rec.montantmvmt()+ montanttransfer ;
                
                models.MVirement ajout = new models.MVirement(numCompte_env_int, numCompte_rec_int, montanttransfer, datetransfert);
                models.MClient modif_montant_env = new models.MClient(numCompte_env_int,reste_env);
                models.MClient modif_montant_rec = new models.MClient(numCompte_rec_int,plus_rec);
                modif_montant_env.modifClient_virement();
                modif_montant_rec.modifClient_virement();
                // Ajouter le nouveau client à la base de données
                ajout.ajoutVirement();// On suppose que cette méthode lance une exception en cas d'échec
                //genererVirement_pdf( datevirement,  numero_virement,  numcompte_env,  nom_env,  soldemvt_env,  numcompte_rec,String nom_rec, int montant_virement);
                // Afficher un message de succès
                javax.swing.JOptionPane.showMessageDialog(this, "Virement effectuée avec succès.", "Succès", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            // Actualiser l'affichage des clients dans l'autre interface
            vues.affichage loop = new vues.affichage();
            loop.clientaffiche();  // Actualiser la liste des clients

            // Fermer la fenêtre actuelle
            this.dispose();

            // Afficher un message de débogage dans la console
            System.out.println("coucou");
        }  catch (Exception e) {
            // Gérer toute autre exception
            System.err.println("Erreur : " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Une erreur est survenue lors de l'ajout du client.", "Erreur", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_enregistrer_virementActionPerformed

    private void btn_annuler_virementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_annuler_virementActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_annuler_virementActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ajoutvirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ajoutvirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ajoutvirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ajoutvirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ajoutvirement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_annuler_virement;
    private javax.swing.JButton btn_enregistrer_virement;
    private javax.swing.JComboBox<String> cbnucompterec;
    private javax.swing.JComboBox<String> cbnumcompteenv;
    private com.toedter.calendar.JDateChooser datetranfert;
    private javax.swing.JLabel lbldatetransfert;
    private javax.swing.JLabel lblmontantvirement;
    private javax.swing.JLabel lblnumcompteenv;
    private javax.swing.JLabel lblnumcopterecep;
    private javax.swing.JLabel lblvirement;
    private javax.swing.JTextField txtmontanttransfert;
    // End of variables declaration//GEN-END:variables
}
