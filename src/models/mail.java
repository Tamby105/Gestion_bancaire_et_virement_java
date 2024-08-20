package models;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author TIAVINA
 */
public class mail {
    public static boolean sendMail(String nom_preteur, String date_rendu, String email_preteur, int num_pret, int numcompte_preteur, int montant_rendu,int montantdepart) throws AddressException {
        final String username = "volavitabanque@gmail.com"; // Change to your email
        final String password = "ksuqksabtbrvyutp"; // Change to your password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("volavitabanque@gmail.com")); // Change to your email
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email_preteur));
            message.setSubject("Avis de Remboursement - Volavita Banque");

            // Calculer le nombre de jours restants pour le remboursement
            LocalDate dateRendu = LocalDate.parse(date_rendu);
            LocalDate today = LocalDate.now();
            long daysRemaining = ChronoUnit.DAYS.between(today, dateRendu);

            // Construire le contenu de l'email
            String content = "Avis de Credit - Volavita Banque\n\n"
                    + "Cher(e) " + nom_preteur + ",\n\n"
                    + "Nous vous informons que vous avez empreunté avec succes une somme de "+ montantdepart +"Ar et que vous devez rembourser une somme de " + montant_rendu + " Ar. "
                    + "La date limite de remboursement est le " + date_rendu + ". Il vous reste actuellement " + daysRemaining + " jours pour effectuer ce remboursement.\n\n"
                    + "Veuillez prendre les mesures nécessaires pour assurer le remboursement dans les délais impartis afin d'éviter toute pénalité.\n"
                    + "Cordialement,\n"
                    + "Volavita Banque\n\n";

            message.setText(content);

            Transport.send(message);

            System.out.println("Message envoyé avec succès.");
            return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
            
        }
    }
}
