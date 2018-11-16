package Model;

import Model.Carte;

public class Meurtrier {
    Carte carteSuspect;
    Carte carteArme;
    Carte carteLieu;

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
