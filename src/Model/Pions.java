package Model;


import javafx.scene.paint.Color;

import java.awt.*;

public class Pions {
    private Color couleur;
    private int nbfDeplacement;
    private Point point;

    public Pions(Color couleur) {
        this.couleur = couleur;
        nbfDeplacement = 0;
        initPoint();
    }

    private void initPoint() {
        if(couleur == Color.RED) point = new Point(16, 0);
        else if(couleur == Color.YELLOW) point = new Point(23, 7);
        else if(couleur == Color.WHITE) point = new Point(14, 24);
        else if(couleur == Color.GREEN) point = new Point(9, 24);
        else if(couleur == Color.BLUE) point = new Point(0, 18);
        else if(couleur == Color.PURPLE) point = new Point(0, 5);
    }

    public void setNbfDeplacement(int nbfDeplacement) {
        this.nbfDeplacement = nbfDeplacement;
    }

    public void deplacement(){
        nbfDeplacement--;
    }

    public boolean isDeplacement(){
        return nbfDeplacement<=0;
    }

    public Color getCouleur() {
        return couleur;
    }

    public Point getPoint() {
        return point;
    }
}
