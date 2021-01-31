package control;

import model.Etat;
import view.Affichage;
import view.Parcours;

import javax.swing.*;

/** class Avancer
 * implémente un thread
 * faire avancer la position */

public class Avancer implements Runnable{
    private Affichage affichage;
    private Etat etat;
    private Parcours parcours;

    public static final int TIMEAVANCER = 2000;


    public Avancer(Affichage affichage, Etat etat, Parcours parcours) {
        this.affichage = affichage;
        this.parcours = parcours;
        this.etat = etat;
    }

    /** run */
    public void run() {
        while (!etat.testPerdu()) {
            try {
                this.parcours.setPosition();
                this.affichage.revalidate();
                this.affichage.repaint();
                Thread.sleep(TIMEAVANCER);
            }
            catch (Exception e) { e.printStackTrace(); }
        }
        JOptionPane.showMessageDialog(null, "Score : "+ parcours.getPosition());
    }
}
