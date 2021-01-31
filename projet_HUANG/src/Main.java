import javax.swing.*;
import control.*;
import model.Etat;
import control.Voler;
import model.Oiseau;
import view.Affichage;
import view.Parcours;
import view.VueOiseau;

/** Classe Main pour lancer le le programme
 * 1. construit un objet de chaque classe (modèle, vue et contrôleur), les relie ensemble,
 * 2. crée un objet JFrame dans laquelle elle ajoute la vue
 * 3. Lancer le Thread Voler
 * 4. Lancer le Thread Thread*/
public class Main {

    /** Main */
    public static void main(String [] args) {
        Parcours parcours = new Parcours();
        Etat etat = new Etat(parcours);

        VueOiseau vueOiseau = new VueOiseau();
        Affichage affichage = new Affichage(etat,vueOiseau);
        Control control = new Control(etat, affichage);

        new Oiseau(vueOiseau).start();

        new Voler(etat,affichage).start();

        new Thread(new Avancer(affichage, etat, parcours)).start();

        JFrame fenetre = new JFrame("PCII");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.add(affichage);
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.addMouseListener(control);

        fenetre.setLocationRelativeTo(null);
        
    }
}
