package Model;

import Model.Cartes.*;
import Model.Joueurs.*;
import Model.Plateau.InitPlateau;
import Model.Plateau.TypeCase;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cluedo {
    private List<Main> listJoueurs;
    private List<Main> listJoueursElliminer;
    private int nbJoueur;
    private int joueurCourant;
    private HistoryAction log;


    public Meurtrier meutrier;
    private TypeCase plateau[][];

    public Cluedo(Color[] tabCouleurJoueur, String[] nomJoueur) {
        log = new HistoryAction();
        testerLog();
        this.nbJoueur = tabCouleurJoueur.length;
        joueurCourant = 0;
        listJoueurs = new ArrayList<>();
        listJoueursElliminer = new ArrayList<>();
        InitPlateau initPlateau = new InitPlateau();
        plateau = initPlateau.getPlateau();
        initJeu(tabCouleurJoueur, nomJoueur);
    }

    private Note nouvelleNote(InitCartes initCartes) {
        Note note = new Note();
        note.addNote(new CheckNote("-------Armes-------"));
        for (int i = 0; i < initCartes.getPaquetArme().size(); i++) {
            note.addNote(new CheckNote(initCartes.getPaquetArme().getCarte(i).getNom()));
        }
        note.addNote(new CheckNote("-------Personnage-------"));
        for (int i = 0; i < initCartes.getPaquetSuspect().size(); i++) {
            note.addNote(new CheckNote(initCartes.getPaquetSuspect().getCarte(i).getNom()));
        }
        note.addNote(new CheckNote("-------Piéce-------"));
        for (int i = 0; i < initCartes.getPaquetLieu().size(); i++) {
            note.addNote(new CheckNote(initCartes.getPaquetLieu().getCarte(i).getNom()));
        }
        return note;
    }

    private void initJeu(Color[] tabCouleurJoueur, String[] nomJoueur){
        InitCartes initCartes = new InitCartes();
        initCartes.melangerPaquets();
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

        for (int i = 0; i < tabCouleurJoueur.length; i++) {
            Note note = nouvelleNote(new InitCartes());
            listJoueurs.add(new Main(nomJoueur[i], note, new Pions(tabCouleurJoueur[i])));
        }

        int taillePaquet = paquetCartes.size();
        for (int i = 0; i < taillePaquet; i++) {
            listJoueurs.get(i%nbJoueur).ajouter(paquetCartes.tirerCarte());
        }
    }

    public void joueurSuivant(){
        joueurCourant++;
        joueurCourant = joueurCourant%nbJoueur;
        for (int i = 0; i < listJoueursElliminer.size(); i++) {
            if(listJoueursElliminer.get(i) == listJoueurs.get(joueurCourant)){
                joueurCourant++;
                joueurCourant = joueurCourant%nbJoueur;
            }
        }
        if(listJoueursElliminer.size()==listJoueurs.size()){
            System.out.println("Fin de Partie");
        }
    }

    public Point lancerDes(){
        return listJoueurs.get(joueurCourant).lancerDes();
    }

    public List<Main> getListJoueurs() {
        return listJoueurs;
    }

    public int getJoueurCourant() {
        return joueurCourant;
    }

    public TypeCase[][] getPlateau() { return plateau; }

    public Meurtrier getMeutrier() {
        return meutrier;
    }

    public void setMeutrier(Meurtrier meutrier) {
        this.meutrier = meutrier;
    }

    public HistoryAction getLog() {
        return log;
    }

    private void testerLog(){
        Actions action = new ActionHypothese(new CarteSuspect("Le Violet", new Image("Image/Personnage/violet.jpg")), new CarteArme("Le chandelier", new Image("Image/Arme/candlestick.jpg")), new CarteLieu("La salle a manger", new Image("Image/Piece/diningroom.jpg")));
        action.setCarteMontrer(new CarteSuspect("Le Violet", new Image("Image/Personnage/violet.jpg")));
        log.add(action);

        Actions action2 = new ActionAccusation(new CarteSuspect("Le Violet", new Image("Image/Personnage/violet.jpg")), new CarteArme("Le chandelier", new Image("Image/Arme/candlestick.jpg")), new CarteLieu("La salle a manger", new Image("Image/Piece/diningroom.jpg")));
        action2.setCarteMontrer(new CarteSuspect("Le Violet", new Image("Image/Personnage/violet.jpg")));
        log.add(action2);

        Actions action3 = new ActionHypothese(new CarteSuspect("Le Violet", new Image("Image/Personnage/violet.jpg")), new CarteArme("Le chandelier", new Image("Image/Arme/candlestick.jpg")), new CarteLieu("La salle a manger", new Image("Image/Piece/diningroom.jpg")));
        log.add(action3);
    }

    public void addElliminer(){
        listJoueursElliminer.add(listJoueurs.get(joueurCourant));
    }
}
