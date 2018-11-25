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
        Group root = new Group();
        Cluedo cluedo = new Cluedo(4);
        int WIDTH = 1000;
        int HEIGHT = 1000;

        Fenetre fenetre = new Fenetre(cluedo);
        BorderPane borderPaneRoot = new BorderPane();
        Scene scene = new Scene(borderPaneRoot,WIDTH,HEIGHT, Color.LIGHTGREY);
        primaryStage.setScene(scene);
        HBox hBox1 = new HBox();
        Button buttoncarte = new Button("Voire mes cartes");
        Button buttoncarteclose = new Button("Cacher vos cartes");
        hBox1.getChildren().addAll(buttoncarte);

        buttoncarte.setOnAction(value ->  {
                hBox1.getChildren().addAll(fenetre,buttoncarteclose);
                hBox1.getChildren().remove(buttoncarte);
        });
        buttoncarteclose.setOnAction(value ->  {
            hBox1.getChildren().removeAll(fenetre,buttoncarteclose);
            hBox1.getChildren().add(buttoncarte);
        });


        VBox vBox1 = new VBox();
        Image plateau = new Image("Image/plateau.jpg");
        ImageView iv = new ImageView(plateau);
        iv.setFitWidth(650);
        iv.setFitHeight(650);

        vBox1.getChildren().add(iv);
        borderPaneRoot.setRight(vBox1);
        borderPaneRoot.setTop(hBox1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}