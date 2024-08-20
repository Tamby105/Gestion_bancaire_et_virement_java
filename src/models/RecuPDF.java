package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
/**
 * 
 * pdf: datevirement,numerovirement,numcompteenv/nom/soldemvt,numcompterec/nom,montant_virement
 *
 * @author fyrak
 */
public class RecuPDF {
    public static void genererVirement_pdf(String datevirement, int numero_virement, int numcompte_env, String nom_env, int soldemvt_env, int numcompte_rec,String nom_rec, int montant_virement) {
        try {
            // Création d'un nouveau document PDF
            PDDocument document = new PDDocument();
            /*String design = "";
            for (String d : chambres) {
                if (!design.equals("")) design+=", " + d;
                else design = d;
            }*/

            // Ajout d'une nouvelle page
            PDPage page = new PDPage();
            document.addPage(page);

            // Initialisation du contenu du PDF
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            File fontFile = new File("src/fonts/Poppins-Regular.ttf");
            PDType0Font font = PDType0Font.load(document, fontFile);
float startX = 250;  // Position de départ sur l'axe X
float startY = 700; // Position de départ sur l'axe Y
float leading = 25; 
            // Utilisation de la police chargée
            contentStream.setFont(font, 12);
            contentStream.beginText();

            // Position du texte et ajout des informations
            contentStream.newLineAtOffset(startX, startY);
contentStream.showText("Nom de la Banque");

// Affichage des lignes suivantes en ajustant la position verticale
contentStream.newLineAtOffset(0, -leading);
contentStream.showText("Date :" + datevirement);

contentStream.newLineAtOffset(-10, -60);
contentStream.showText("AVIS DE VIREMENT N°" + numero_virement);

contentStream.newLineAtOffset(-200, -leading);
contentStream.showText("N° de compte : " + numcompte_env);

contentStream.newLineAtOffset(0, -leading);
contentStream.showText(nom_env);

contentStream.newLineAtOffset(0, -leading);
contentStream.showText("Solde actuel : " + soldemvt_env + " Ar");

contentStream.newLineAtOffset(250, -leading);
contentStream.showText("A");

contentStream.newLineAtOffset(150, -leading);
contentStream.showText("N° de compte : " + numcompte_rec);

contentStream.newLineAtOffset(0, -leading);
contentStream.showText(nom_rec);

contentStream.newLineAtOffset(-400, -leading);
contentStream.showText("Montant : " + montant_virement + " Ar");

contentStream.endText();
            contentStream.close();

            // Sauvegarde du document PDF
            document.save(new File("C:/Users/Andrianarivony Tamby/Documents/AVIS DE VIREMENT N°" + numero_virement + ".pdf"));

            document.close();

            System.out.println("Le reçu du séjour a été généré avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la création du reçu du séjour : " + e.getMessage());
        }
    }
}
