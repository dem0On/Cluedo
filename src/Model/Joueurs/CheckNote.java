package Model.Joueurs;

public class CheckNote {
    private String nom;
    private boolean isCheck;

    public CheckNote(String nom) {
        this.nom = nom;
        isCheck = false;
    }

    public void check(){
        isCheck = true;
    }

    public void deCheck(){
        isCheck = false;
    }

    public String getNom() {
        return nom;
    }

    public boolean isCheck() {
        return isCheck;
    }
}
