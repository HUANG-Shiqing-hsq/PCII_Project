/** Class VueOiseau 
    1. possède un attribut de type ArrayList<Oiseau>
    2. une méthode dessiner(Graphics g) pour gérer l’affichage des oiseaux 
    3. les 2 méthode: Ajoute_Oiseau et Supprime_Oiseau pour motifier Liste_Oiseau */
package view;

import model.Oiseau;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VueOiseau {
    private ArrayList<Oiseau> Liste_Oiseau;

    public VueOiseau(){
        this.Liste_Oiseau = new ArrayList<Oiseau>();

    }

    /** Ajoute_Oiseau */
    public void Ajoute_Oiseau(Oiseau oiseau){
        this.Liste_Oiseau.add(oiseau);
    }

    /** Supprime_Oiseau */
    public void Supprime_Oiseau(Oiseau oiseau){
        this.Liste_Oiseau.remove(Liste_Oiseau.indexOf(oiseau));
    }

    /** dessiner */
    public void dessiner(Graphics g){

        for(Oiseau oiseau:Liste_Oiseau){
            Image img = new ImageIcon("src/Oiseau/"+oiseau.getEtat()+".png").getImage();
            g.drawImage(img, oiseau.getPosition(), oiseau.getHauteur(), 80, 80, null);
        }

    }
}
