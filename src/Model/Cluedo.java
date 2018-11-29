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
    }

    private Note nouvelleNote(InitCartes initCartes) {
        Note note = new Note();
        note.addNote(new CheckNote("-------Armes-------"));
        for (int i = 0; i < initCartes.getPaquetArme().size(); i++) {
            note.addNote(new CheckNote(initCartes.getPaquetArme().getCarte(i).nom));
        }
        note.addNote(new CheckNote("-------Personnage-------"));
        for (int i = 0; i < initCartes.getPaquetSuspect().size(); i++) {
            note.addNote(new CheckNote(initCartes.getPaquetSuspect().getCarte(i).nom));
        }
        note.addNote(new CheckNote("-------Piéce-------"));
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
            Note note = nouvelleNote(new InitCartes());
            listJoueurs.add(new Main("Joueur"+i, note));
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

    public List<Main> getListJoueurs() {
        return listJoueurs;
    }

    public int getJoueurCourant() {
        return joueurCourant;
    }
}
