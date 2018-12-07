package Model;

import Model.Carte;

public class Meurtrier {
    Carte carteSuspect;
    Carte carteArme;
    Carte carteLieu;

    public Carte getCarteSuspect() {
        return carteSuspect;
    }

    public void setCarteSuspect(Carte carteSuspect) {
        this.carteSuspect = carteSuspect;
    }

    public Carte getCarteArme() {
        return carteArme;
    }

    public void setCarteArme(Carte carteArme) {
        this.carteArme = carteArme;
    }

    public Carte getCarteLieu() {
        return carteLieu;
    }

    public void setCarteLieu(Carte carteLieu) {
        this.carteLieu = carteLieu;
    }

    public Meurtrier(Carte carteSuspect, Carte carteArme, Carte carteLieu) {
        this.carteSuspect = carteSuspect;
        this.carteArme = carteArme;
        this.carteLieu = carteLieu;
    }

    public void print(){
        System.out.println("Le tueur: " + carteSuspect.print());
        System.out.println("L'arme: " + carteArme.print());
        System.out.println("La piece: " + carteLieu.print());
    }
}
