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
        initJeu();
        print();
    }

    private Note nouvelleNote(InitCartes initCartes) {
        Note note = new Note();
        for (int i = 0; i < initCartes.getPaquetArme().size(); i++) {
            note.addNote(new CheckNote(initCartes.getPaquetArme().getCarte(i).nom));
        }
        for (int i = 0; i < initCartes.getPaquetSuspect().size(); i++) {
            note.addNote(new CheckNote(initCartes.getPaquetSuspect().getCarte(i).nom));
        }
        for (int i = 0; i < initCartes.getPaquetLieu().size(); i++) {
            note.addNote(new CheckNote(initCartes.getPaquetLieu().getCarte(i).nom));
        }
        return note;
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

        for (int i = 0; i < nbJoueur; i++) {
            Note note = nouvelleNote(initCartes);
            listJoueurs.add(new Main("Numéro"+i, note));
        }

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
