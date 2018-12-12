import Model.Cluedo;
import View.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appli extends Application {

    private PopUp popUp;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Cluedo");
        FenetreMenu fenetre = new FenetreMenu(this);
        Scene scene = new Scene(fenetre,500, 500, Color.LIGHTGREY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void lancerJeu(Color[] tabCouleurJoueur, String[] nomJoueur){
        Cluedo cluedo = new Cluedo(tabCouleurJoueur, nomJoueur);
        final int Width = 1000; // 1000 avec log ou 800 sans log pour la fenetre
        final int Heigth = 825;

        PopUpMain popUpMain = new PopUpMain(cluedo, primaryStage);
        Accusation accusation = new Accusation(cluedo,primaryStage);
        NoteView noteView = new NoteView(cluedo,primaryStage);
        DebutTour debutTour = new DebutTour(cluedo, primaryStage);
        Hypothese hypothese = new Hypothese(cluedo, primaryStage);
        LancerDes lancerDes = new LancerDes(cluedo, primaryStage);

        popUp = new PopUp(popUpMain, accusation, noteView, debutTour, hypothese, lancerDes);

        Fenetre fenetre = new Fenetre(cluedo, popUp);


        Scene scene = new Scene(fenetre,Width,Heigth, Color.LIGHTGREY);

        primaryStage.setScene(scene);
        fenetre.lancerDes();
        fenetre.actualiserInterface();
    }


    public static void main(String[] args) {
        launch(args);
    }
}