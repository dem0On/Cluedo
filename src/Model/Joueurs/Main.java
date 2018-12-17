package Model.Joueurs;

import Model.Cartes.Carte;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private String nom;
    private List<Carte> main;
    private Note note;
    private Pions pion;

    public Main(String nom, Note note, Pions pion) {
        this.nom = nom;
        this.note = note;
        this.pion = pion;
        this.main = new ArrayList<>();
    }

    public void ajouter(Carte carte){
        main.add(carte);
    }

    public Note getNote() {
        return note;
    }

    public Point lancerDes(){
        int des1 , des2, somme;
        des1 = (int) (Math.random()*6) + 1;
        des2 = (int) (Math.random()*6) + 1;
        somme = des1 + des2;
        pion.setNbfDeplacement(somme);
        return new Point(des1, des2);
    }

    public List<Carte> getMain() {
        return main;
    }

    public String getNom() {
        return nom;
    }

    public Pions getPion() {
        return pion;
    }
}