import Model.Cluedo;
import View.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appli extends Application {


    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Cluedo");
        //Group root = new Group();
        Cluedo cluedo = new Cluedo(3);
        int WIDTH = 1000;
        int HEIGHT = 900;

        PopUpMain popUpMain = new PopUpMain(cluedo, primaryStage);
        Accusation accusation = new Accusation(cluedo,primaryStage);
        NoteView noteView = new NoteView(cluedo,primaryStage);

        PopUp popUp = new PopUp(popUpMain, accusation, noteView);

        Fenetre fenetre = new Fenetre(cluedo, popUp);

        Scene scene = new Scene(fenetre,WIDTH,HEIGHT, Color.LIGHTGREY);

        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}