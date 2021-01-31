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

    public int getEtat() {
        return etat;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition() {
        this.position -= 5;
    }

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
