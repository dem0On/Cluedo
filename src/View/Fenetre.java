package View;

import Controller.KeyController;
import Model.Cluedo;
import Model.Pions;
import Model.TypeCase;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.awt.*;

public class Fenetre extends Parent {
    private Cluedo cluedo;
    private Canvas canvas;
    private BorderPane borderPaneRoot;
    private PopUp popUp;
    private Button buttonhypothese;
    private Label labelNbJoueur;

    public Fenetre(Cluedo cluedo, PopUp popUp) {
        KeyController keyController = new KeyController(cluedo, this);
        this.popUp = popUp;
        this.cluedo = cluedo;
        this.popUp.getDebutTour().setFenetre(this);
        canvas = new Canvas(cluedo.getWidth(), cluedo.getHeigth());
        borderPaneRoot = new BorderPane();
        VBox vBox = new VBox();
        actualiserPlateau();
        initAction();
        vBox.getChildren().add(borderPaneRoot);
        vBox.getChildren().add(canvas);
        this.setOnKeyPressed(keyController);
        this.getChildren().add(vBox);
    }

    private void initAction() {
        HBox hBox1 = new HBox();
        HBox hBoxJoueur = new HBox();

        buttonhypothese = new Button("Proposer une hypothèse");
        buttonhypothese.setVisible(false);
        labelNbJoueur = new Label("Au tour de " + cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getNom() + "  Nombre de déplacement restant : " + cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getNbfDeplacement());

        Button buttoncarte = new Button("Voir mes cartes");
        Button buttonAccuser = new Button("Accuser");
        Button buttonSuivant = new Button("Tour fini");
        Button buttonNote = new Button("Mes notes");


        hBox1.getChildren().add(buttoncarte);
        hBox1.getChildren().add(buttonhypothese);
        hBoxJoueur.getChildren().add(buttonNote);
        hBoxJoueur.getChildren().add(buttonSuivant);


        buttoncarte.setOnAction(value -> {
            popUp.getPopUpMain().afficher();
        });

        buttonhypothese.setOnAction(value -> {
            popUp.getAccusation().afficherPersonnages();
        });

        buttonSuivant.setOnAction(value -> {
            cluedo.joueurSuivant();
            int x = (int)cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().getX();
            int y = (int)cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().getY();
            buttonhypothese.setVisible(false);
            if(validerDebutTour(x,y) == null){
                cluedo.lancerDes();
            }
            else{
                popUp.getDebutTour().afficherPopUp();
            }
            actualiserInterface();
        });

        buttonNote.setOnAction(value -> {
            popUp.getNoteView().afficherNote(cluedo.getListJoueurs().get(cluedo.getJoueurCourant()));
        });

        buttonAccuser.setOnAction(value -> {
            popUp.getAccusation().afficherPersonnages();
        });

        borderPaneRoot.setLeft(hBox1);
        borderPaneRoot.setCenter(labelNbJoueur);
        borderPaneRoot.setRight(hBoxJoueur);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void actualiserPlateau() {
        //x == 50 et y==40  et case 30 carre donc pour i et j on doit placer pion en  i*30+56 j*30+
        canvas.getGraphicsContext2D().restore();
        canvas.getGraphicsContext2D().drawImage(new Image("Image/plateau.jpg"), 0, 0);
        for (int i = 0; i < cluedo.getListJoueurs().size(); i++) {
            Pions pions = cluedo.getListJoueurs().get(i).getPion();
            canvas.getGraphicsContext2D().setFill(pions.getCouleur());
            canvas.getGraphicsContext2D().fillOval(pions.getPoint().getX() * 30 + 56, pions.getPoint().getY() * 30 + 46, 15, 15);
        }
    }

    public void actualiserInterface() {
        labelNbJoueur.setText("Au tour de " + cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getNom() + "  Nombre de déplacement restant : " + cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getNbfDeplacement());
    }

    public void mettreHypothese() {
        buttonhypothese.setVisible(true);
    }

    public TypeCase validerDebutTour(int x, int y){
        if(cluedo.getPlateau()[x][y] == TypeCase.Bureau){
            return TypeCase.Bureau;
        }
        else if(cluedo.getPlateau()[x][y] == TypeCase.SalleDeBain){
            return TypeCase.SalleDeBain;
        }
        else if(cluedo.getPlateau()[x][y] == TypeCase.Cuisine){
            return TypeCase.Cuisine;
        }
        else if(cluedo.getPlateau()[x][y] == TypeCase.Conservatoire){
            return TypeCase.Conservatoire;
        }
        return null;
    }
}