package Model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private String nom;
    private List<Carte> main;
    private Pions pion;

    public Main(String nom) {
        this.nom = nom;
        this.main = new ArrayList<>();
    }

    public void ajouter(Carte carte){
        main.add(carte);
    }

    public void print(){
        System.out.println("Main:");
        for (Carte carte : main) {
            System.out.println("- " + carte.print());
        }
    }

    public void lancerDes(){
        int des1 , des2, somme;
        des1 = (int) Math.random()*6 + 1;
        des2 = (int) Math.random()*6 + 1;
        somme = des1 + des2;
        pion.setNbfDeplacement(somme);
        System.out.println("nombre de déplacement : "+somme);
    }

    public List<Carte> getMain() {
        return main;
    }

    public String getNom() {
        return nom;
    }
}