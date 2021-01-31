package model;
import view.Affichage;
import view.Parcours;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/** class Etat pour le modèle
 * 1. définit une variable hauteur
 * 2. définit une méthode jump: permet d’augmenter la valeur de la hauteur
 * 3. définit une méthode moveDown: permet de modifier la valeur de la hauteur de quelques pixels vers le bas*/
public class Etat {

    private int hauteur;
    private Parcours parcours;

    /** la taille du « saut » */
    public static final int SAUT = 10;

    /** la taille du « tomber » */
    public static final int BAS = 1;

    /** constructeur du Etat */
    public Etat (Parcours parcours){
        //la valeur initiale est la position initiale en y pour le centre du ovale noir
        this.hauteur= Affichage.OVAL_Y;
        this.parcours = parcours;
    }

    /** getHauteur */
    public int getHauteur(){
        return this.hauteur;
    }

    /** jump */
    //augmenter la valeur de la hauteur
    public void jump(){
        if(this.hauteur-SAUT > 0)
            this.hauteur -= SAUT;
    }

    /** moveDown */
    public void moveDown(){

        //sans sortir de la zone de dessin
        if(this.hauteur + BAS < Affichage.HAUT - Affichage.HAUT_Oval)
            this.hauteur += BAS;
    }

    /** getParcours */
    public Parcours getParcours() {
        return parcours;
    }

    public boolean testPerdu(){
        int x = Affichage.OVAL_X + Affichage.LARG_Oval/2;
        double y = this.hauteur - Affichage.STROKE/2;
        double y_line;

        Double x1 = 0.0, y1 = 0.0, x2 = 0.0, y2 = 0.0;
        double k, b;

        ArrayList<Point> Liste_Points = parcours.getParcours();

        //Pour trouver les deux points (x1, y1), (x2, y2) sur les côtés gauche et droit de l’ovale
        for(int i=0;i<Liste_Points.size()-1;i++){
            if(Liste_Points.get(i).getX() <= x && Liste_Points.get(i+1).getX() >= x){
                x1 = Liste_Points.get(i).getX();
                x2 = Liste_Points.get(i+1).getX();
                y1 = Liste_Points.get(i).getY();
                y2 = Liste_Points.get(i+1).getY();
            }
        }

        k = (y2 - y1) / (x2 -x1);
        b = (x2*y1 - x1*y2)/(x2 - x1);

        y_line = k*x + b;

        //détecter les collisions
        if (y <= y_line && y_line <= ( y + Affichage.HAUT_Oval + Affichage.STROKE))
            return false;
        else
            return true;

    }
}

