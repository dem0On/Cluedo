import Model.Cluedo;
import View.Fenetre;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appli extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Cluedo");
        Group root = new Group();
        Cluedo cluedo = new Cluedo(2);
        int WIDTH = 1000;
        int HEIGHT = 1000;
        Fenetre fenetre = new Fenetre(cluedo);
        root.getChildren().add(fenetre);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT, Color.LIGHTGREY));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}