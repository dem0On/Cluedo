import Model.Cluedo;
import View.Accusation;
import View.Fenetre;
import Model.InitCartes;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class Appli extends Application {


    @Override
    public void start(Stage primaryStage){
        InitCartes initialisation = new InitCartes();
        boolean carteAffichee=false;
        primaryStage.setTitle("Cluedo");
        //Group root = new Group();
        Cluedo cluedo = new Cluedo(3);
        int WIDTH = 1000;
        int HEIGHT = 900;

        BorderPane borderPaneRoot = new BorderPane();
        Fenetre fenetre = new Fenetre(cluedo, primaryStage);
        Accusation accusation = new Accusation(cluedo,primaryStage);
        Scene scene = new Scene(borderPaneRoot,WIDTH,HEIGHT, Color.LIGHTGREY);
        primaryStage.setScene(scene);
        HBox hBox1 = new HBox();
        Button buttoncarte = new Button("Voir mes cartes");
        Button buttonhypothese = new Button("Proposer une hypothèse");
        hBox1.getChildren().addAll(buttoncarte);
        hBox1.getChildren().addAll(buttonhypothese);

        buttoncarte.setOnAction(value ->  {
            fenetre.afficher1();
        });

        buttonhypothese.setOnAction(value->{
            accusation.afficherPersonnages();

        });



        borderPaneRoot.setStyle("-fx-background-image: url('Image/plateau.jpg');");

        borderPaneRoot.setTop(hBox1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}