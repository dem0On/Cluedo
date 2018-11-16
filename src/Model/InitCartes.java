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

        paquetSuspect.add(new CarteSuspect("Le Blanc", new Image("Image/blanc.png")));
        paquetSuspect.add(new CarteSuspect("Le Rouge", new Image("Image/rouge.png")));
        paquetSuspect.add(new CarteSuspect("Le jaune", new Image("Image/jaune.png")));

        paquetArme.add(new CarteArme("Le chandelier", new Image("Image/chandelier.png")));
        paquetArme.add(new CarteArme("Le pistolet", new Image("Image/pistolet.png")));
        paquetArme.add(new CarteArme("Le corde", new Image("Image/corde.png")));

        paquetLieu.add(new CarteLieu("La salle a manger", new Image("Image/salleAManger.png")));
        paquetLieu.add(new CarteLieu("La cuisine", new Image("Image/cuisine.png")));
        paquetLieu.add(new CarteLieu("Le salon", new Image("Image/salon.png")));

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
