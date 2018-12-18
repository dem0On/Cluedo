package View;

import Model.Joueurs.CheckNote;
import Model.Cluedo;
import Model.Joueurs.Main;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NoteView {
    private Stage popup;
    private Cluedo cluedo;
    private Stage primaryStage;
    private VBox vBox1;

    public NoteView(Cluedo cluedo, Stage primaryStage) {
        popup = new Stage();
        this.cluedo = cluedo;
        this.primaryStage = primaryStage;
        initPopup();
    }

    private void initPopup() {
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        vBox1 = new VBox();
        Scene scene = new Scene(vBox1);
        popup.setScene(scene);
    }
    
    public void afficherNote(Main main){
        vBox1.getChildren().clear();
        for (int i = 0; i < main.getNote().getListNote().size(); i++) {
            CheckNote checkNote = cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getNote().getListNote().get(i);
            CheckBox checkBox = new CheckBox(checkNote.getNom());
            if(checkNote.isCheck()) checkBox.setSelected(true);
            checkBox.setOnAction(value ->  {
                if(checkNote.isCheck()) checkNote.deCheck();
                else checkNote.check();
            });
            vBox1.getChildren().add(checkBox);
        }
        popup.show();
    }
}
