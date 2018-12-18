package Model.Cartes;

public class Meurtrier {
    Carte carteSuspect;
    Carte carteArme;
    Carte carteLieu;

    public Carte getCarteSuspect() {
        return carteSuspect;
    }

    public Carte getCarteArme() {
        return carteArme;
    }

    public Carte getCarteLieu() {
        return carteLieu;
    }

    public Meurtrier(Carte carteSuspect, Carte carteArme, Carte carteLieu) {
        this.carteSuspect = carteSuspect;
        this.carteArme = carteArme;
        this.carteLieu = carteLieu;
    }
}
