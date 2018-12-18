package Model.Cartes;

public class InitCartes {
    private PaquetCartes paquetSuspect;
    private PaquetCartes paquetArme;
    private PaquetCartes paquetLieu;

    public InitCartes() {
        paquetArme = new PaquetCartes();
        paquetLieu = new PaquetCartes();
        paquetSuspect = new PaquetCartes();

        paquetSuspect.add(new CarteSuspect("Le Blanc", 0));
        paquetSuspect.add(new CarteSuspect("Le Rouge", 1));
        paquetSuspect.add(new CarteSuspect("Le jaune", 2));
        paquetSuspect.add(new CarteSuspect("Le Bleu", 3));
        paquetSuspect.add(new CarteSuspect("Le Vert", 4));
        paquetSuspect.add(new CarteSuspect("Le Violet", 5));

        paquetArme.add(new CarteArme("Le chandelier", 6));
        paquetArme.add(new CarteArme("Le pistolet", 7));
        paquetArme.add(new CarteArme("La corde", 8));
        paquetArme.add(new CarteArme("Le Couteau", 9));
        paquetArme.add(new CarteArme("Le Baton", 10));
        paquetArme.add(new CarteArme("La Clé", 11));

        paquetLieu.add(new CarteLieu("La salle a manger", 12));
        paquetLieu.add(new CarteLieu("La cuisine", 13));
        paquetLieu.add(new CarteLieu("Le salon", 14));
        paquetLieu.add(new CarteLieu("La Salle de Bal", 15));
        paquetLieu.add(new CarteLieu("La Salle de Billard", 16));
        paquetLieu.add(new CarteLieu("Le Conservatoire",17));
        paquetLieu.add(new CarteLieu("Le Hall", 18));
        paquetLieu.add(new CarteLieu("La Librairie", 19));
        paquetLieu.add(new CarteLieu("Le Bureau", 20));
    }

    public PaquetCartes getPaquetSuspect() {
        return paquetSuspect;
    }

    public PaquetCartes getPaquetArme() {
        return paquetArme;
    }

    public PaquetCartes getPaquetLieu() {
        return paquetLieu;
    }

    public void melangerPaquets(){
        paquetArme.melangerPacket();
        paquetLieu.melangerPacket();
        paquetSuspect.melangerPacket();
    }
}
