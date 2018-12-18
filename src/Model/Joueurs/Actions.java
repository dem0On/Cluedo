package Model.Joueurs;

import Model.Cartes.Carte;

public class Actions {
    private Carte cartePersonnage;
    private Carte carteArme;
    private Carte cartePiece;
    private Carte carteMontrer;
    private Main joueurQuiAFait;
    private Main joueurQuiAMontrer;

    public Actions(Carte cartePersonnage, Carte carteArme, Carte cartePiece, Main joueurQuiAFait) {
        this.cartePersonnage = cartePersonnage;
        this.carteArme = carteArme;
        this.cartePiece = cartePiece;
        this.joueurQuiAFait = joueurQuiAFait;
        joueurQuiAMontrer = null;
        carteMontrer = null;
    }

    public boolean isHypothese(){
        return false;
    }

    public void setCarteMontrer(Carte carteMontrer){
        this.carteMontrer = carteMontrer;
    }

    public Carte getCartePersonnage() {
        return cartePersonnage;
    }

    public Carte getCarteArme() {
        return carteArme;
    }

    public Carte getCartePiece() {
        return cartePiece;
    }

    public void setJoueurQuiAMontrer(Main joueurQuiAMontrer) {
        this.joueurQuiAMontrer = joueurQuiAMontrer;
    }

    public Main getJoueurQuiAFait() {
        return joueurQuiAFait;
    }

    public Main getJoueurQuiAMontrer() {
        return joueurQuiAMontrer;
    }
}
