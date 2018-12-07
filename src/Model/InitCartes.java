package Model;

import javafx.scene.image.Image;

public class InitCartes {
    private PaquetCartes paquetSuspect;
    private PaquetCartes paquetArme;
    private PaquetCartes paquetLieu;

    public InitCartes() {
        paquetArme = new PaquetCartes();
        paquetLieu = new PaquetCartes();
        paquetSuspect = new PaquetCartes();

        paquetSuspect.add(new CarteSuspect("Le Blanc", new Image("Image/Personnage/blanc.jpg")));
        paquetSuspect.add(new CarteSuspect("Le Rouge", new Image("Image/Personnage/rouge.jpg")));
        paquetSuspect.add(new CarteSuspect("Le jaune", new Image("Image/Personnage/jaune.jpg")));
        paquetSuspect.add(new CarteSuspect("Le Bleu", new Image("Image/Personnage/bleu.jpg")));
        paquetSuspect.add(new CarteSuspect("Le Vert", new Image("Image/Personnage/vert.jpg")));
        paquetSuspect.add(new CarteSuspect("Le Violet", new Image("Image/Personnage/violet.jpg")));

        paquetArme.add(new CarteArme("Le chandelier", new Image("Image/Arme/candlestick.jpg")));
        paquetArme.add(new CarteArme("Le pistolet", new Image("Image/Arme/revolver.jpg")));
        paquetArme.add(new CarteArme("La corde", new Image("Image/Arme/rope.jpg")));
        paquetArme.add(new CarteArme("Le Couteau", new Image("Image/Arme/knife.jpg")));
        paquetArme.add(new CarteArme("Le Baton", new Image("Image/Arme/pipe.jpg")));
        paquetArme.add(new CarteArme("La Clé", new Image("Image/Arme/wrench.jpg")));

        paquetLieu.add(new CarteLieu("La salle a manger", new Image("Image/Piece/diningroom.jpg")));
        paquetLieu.add(new CarteLieu("La cuisine", new Image("Image/Piece/kitchen.jpg")));
        paquetLieu.add(new CarteLieu("Le salon", new Image("Image/Piece/lounge.jpg")));
        paquetLieu.add(new CarteLieu("La Salle de Bal", new Image("Image/Piece/ballroom.jpg")));
        paquetLieu.add(new CarteLieu("La Salle de Billard", new Image("Image/Piece/billiardroom.jpg")));
        paquetLieu.add(new CarteLieu("Le Conservatoire", new Image("Image/Piece/conservatory.jpg")));
        paquetLieu.add(new CarteLieu("Le Hall", new Image("Image/Piece/hall.jpg")));
        paquetLieu.add(new CarteLieu("La Librairie", new Image("Image/Piece/library.jpg")));
        paquetLieu.add(new CarteLieu("Le Bureau", new Image("Image/Piece/study.jpg")));


        melangerPaquets();
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

    private void melangerPaquets(){
        paquetArme.melangerPacket();
        paquetLieu.melangerPacket();
        paquetSuspect.melangerPacket();
    }
}
