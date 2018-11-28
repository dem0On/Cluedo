package Model;

import java.util.ArrayList;
import java.util.List;

public class Cluedo {
    private List<Main> listJoueurs;
    private int nbJoueur;
    private int joueurCourant;
    private Meurtrier meutrier;
    private TypeCase plateau[][];

    public Cluedo(int nbJoueur) {
        this.nbJoueur = nbJoueur;
        joueurCourant = 0;
        listJoueurs = new ArrayList<>();
        InitPlateau initPlateau = new InitPlateau();
        plateau = initPlateau.getPlateau();
        for (int i = 0; i < nbJoueur; i++) {
            listJoueurs.add(new Main("Numéro"+i));
        }
        initJeu();
        print();
    }

    private void initJeu(){
        InitCartes initCartes = new InitCartes();
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

    public void joueurSuivant(){
        joueurCourant++;
        joueurCourant = joueurCourant%nbJoueur;
    }

    private void print(){
        for (int i = 0; i < nbJoueur; i++) {
            listJoueurs.get(i).print();
        }
    }

    public List<Main> getListJoueurs() {
        return listJoueurs;
    }

    public int getJoueurCourant() {
        return joueurCourant;
    }
}
