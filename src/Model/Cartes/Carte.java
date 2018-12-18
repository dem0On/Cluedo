package Model.Cartes;


public class  Carte {
    protected String nom;
    protected int imageCarte;

    public Carte(String nom, int imageCarte) {
        this.nom = nom;
        this.imageCarte = imageCarte;
    }

    public boolean equal(Carte carte){
        return nom==carte.getNom();
    }

    public String print(){
        return nom;
    }

    public int getImageCarte() {
        return imageCarte;
    }

    public String getNom(){
        return nom;
    }
}
