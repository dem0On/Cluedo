package View;
import Model.Cartes.Carte;
import Model.Cartes.CarteSuspect;
import Model.Cartes.InitCartes;
import Model.Cluedo;
import Model.Joueurs.ActionHypothese;
import Model.Joueurs.Actions;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.VerticalDirection;
import javafx.scene.Group;
import javafx.scene.Scene;
import Model.Joueurs.Main;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;



public class Hypothese {
    private Cluedo cluedo;
    private Stage primaryStage;
    private Stage popup;
    private BorderPane borderPane;
    private GridPane gridPane;
    private ArrayList<Carte> hypotheses;
    private ArrayList<Carte>listHypo;
    private static InitCartes initCartes;
    private ScrollBar sc;

    private int value=1000;
    private int value2=50;

    public Hypothese(Cluedo cluedo, Stage primaryStage){

        sc = new ScrollBar ();
        popup = new Stage();
        initCartes = new InitCartes();
        hypotheses = new ArrayList<>();
        listHypo = new ArrayList<>();
        gridPane = new GridPane ();
        this.cluedo = cluedo;
        this.primaryStage = primaryStage;
        borderPane = new BorderPane();
        borderPane.setLeft(gridPane);
        borderPane.setRight(sc);

        sc.setMin (0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight (this.value2);
        sc.setMax (this.value);


        Scene scene = new Scene(borderPane);
        sc.setLayoutX (scene.getWidth () - sc.getWidth ());



        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        popup.setScene(scene);

    }

    public void afficher(){
        afficherPersonnages();
        popup.show();
    }

    void afficherPersonnages() {
        hypotheses.clear();
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
            hypotheses.add(initCartes.getPaquetSuspect().getCarte(0));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);

        });

        buttonBleu.setOnAction(value ->  {
            System.out.println("Bleu");
            hypotheses.add(initCartes.getPaquetSuspect().getCarte(3));
            afficherArme();
        });

        buttonJaune.setOnAction(value ->  {
            System.out.println("Jaune");
            hypotheses.add(initCartes.getPaquetSuspect().getCarte(2));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);

        });

        buttonRouge.setOnAction(value ->  {
            System.out.println("Rouge");
            hypotheses.add(initCartes.getPaquetSuspect().getCarte(1));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);

        });

        buttonVert.setOnAction(value ->  {
            System.out.println("Vert");
            hypotheses.add(initCartes.getPaquetSuspect().getCarte(4));
            afficherArme();
            gridPane.getChildren().removeAll(buttonBlanc,buttonBleu,buttonJaune,buttonRouge,buttonVert,buttonViolet);

        });

        buttonViolet.setOnAction(value ->  {
            System.out.println("Violet");
            hypotheses.add(initCartes.getPaquetSuspect().getCarte(5));
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
            hypotheses.add(initCartes.getPaquetArme().getCarte(0));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttonpistolet.setOnAction(value ->  {
            System.out.println("pistolet");
            hypotheses.add(initCartes.getPaquetArme().getCarte(1));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttoncorde.setOnAction(value ->  {
            System.out.println("corde");
            hypotheses.add(initCartes.getPaquetArme().getCarte(2));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttonCouteau.setOnAction(value ->  {
            System.out.println("couteau");
            hypotheses.add(initCartes.getPaquetArme().getCarte(3));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttonCle.setOnAction(value ->  {
            System.out.println("cle");
            hypotheses.add(initCartes.getPaquetArme().getCarte(5));
            afficherPieces();
            gridPane.getChildren().removeAll(buttonBaton,buttonCle,buttonCouteau,buttoncorde,buttonpistolet,buttonchandelier);

        });
        buttonBaton.setOnAction(value ->  {
            System.out.println("Baton");
            hypotheses.add(initCartes.getPaquetArme().getCarte(4));
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
            hypotheses.add(initCartes.getPaquetLieu().getCarte(0));
            comparaison();

            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttoncuisine.setOnAction(value ->  {
            System.out.println("Cuisine");
            hypotheses.add(initCartes.getPaquetLieu().getCarte(1));
            comparaison();

            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonsalon.setOnAction(value ->  {
            System.out.println("Salon");
            hypotheses.add(initCartes.getPaquetLieu().getCarte(2));
            comparaison();

            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonSalle_de_Bal.setOnAction(value ->  {
            System.out.println("Salle de Bal");
            hypotheses.add(initCartes.getPaquetLieu().getCarte(3));
            comparaison();

            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonSalle_de_Billard.setOnAction(value ->  {
            System.out.println("Salle de Billard");
            hypotheses.add(initCartes.getPaquetLieu().getCarte(4));
            comparaison();

            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonConservatoire.setOnAction(value ->  {
            System.out.println("Conservatoire");
            hypotheses.add(initCartes.getPaquetLieu().getCarte(5));
            comparaison();

            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonHall.setOnAction(value ->  {
            System.out.println("Hall");
            hypotheses.add(initCartes.getPaquetLieu().getCarte(6));
            comparaison();

            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);
        });

        buttonLibrairie.setOnAction(value ->  {
            System.out.println("Librairie");
            hypotheses.add(initCartes.getPaquetLieu().getCarte(7));
            comparaison();
            gridPane.getChildren().removeAll();
        });

        buttonBureau.setOnAction(value ->  {
            System.out.println("Bureau");
            hypotheses.add(initCartes.getPaquetLieu().getCarte(8));
            comparaison();
            gridPane.getChildren().removeAll(buttonsalle_a_manger,buttoncuisine,buttonsalon,buttonBureau,buttonLibrairie,buttonHall,buttonConservatoire,buttonSalle_de_Billard,buttonSalle_de_Bal);

        });

    }

    private void comparaison(){
        gridPane.getChildren().clear();

        Label labelJoueur = new Label("Votre hypothèse : ");
        Button buttonJoueur;
        borderPane.setTop(labelJoueur);
        int compteur=0;

        for (Carte j : hypotheses) {
            buttonJoueur= new Button();
            buttonJoueur.setGraphic(new ImageView(j.getImageCarte()));
            gridPane.add(buttonJoueur,compteur, 0);
            compteur+=1;
        }



        Actions action = new ActionHypothese(hypotheses.get(0), hypotheses.get(1), hypotheses.get(2));
        afficherMain(cluedo.getListJoueurs().get(cluedo.getJoueurCourant()+1),action);
        action.setCarteMontrer(hypotheses.get(0));
        cluedo.getLog().add(action);

    }
    public void afficherMain(Main main, Actions action){
        Button buttuonMainJoueur;
        int compt = 0;
        for (Carte j : main.getMain()) {
            buttuonMainJoueur= new Button();
            buttuonMainJoueur.setOnAction(value ->{
                if(isCarteHypothese(j)){
                    System.out.println("montrer");
                    action.setCarteMontrer(j);
                    System.out.println(action.getCarteMontrer());
                    popup.close();

                }
                else{
                    System.out.println("n'est pas montrer");
                }
            });
            buttuonMainJoueur.setGraphic(new ImageView(j.getImageCarte()));
            gridPane.add(buttuonMainJoueur,compt, 1);
            compt+=1;
        }

    }

    private boolean isCarteHypothese(Carte carte){
        for (Carte carteHypothese : hypotheses) {
            if (carteHypothese.equal(carte)) return true;
        }
        return false;
    }


    public ArrayList<Carte> getHypotheses() {
        return hypotheses;
    }

}
