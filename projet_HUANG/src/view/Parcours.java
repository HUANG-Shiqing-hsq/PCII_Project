package view;

import control.Avancer;
import control.Voler;
import model.Etat;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/** class Parcours
 * l’attribut principal est un objet ArrayList<Point> (une liste de points)
 * pour créer la ligne brisée, avec des pentes variables générées aléatoirement */

public class Parcours {

    private ArrayList<Point> Liste_Points;
    private int position;

    /** la valeur de l’incrément étant */
    public static final int AVANCER_POSITION = 1;

    public Parcours(){
        this.Liste_Points = new ArrayList<Point>();
        int x= Affichage.OVAL_X + Affichage.LARG_Oval/2;
        int y= Affichage.OVAL_Y + Affichage.HAUT_Oval/2;
        this.Liste_Points.add( new Point(x,y) );
        initList();
    }

    /** initList
     *  Initialisez cette liste à l’aide de valeurs aléatoires d’abscisse croissante
     *  le dernier point est au delà de la bordure de l’écran*/
    public void initList(){
        int x= (int) Liste_Points.get((Liste_Points.size() - 1)).getX();
        int y;
        do{
            x += ( new Random( ).nextInt( Affichage.LARG));
            y = ( new Random( ).nextInt( Affichage.HAUT - 2 * Affichage.HAUT_Oval ) + Affichage.HAUT_Oval );
            this.Liste_Points.add( new Point(x,y) );
        }while( x < Affichage.LARG );
    }

    /** renvoie la liste de points visibles */
    public ArrayList<Point> getParcours(){

        //for(Point a:Liste_Points)
          //  System.out.println(a);

        int x1 = 0, y1 = 0;

        for(Point point:Liste_Points)
            point.x -= position;

        //Lorsque le deuxième point sur de la zone visible,
        //il faut retirer le premier point de la liste : il ne sera plus utilisé.
        if(this.Liste_Points.get(1).x <0 )
            this.Liste_Points.remove(0);

        //Lorsque le dernier point rentre dans la fenêtre visible,
        //il faut générer un point supplémentaire pour que la ligne brisée ne s’interrompe pas.
        if(this.Liste_Points.get(this.Liste_Points.size()-1).x<Affichage.LARG){
            x1 = this.Liste_Points.get(this.Liste_Points.size()-1).x;
            y1 = this.Liste_Points.get(this.Liste_Points.size()-1).y;
            int x = x1 + ( new Random( ).nextInt( Affichage.LARG ));
            int y = ( new Random( ).nextInt( Affichage.HAUT - 2 * Affichage.HAUT_Oval ) + ( Affichage.HAUT_Oval ));

            if (y < Affichage.HAUT_Oval){
                y = Affichage.HAUT_Oval;
            }
            else if (y > Affichage.HAUT - Affichage.HAUT_Oval){
                y = Affichage.HAUT - Affichage.HAUT_Oval;
            }

            this.Liste_Points.add(new  Point(x,y));
        }

        return Liste_Points;
    }

    /** getPosition */
    public int getPosition() {
        return position;
    }

    /** setPosition */
    public void setPosition() {
        //avancer la position de quelques pixels
        this.position += AVANCER_POSITION;
    }
}
