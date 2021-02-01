/** Class Oiseau 
    1. définit les donees de l'oiseau:
           delai: qui indique le temps (en millisecondes) entre chaque mise à jour de l’affichage pour l’oiseau
           etat: qui permet de savoir dans quelle position est l’oiseau
           hauteur: la hauteur de l’oiseau dans la fenêtre graphique
           position: l’abscisse 
     2.La fonction run met à jour l’état et la position de l’oiseau toutes les delai millisecondes */
package model;

import view.Affichage;
import view.VueOiseau;

import java.util.Random;

public class Oiseau extends Thread{
    private int delai;
    private int etat;
    private int hauteur;
    private int position;
    private VueOiseau vueOiseau = new VueOiseau();

    public Oiseau(VueOiseau vueOiseau){
        this.delai = ( new Random( ).nextInt( 200 ));
        this.hauteur = ( new Random( ).nextInt( Affichage.HAUT ));
        this.position = Affichage.LARG;
        this.etat = 0;
        this.vueOiseau = vueOiseau;
        this.vueOiseau.Ajoute_Oiseau(this);
    }

    /** getEtat */
    public int getEtat() {
        return etat;
    }

    /** getHauteur */
    public int getHauteur() {
        return hauteur;
    }

    /** getPosition */
    public int getPosition() {
        return position;
    }

    /** setPosition */
    public void setPosition() {
        this.position -= 5;
    }

    /** setEtat */
    public void setEtat() {
        if(this.etat == 7)
            this.etat = 0;
        else
            this.etat ++;
    }

    /** run */
    @Override
    public void run() {
        //utilisera une boucle infinie pour appelle moveDown
        while (this.position > 0) {

            try {
                //setVueOiseau(this.vueOiseau);
                setPosition();
                setEtat();
                this.delai = ( new Random( ).nextInt( 200 ));
                Thread.sleep(delai);
            }
            catch (Exception e) { e.printStackTrace(); }
        }
        this.vueOiseau.Supprime_Oiseau(this);
    }
}
