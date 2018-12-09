package View;

import Model.Cluedo;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LancerDes {
    private Stage popup;
    private Cluedo cluedo;
    private Stage primaryStage;
    private HBox hBox;

    public LancerDes(Cluedo cluedo, Stage primaryStage) {
        popup = new Stage();
        this.cluedo = cluedo;
        this.primaryStage = primaryStage;
        initPopup();
    }

    private void initPopup() {
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        hBox = new HBox();
        Scene scene = new Scene(hBox);
        popup.setScene(scene);
    }

    public void afficherLancer(int des1, int des2){
        hBox.getChildren().clear();
        ImageView imageD1 = new ImageView(new Image("Image/Des/Face"+des1+".jpeg"));
        imageD1.setFitWidth(100);
        imageD1.setPreserveRatio(true);
        hBox.getChildren().add(imageD1);
        ImageView imageD2 = new ImageView(new Image("Image/Des/Face"+des2+".jpeg"));
        imageD2.setFitWidth(100);
        imageD2.setPreserveRatio(true);
        hBox.getChildren().add(imageD2);
    }

    public void show() {
        popup.show();
    }
}
