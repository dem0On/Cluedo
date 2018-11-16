package Model;

import java.util.ArrayList;
import java.util.List;

public class Cluedo {
    private List<Main> listJoueurs;
    private InitCartes initCartes;
    private int nbJoueur;
    private Meurtrier meutrier;

    public Cluedo(int nbJoueur) {
        this.nbJoueur = nbJoueur;
        listJoueurs = new ArrayList<>();
        initCartes = new InitCartes();
        for (int i = 0; i < nbJoueur; i++) {
            listJoueurs.add(new Main());
        }
        initJeu();
        print();
    }

    private void initJeu(){
        PaquetCartes paquetLieu = initCartes.getPaquetLieu();
        PaquetCartes paquetArme = initCartes.getPaquetArme();
        PaquetCartes paquetMeutrtrier = initCartes.getPaquetSuspect();
        
        Carte lieuMeurtre = paquetLieu.tirerCarte();
        Carte armeMeurtre = paquetArme.tirerCarte();
        Carte meurtrier = paquetMeutrtrier.tirerCarte();
        meutrier = new Meurtrier(meurtrier, armeMeurtre, lieuMeurtre);
        
        PaquetCartes paquetCartes = new PaquetCartes();
        paquetCartes.add(paquetArme);
        paquetCartes.add(paquetLieu);
        paquetCartes.add(paquetMeutrtrier);
        paquetCartes.melangerPacket();

        int taillePaquet = paquetCartes.size();
        for (int i = 0; i < taillePaquet; i++) {
            listJoueurs.get(i%nbJoueur).ajouter(paquetCartes.tirerCarte());
        }
    }

    private void print(){
        for (int i = 0; i < nbJoueur; i++) {
            listJoueurs.get(i).print();
        }
    }

    public List<Main> getListJoueurs() {
        return listJoueurs;
    }
}
