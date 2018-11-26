package View;

import Model.Cluedo;
import Model.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Fenetre extends Parent {
    private Cluedo cluedo;
    private Canvas canvas;
    private Stage primaryStage;
    private Stage popup;

    public Fenetre(Cluedo cluedo, Stage primaryStage){
        popup = new Stage();
        this.cluedo = cluedo;
        this.primaryStage = primaryStage;
        canvas = new Canvas(1100, 300);
        initPopup();
    }

    private void initPopup(){
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        HBox hBox1 = new HBox();
        hBox1.getChildren().add(canvas);
        Scene scene = new Scene(hBox1);
        popup.setScene(scene);
    }

    public void afficher1(){
        afficherMain(cluedo.getListJoueurs().get(0));
    }

    public void afficherMain(Main main){
        canvas.getGraphicsContext2D().restore();
        for (int i = 0; i < main.getMain().size(); i++) {
            canvas.getGraphicsContext2D().drawImage(main.getMain().get(i).getImageCarte(), 20+i*160, 50);
        }
        popup.show();
    }
}
