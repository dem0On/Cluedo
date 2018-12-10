package View;

import Model.Cartes.Carte;
import Model.Cartes.InitCartes;
import Model.Cartes.Meurtrier;
import Model.Cluedo;
import Model.Joueurs.ActionAccusation;
import Model.Joueurs.Actions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;



public class Accusation {
    private Cluedo cluedo;
    private Stage primaryStage;
    private Stage popup;
    private GridPane gridPane;
    private BorderPane borderPane;
    private ArrayList<Carte> accusation;
    private static InitCartes initCartes;

    public Accusation(Cluedo cluedo, Stage primaryStage){
        initCartes = new InitCartes();
        popup = new Stage();
        accusation = new ArrayList<>();
        gridPane = new GridPane ();
        borderPane = new BorderPane();
        this.cluedo = cluedo;
        this.primaryStage = primaryStage;
        borderPane.setCenter(gridPane);
        Scene scene = new Scene(borderPane,1500,600, Color.LAWNGREEN);

        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        popup.setScene(scene);
    }

    public void afficher(){
        afficherPersonnages();
        popup.show();
    }

    void afficherPersonnages() {
        accusation.clear();
        gridPane.getChildren().clear();

        Image imageBlanc = new Image("Image/Personnage/blanc.jpg");
        Image imageBleu= new Image("Image/Personnage/bleu.jpg");
        Image imageJaune = new Image("Image/Personnage/jaune.jpg");
        Image imageRouge = new Image("Image/Personnage/rouge.jpg");
        Image imageVert = new Image("Image/Personnage/vert.jpg");
        Image imageViolet = new Image("Image/Personnage/violet.jpg");
        Button buttonBlanc = new Button();
        Button buttonBleu = new Button();
        Button buttonJaune = new Button();
        Button buttonRouge = new Button();
        Button buttonVert = new Button();
        Button buttonViolet = new Button();
        buttonBlanc.setGraphic(new ImageView(imageBlanc));
        buttonBleu.setGraphic(new ImageView(imageBleu));
        buttonJaune.setGraphic(new ImageView(imageJaune));
        buttonRouge.setGraphic(new ImageView(imageRouge));
        buttonVert.setGraphic(new ImageView(imageVert));
        buttonViolet.setGraphic(new ImageView(imageViolet));
        gridPane.add (buttonBlanc, 0, 0, 1, 1);
        gridPane.add (buttonBleu, 1, 0, 1, 1);
        gridPane.add (buttonJaune, 2, 0, 1, 1);
        gridPane.add (buttonRouge, 3, 0, 1, 1);
        gridPane.add (buttonVert, 4, 0, 1, 1);
        gridPane.add (buttonViolet, 5, 0, 1, 1);

        buttonBlanc.setOnAction(value ->  {
            System.out.println("Blanc");
            accusation.add(initCartes.getPaquetSuspect().getCarte(0));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);

        });

        buttonBleu.setOnAction(value ->  {
            System.out.println("Bleu");
            accusation.add(initCartes.getPaquetSuspect().getCarte(3));
            afficherArme();
        });

