package View;
import Model.Cluedo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Hypothese {
    private Cluedo cluedo;
    private Stage primaryStage;
    private Stage popup;
    private GridPane gridPane;
    private ArrayList<String> hypotheses;

    public Hypothese(Cluedo cluedo, Stage primaryStage){
        popup = new Stage();
        hypotheses = new ArrayList<>();
        gridPane = new GridPane ();
        this.cluedo = cluedo;
        this.primaryStage = primaryStage;

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(gridPane);
        Scene scene = new Scene(borderPane);

        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        popup.setScene(scene);
    }

    public void afficher(){
        afficherPersonnages();
        popup.show();
    }

    void afficherPersonnages() {
        gridPane.getChildren().removeAll();

        Image imageBlanc = new Image("Image/Personnage/blanc.jpg");
        Image imageBleu= new Image("Image/Personnage/bleu.jpg");
        Image imageJaune = new Image("Image/Personnage/jaune.jpg");
        Image imageRouge = new Image("Image/Personnage/rouge.jpg");
        Image imageVert = new Image("Image/Personnage/vert.jpg");
        Image imageViolet = new Image("Image/Personnage/violet.jpg");
        Button buttonBlanc = new Button();
        Button buttonBleu = new Button();
        Button buttonJaune = new Button();
        Button buttonRouge = new Button();
        Button buttonVert = new Button();
        Button buttonViolet = new Button();
        buttonBlanc.setGraphic(new ImageView(imageBlanc));
        buttonBleu.setGraphic(new ImageView(imageBleu));
        buttonJaune.setGraphic(new ImageView(imageJaune));
        buttonRouge.setGraphic(new ImageView(imageRouge));
        buttonVert.setGraphic(new ImageView(imageVert));
        buttonViolet.setGraphic(new ImageView(imageViolet));
        gridPane.add (buttonBlanc, 0, 0, 1, 1);
        gridPane.add (buttonBleu, 1, 0, 1, 1);
        gridPane.add (buttonJaune, 2, 0, 1, 1);
        gridPane.add (buttonRouge, 3, 0, 1, 1);
        gridPane.add (buttonVert, 4, 0, 1, 1);
        gridPane.add (buttonViolet, 5, 0, 1, 1);

        buttonBlanc.setOnAction(value ->  {
            System.out.println("Blanc");
            hypotheses.add("Blanc");
            afficherArme();
        });

        buttonBleu.setOnAction(value ->  {
            System.out.println("Bleu");
            hypotheses.add("Bleu");
            afficherArme();
        });

        buttonJaune.setOnAction(value ->  {
            System.out.println("Jaune");
            hypotheses.add("Jaune");
            afficherArme();

        });

        buttonRouge.setOnAction(value ->  {
            System.out.println("Rouge");
            hypotheses.add("Rouge");
            afficherArme();

        });

        buttonVert.setOnAction(value ->  {
            System.out.println("Vert");
            hypotheses.add("Vert");
            afficherArme();
        });

        buttonViolet.setOnAction(value ->  {
            System.out.println("Violet");
            hypotheses.add("Violet");
            afficherArme();
        });
    }

    private void afficherArme(){
        gridPane.getChildren().removeAll();

        Image chandelier = new Image("Image/Arme/candlestick.jpg");
        Image pistolet = new Image("Image/Arme/revolver.jpg");
        Image corde = new Image("Image/Arme/rope.jpg");
        Image Couteau = new Image("Image/Arme/knife.jpg");
        Image Baton = new Image("Image/Arme/pipe.jpg");
        Image Cle = new Image("Image/Arme/wrench.jpg");
        Button buttonchandelier = new Button();
        Button buttonpistolet = new Button();
        Button buttoncorde = new Button();
        Button buttonCouteau = new Button();
        Button buttonCle = new Button();
        Button buttonBaton = new Button();

        buttonchandelier.setGraphic(new ImageView(chandelier));
        buttonpistolet.setGraphic(new ImageView(pistolet));
        buttoncorde.setGraphic(new ImageView(corde));
        buttonCouteau.setGraphic(new ImageView(Couteau));
        buttonCle.setGraphic(new ImageView(Cle));
        buttonBaton.setGraphic(new ImageView(Baton));
        gridPane.add (buttonchandelier, 0, 0, 1, 1);
        gridPane.add (buttonpistolet, 1, 0, 1, 1);
        gridPane.add (buttoncorde, 2, 0, 1, 1);
        gridPane.add (buttonCouteau, 3, 0, 1, 1);
        gridPane.add (buttonCle, 4, 0, 1, 1);
        gridPane.add (buttonBaton, 5, 0, 1, 1);

        buttonchandelier.setOnAction(value ->  {
            System.out.println("chandelier");
            hypotheses.add("chandelier");
            comparaison();
        });
        buttonpistolet.setOnAction(value ->  {
            System.out.println("pistolet");
            hypotheses.add("pistolet");
            comparaison();
        });
        buttoncorde.setOnAction(value ->  {
            System.out.println("corde");
            hypotheses.add("corde");
            comparaison();
        });
        buttonCouteau.setOnAction(value ->  {
            System.out.println("couteau");
            hypotheses.add("couteau");
            comparaison();
        });
        buttonCle.setOnAction(value ->  {
            System.out.println("cle");
            hypotheses.add("cle");
            comparaison();
        });
        buttonBaton.setOnAction(value ->  {
            System.out.println("Baton");
            hypotheses.add("Baton");
            comparaison();
        });
    }

    private void comparaison(){

        System.out.println(hypotheses);
        popup.close();
    }

    public ArrayList<String> getHypotheses() {
        return hypotheses;
    }

}
