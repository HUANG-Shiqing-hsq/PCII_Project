package control;
import model.Etat;
import view.Affichage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** classe Control pour le controleur
 *  1. implémente le listener MouseListener
 *  qui fait appels à la méthode jump de la classe Etat
 *  ensuite, informe la vue d’un changement*/
public class Control implements MouseListener {
    private Etat etat;
    private Affichage affichage;

    /** constructeur du Control */
    public  Control(Etat etat, Affichage affichage){
        this.etat = etat;
        this.affichage = affichage;
    }

    /** MouseListener */
    public void mouseClicked(MouseEvent m){

        if(etat.testPerdu()){
            affichage.removeMouseListener(this);
        }
        else{
            etat.jump();
            affichage.repaint();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
