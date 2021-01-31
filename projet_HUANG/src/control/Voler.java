package control;

import model.Etat;
import view.Affichage;

/** class Voler
 * hérite de Thread
 * fait redescendre progressivement (linéairement) la valeur de la hauteur*/

public class Voler extends Thread {
    private Etat etat;
    private Affichage affichage;
    public static final int TIMEMOVE = 100;

    public Voler(Etat etat, Affichage affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }

    /** run */
    @Override
    public void run() {
        //utilisera une boucle infinie pour appelle moveDown
        while (!etat.testPerdu()) {

            try {
                etat.moveDown();

                //Pour forcer le dessin
                this.affichage.revalidate();
                this.affichage.repaint();

                Thread.sleep(TIMEMOVE);
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
