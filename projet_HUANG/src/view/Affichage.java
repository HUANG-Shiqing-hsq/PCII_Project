package view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import model.Etat;

/**  classe dessinez un ovale noir
 * 1. dessiner un JPanel
 * 2. paint:
 *      2.1 sous-méthodes: paint_Oval pour dessiner un ovale noir dans le JPanel
 *      2.2 sous-méthodes: paint_line pour dessiner une ligne brisée rouge dans le JPanel
 *      2.3 dessiner le "position" dans le JPanel*/

public class Affichage extends JPanel {

    /** Constantes */
    /* Les dimensions du JPanel (largeur et hauteur) */
    public static final int LARG = 600;
    public static final int HAUT = 400;

    /** Les dimensions initiales du ovale */
    /* largeur */
    public static final int LARG_Oval = 40;
    /* hauteur */
    public static final int HAUT_Oval = 80;
    /* centre */
    public static final int OVAL_X = 60;
    public static final int OVAL_Y = HAUT - HAUT_Oval - 60;

    public static final int STROKE = 5;

    //un attribut de type Etat pour accéder à l’état du modèle
    private Etat etat;
    private VueOiseau vueOiseau;

    /** constructeur du Affichage */
    public Affichage(Etat etat, VueOiseau vueOiseau) {
        setPreferredSize(new Dimension(LARG, HAUT));
        this.etat = etat;
        this.vueOiseau = vueOiseau;
    }

    /** l’affichage de l’ovale */
    public void paint_Oval(Graphics2D g2d){
        //g.drawOval(Oval_x, etat.getHauteur(), LARG_Oval, HAUT_Oval);

        Stroke g2dstroke = g2d.getStroke();
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(STROKE));
        g2d.drawOval(OVAL_X, etat.getHauteur(), LARG_Oval, HAUT_Oval);
        g2d.setStroke(g2dstroke);
    }

    /** l’affichage de la ligne brisée */
    public void paint_line(Graphics2D g2d){

        Stroke g2dstroke = g2d.getStroke();
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(STROKE));
        ArrayList<Point> Liste = etat.getParcours().getParcours();

        for(int i=0;i<Liste.size()-1;i++)
            g2d.drawLine(Liste.get(i).x,Liste.get(i).y,Liste.get(i+1).x,Liste.get(i+1).y);

        g2d.setStroke(g2dstroke);
    }

    /** affichage */
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;

        //effacer l’intégralité de la zone de dessin
        g.clearRect(0,0,LARG, HAUT);

        //l’affichage de la position
        g.drawString("Position: "+ etat.getParcours().getPosition(),10, 10);

        //l’affichage de l’ovale
        paint_Oval(g2d);

        //l’affichage de la ligne brisée
        paint_line(g2d);

        //l'affichage de l'oiseau
        this.vueOiseau.dessiner(g);
    }
}
