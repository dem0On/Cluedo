import Model.Cluedo;
import View.Fenetre;
import View.Plateau;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;


import javax.swing.text.html.ListView;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class Appli extends Application {


    @Override
    public void start(Stage primaryStage){
        boolean carteAffichee=false;
        primaryStage.setTitle("Cluedo");
        //Group root = new Group();
        Cluedo cluedo = new Cluedo(3);
        int WIDTH = 1000;
        int HEIGHT = 900;

        BorderPane borderPaneRoot = new BorderPane();
        Fenetre fenetre = new Fenetre(cluedo, primaryStage);
        Scene scene = new Scene(borderPaneRoot,WIDTH,HEIGHT, Color.LIGHTGREY);
        primaryStage.setScene(scene);
        HBox hBox1 = new HBox();
        Button buttoncarte = new Button("Voir mes cartes");
        hBox1.getChildren().addAll(buttoncarte);

        buttoncarte.setOnAction(value ->  {
            fenetre.afficher1();
        });

        borderPaneRoot.setStyle("-fx-background-image: url('Image/plateau.jpg');");

        borderPaneRoot.setTop(hBox1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}