        buttonJaune.setOnAction(value ->  {
            System.out.println("Jaune");
            accusation.add(initCartes.getPaquetSuspect().getCarte(2));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);

        });

        buttonRouge.setOnAction(value ->  {
            System.out.println("Rouge");
            accusation.add(initCartes.getPaquetSuspect().getCarte(1));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);

        });

        buttonVert.setOnAction(value ->  {
            System.out.println("Vert");
            accusation.add(initCartes.getPaquetSuspect().getCarte(4));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);

        });

        buttonViolet.setOnAction(value ->  {
            System.out.println("Violet");
            accusation.add(initCartes.getPaquetSuspect().getCarte(5));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);
        });
    }

    private void afficherArme(){
        gridPane.getChildren().clear();

        Image chandelier = new Image("Image/Arme/candlestick.jpg");
        Image pistolet = new Image("Image/Arme/revolver.jpg");
        Image corde = new Image("Image/Arme/rope.jpg");
        Image Couteau = new Image("Image/Arme/knife.jpg");
        Image Baton = new Image("Image/Arme/pipe.jpg");
        Image Cle = new Image("Image/Arme/wrench.jpg");
        Button buttonchandelier = new Button();
        Button buttonpistolet = new Button();
        Button buttoncorde = new Button();
        Button buttonCouteau = new Button();
        Button buttonCle = new Button();
        Button buttonBaton = new Button();

        buttonchandelier.setGraphic(new ImageView(chandelier));
        buttonpistolet.setGraphic(new ImageView(pistolet));
        buttoncorde.setGraphic(new ImageView(corde));
        buttonCouteau.setGraphic(new ImageView(Couteau));
        buttonCle.setGraphic(new ImageView(Cle));
        buttonBaton.setGraphic(new ImageView(Baton));
        gridPane.add (buttonchandelier, 0, 0, 1, 1);
        gridPane.add (buttonpistolet, 1, 0, 1, 1);
        gridPane.add (buttoncorde, 2, 0, 1, 1);
        gridPane.add (buttonCouteau, 3, 0, 1, 1);
        gridPane.add (buttonCle, 4, 0, 1, 1);
        gridPane.add (buttonBaton, 5, 0, 1, 1);

        buttonchandelier.setOnAction(value ->  {
            System.out.println("chandelier");
            accusation.add(initCartes.getPaquetArme().getCarte(0));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttonpistolet.setOnAction(value ->  {
            System.out.println("pistolet");
            accusation.add(initCartes.getPaquetArme().getCarte(1));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttoncorde.setOnAction(value ->  {
            System.out.println("corde");
            accusation.add(initCartes.getPaquetArme().getCarte(2));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttonCouteau.setOnAction(value ->  {
            System.out.println("couteau");
            accusation.add(initCartes.getPaquetArme().getCarte(3));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttonCle.setOnAction(value ->  {
            System.out.println("cle");
            accusation.add(initCartes.getPaquetArme().getCarte(5));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttonBaton.setOnAction(value ->  {
            System.out.println("Baton");
            accusation.add(initCartes.getPaquetArme().getCarte(4));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);
        });
    }

    private void afficherPieces(){
        gridPane.getChildren().clear();

        Image salle_a_manger = new Image("Image/Piece/diningroom.jpg");
        Image cuisine = new Image("Image/Piece/kitchen.jpg");
        Image salon = new Image("Image/Piece/lounge.jpg");
        Image Salle_de_Bal = new Image("Image/Piece/ballroom.jpg");
        Image Salle_de_Billard = new Image("Image/Piece/billiardroom.jpg");
        Image Conservatoire = new Image("Image/Piece/conservatory.jpg");
        Image Hall = new Image("Image/Piece/hall.jpg");
        Image Librairie = new Image("Image/Piece/library.jpg");
        Image Bureau = new Image("Image/Piece/study.jpg");
        Button buttonsalle_a_manger = new Button();
        Button buttoncuisine = new Button();
        Button buttonsalon= new Button();
        Button buttonSalle_de_Bal = new Button();
        Button buttonSalle_de_Billard = new Button();
        Button buttonConservatoire = new Button();
        Button buttonHall = new Button();
        Button buttonLibrairie = new Button();
        Button buttonBureau = new Button();

        buttonsalle_a_manger.setGraphic(new ImageView(salle_a_manger));
        buttoncuisine.setGraphic(new ImageView(cuisine));
        buttonsalon.setGraphic(new ImageView(salon));
        buttonSalle_de_Bal.setGraphic(new ImageView(Salle_de_Bal));
        buttonSalle_de_Billard.setGraphic(new ImageView(Salle_de_Billard));
        buttonConservatoire.setGraphic(new ImageView(Conservatoire));
        buttonHall.setGraphic(new ImageView(Hall));
        buttonLibrairie.setGraphic(new ImageView(Librairie));
        buttonBureau.setGraphic(new ImageView(Bureau));

        gridPane.add (buttonsalle_a_manger, 0, 0, 1, 1);
        gridPane.add (buttoncuisine, 1, 0, 1, 1);
        gridPane.add (buttonsalon, 2, 0, 1, 1);
        gridPane.add (buttonSalle_de_Bal, 3, 0, 1, 1);
        gridPane.add (buttonSalle_de_Billard, 4, 0, 1, 1);
        gridPane.add (buttonConservatoire, 5, 0, 1, 1);
        gridPane.add (buttonHall, 6, 0, 1, 1);
        gridPane.add (buttonLibrairie, 7, 0, 1, 1);
        gridPane.add (buttonBureau, 8, 0, 1, 1);

        buttonsalle_a_manger.setOnAction(value ->  {
            System.out.println("salle a manger");
            accusation.add(initCartes.getPaquetLieu().getCarte(0));
            Comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttoncuisine.setOnAction(value ->  {
            System.out.println("Cuisine");
            accusation.add(initCartes.getPaquetLieu().getCarte(1));
            Comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonsalon.setOnAction(value ->  {
            System.out.println("Salon");
            accusation.add(initCartes.getPaquetLieu().getCarte(2));
            Comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonSalle_de_Bal.setOnAction(value ->  {
            System.out.println("Salle de Bal");
            accusation.add(initCartes.getPaquetLieu().getCarte(3));
            Comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonSalle_de_Billard.setOnAction(value ->  {
            System.out.println("Salle de Billard");
            accusation.add(initCartes.getPaquetLieu().getCarte(4));
            Comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonConservatoire.setOnAction(value ->  {
            System.out.println("Conservatoire");
            accusation.add(initCartes.getPaquetLieu().getCarte(5));
            Comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonHall.setOnAction(value ->  {
            System.out.println("Hall");
            accusation.add(initCartes.getPaquetLieu().getCarte(6));
            Comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonLibrairie.setOnAction(value ->  {
            System.out.println("Librairie");
            accusation.add(initCartes.getPaquetLieu().getCarte(7));
            Comparaison();
            gridPane.getChildren().removeAll();
        });

        buttonBureau.setOnAction(value ->  {
            System.out.println("Bureau");
            accusation.add(initCartes.getPaquetLieu().getCarte(8));
            Comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);

        });

    }

    private void Comparaison(){

        gridPane.getChildren().clear();
        BorderPane border = new BorderPane();

        Label labelJoueur = new Label("Votre Accusation : ");
        Label labelMain = new Label("Le Suspect : ");
        Button buttonJoueur;
        Button buttonMeurtrierPerso;
        Button buttonMeurtrierArme;
        Button buttonMeurtrierPiece;
        borderPane.setTop(labelJoueur);
        int compteur=0;

        for (Carte j : accusation) {
            buttonJoueur= new Button();
            buttonJoueur.setGraphic(new ImageView(j.getImageCarte()));
            gridPane.add(buttonJoueur,compteur, 0);
            compteur+=1;
        }

        Meurtrier meurtrier = cluedo.getMeutrier();

        buttonMeurtrierPerso = new Button();
        buttonMeurtrierArme = new Button();
        buttonMeurtrierPiece = new Button();
        buttonMeurtrierPerso.setGraphic(new ImageView(meurtrier.getCarteSuspect().getImageCarte()));
        buttonMeurtrierArme.setGraphic(new ImageView(meurtrier.getCarteArme().getImageCarte()));
        buttonMeurtrierPiece.setGraphic(new ImageView(meurtrier.getCarteLieu().getImageCarte()));
        gridPane.add(labelMain,0,1);
        gridPane.add(buttonMeurtrierPerso,0, 2);
        gridPane.add(buttonMeurtrierArme,1, 2);
        gridPane.add(buttonMeurtrierPiece,2, 2);

        ArrayList<Carte> listImageMeutrier = new ArrayList<>();
        listImageMeutrier.add(meurtrier.getCarteSuspect());
        listImageMeutrier.add(meurtrier.getCarteArme());
        listImageMeutrier.add(meurtrier.getCarteLieu());

        Actions action2 = new ActionAccusation(accusation.get(0), accusation.get(1), accusation.get(2));
        cluedo.getLog().add(action2);

        if(suspectEstTrouvee(listImageMeutrier, accusation)){
            System.out.println("Fin de partie");
        }
        else
            cluedo.addElliminer();
    }

    public boolean suspectEstTrouvee(ArrayList<Carte> suspect, ArrayList<Carte> meurtrier){
        int cpt = 0;
        System.out.println("avant");
        for(Carte i: suspect){
            for (Carte j : meurtrier){
                if (i.equal(j)){
                    System.out.println("tets");
                    cpt++;
                }
            }
        }
        if(cpt == 3){
            return true;
        }
        return false;
    }
}
