package Model.Cartes;

import javafx.scene.image.Image;

public class  Carte {
    protected String nom;
    protected Image imageCarte;

    public Carte(String nom, Image imageCarte) {
        this.nom = nom;
        this.imageCarte = imageCarte;
    }

    public boolean equal(Carte carte){
        return nom==carte.getNom();
    }

    public String print(){
        return nom;
    }

    public Image getImageCarte() {
        return imageCarte;
    }

    public String getNom(){
        return nom;
    }
}
