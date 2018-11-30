package View;

import Model.Cluedo;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Fenetre extends Parent {
    private Cluedo cluedo;
    private Canvas canvas;
    private BorderPane borderPaneRoot;
    private PopUp popUp;
    private Button buttonhypothese;
    private Label labelNbJoueur;

    public Fenetre(Cluedo cluedo, PopUp popUp){
        this.popUp = popUp;
        this.cluedo = cluedo;
        canvas = new Canvas(cluedo.getWidth(),cluedo.getHeigth());
        borderPaneRoot = new BorderPane();
        VBox vBox = new VBox();
        initPlateau();
        initAction();
        vBox.getChildren().add(borderPaneRoot);
        vBox.getChildren().add(canvas);
        this.getChildren().add(vBox);
    }

    private void initPlateau(){

        canvas.getGraphicsContext2D().drawImage(new Image("Image/plateau.jpg"), 0, 0);
    }

    private void initAction(){
        HBox hBox1 = new HBox();
        HBox hBoxJoueur = new HBox();

        buttonhypothese = new Button("Proposer une hypothèse");
        labelNbJoueur = new Label("Au tour de " + cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getNom());

        Button buttoncarte = new Button("Voir mes cartes");
        Button buttonAccuser = new Button("Accuser");
        Button buttonSuivant = new Button("Tour fini");
        Button buttonNote = new Button("Mes notes");


        hBox1.getChildren().add(buttoncarte);
        hBox1.getChildren().add(buttonhypothese);
        hBoxJoueur.getChildren().add(buttonNote);
        hBoxJoueur.getChildren().add(buttonSuivant);


        buttoncarte.setOnAction(value ->  {
            popUp.getPopUpMain().afficher();
        });

        buttonhypothese.setOnAction(value-> {
            popUp.getAccusation().afficherPersonnages();
        });

        buttonSuivant.setOnAction(value-> {
            cluedo.joueurSuivant();
            labelNbJoueur.setText("Au tour de " + cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getNom());
        });

        buttonNote.setOnAction(value ->  {
            popUp.getNoteView().afficherNote(cluedo.getListJoueurs().get(cluedo.getJoueurCourant()));
        });

        buttonAccuser.setOnAction(value-> {
            popUp.getAccusation().afficherPersonnages();
        });

        borderPaneRoot.setLeft(hBox1);
        borderPaneRoot.setCenter(labelNbJoueur);
        borderPaneRoot.setRight(hBoxJoueur);
    }
}
