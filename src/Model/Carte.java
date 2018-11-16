package Model;

import javafx.scene.image.Image;

public class  Carte {
    protected String nom;
    protected Image imageCarte;

    public Carte(String nom, Image imageCarte) {
        this.nom = nom;
        this.imageCarte = imageCarte;
    }

    public String print(){
        return nom;
    }

    public Image getImageCarte() {
        return imageCarte;
    }
}
