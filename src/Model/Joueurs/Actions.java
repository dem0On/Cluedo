package Model.Joueurs;

import Model.Cartes.Carte;

public class Actions {
    private Carte cartePersonnage;
    private Carte carteArme;
    private Carte cartePiece;
    private Carte carteMontrer;

    public Actions(Carte cartePersonnage, Carte carteArme, Carte cartePiece) {
        this.cartePersonnage = cartePersonnage;
        this.carteArme = carteArme;
        this.cartePiece = cartePiece;
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

    public Carte getCarteMontrer() {
        return carteMontrer;
    }
}
