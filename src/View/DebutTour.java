package View;

import Model.CheckNote;
import Model.Cluedo;
import Model.Main;
import Model.TypeCase;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class DebutTour {
    private Stage popup;
    private Cluedo cluedo;
    private Stage primaryStage;
    private Fenetre fenetre;
    private VBox vBox1;

    public DebutTour(Cluedo cluedo, Stage primaryStage) {
        popup = new Stage();
        this.cluedo = cluedo;
        this.primaryStage = primaryStage;
        initPopup();
    }

    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    private void initPopup() {
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        vBox1 = new VBox();
        Scene scene = new Scene(vBox1);
        popup.setScene(scene);
    }

    public void afficherPopUp(){
        vBox1.getChildren().clear();
        Button passageSecret = new Button("Prendre passage secret");
        Button lancerDes = new Button("Lancer les des");
        passageSecret.setOnAction(value->{
            int x = (int)cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().getX();
            int y = (int)cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().getY();
            TypeCase typeCase = cluedo.getPlateau()[x][y];
            if(typeCase == TypeCase.Bureau){
                cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().setLocation(19, 19);
            }
            if(typeCase == TypeCase.Cuisine){
                cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().setLocation(6, 2);
            }
            if(typeCase == TypeCase.SalleDeBain){
                cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().setLocation(3, 19);
            }
            if(typeCase == TypeCase.Conservatoire){
                cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().setLocation(17, 4);
            }
            fenetre.actualiserPlateau();
            popup.close();
            cluedo.joueurSuivant();
        });

        lancerDes.setOnAction(value->{
            Point point = cluedo.lancerDes();
            try {
                fenetre.lancerDes(point.x, point.y);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            popup.close();
            fenetre.actualiserPlateau();
            fenetre.actualiserInterface();
        });

        vBox1.getChildren().add(passageSecret);
        vBox1.getChildren().add(lancerDes);
        popup.show();
    }
}
