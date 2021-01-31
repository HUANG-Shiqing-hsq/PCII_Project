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

    public void Ajoute_Oiseau(Oiseau oiseau){
        this.Liste_Oiseau.add(oiseau);
    }

    public void Supprime_Oiseau(Oiseau oiseau){
        this.Liste_Oiseau.remove(Liste_Oiseau.indexOf(oiseau));
    }

    public void dessiner(Graphics g){

        for(Oiseau oiseau:Liste_Oiseau){
            Image img = new ImageIcon("src/Oiseau/"+oiseau.getEtat()+".png").getImage();
            g.drawImage(img, oiseau.getPosition(), oiseau.getHauteur(), 80, 80, null);
        }

    }
}
