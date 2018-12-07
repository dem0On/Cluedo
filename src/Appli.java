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
        Color[] tab = {Color.RED, Color.GREEN, Color.BLUE};
        Cluedo cluedo = new Cluedo(tab);
        int WIDTH = cluedo.getWidth();
        int HEIGHT = cluedo.getHeigth();

        PopUpMain popUpMain = new PopUpMain(cluedo, primaryStage);
        Accusation accusation = new Accusation(cluedo,primaryStage);
        NoteView noteView = new NoteView(cluedo,primaryStage);
        DebutTour debutTour = new DebutTour(cluedo, primaryStage);
        Hypothese hypothese = new Hypothese(cluedo, primaryStage);
        LancerDes lancerDes = new LancerDes(cluedo, primaryStage);

        PopUp popUp = new PopUp(popUpMain, accusation, noteView, debutTour, hypothese, lancerDes);

        Fenetre fenetre = new Fenetre(cluedo, popUp);


        Scene scene = new Scene(fenetre,WIDTH,HEIGHT, Color.LIGHTGREY);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}