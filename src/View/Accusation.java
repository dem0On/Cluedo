package View;
import Model.Cluedo;
import Model.InitCartes;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Accusation extends Parent  {
    private Cluedo cluedo;
    private InitCartes initCarte;
    private Canvas canvas;
    private Stage primaryStage;
    private Stage popup;
    private ArrayList<String> Hypothese;

    public Accusation(Cluedo cluedo, Stage primaryStage){
        popup = new Stage();
        Hypothese = new ArrayList<>();
        this.cluedo = cluedo;
        this.primaryStage = primaryStage;
        canvas = new Canvas(1100, 500);
    }

    public void afficherPersonnages() {
        Accusation accusation = new Accusation( cluedo, primaryStage);
        BorderPane borderPanePop = new BorderPane();
        GridPane gridPane = new GridPane ();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        VBox vBox2 = new VBox();
        vBox2.getChildren().add(canvas);

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
            accusation.afficherArme();
            Hypothese.add("Blanc");
            popup.close();
        });
        buttonBleu.setOnAction(value ->  {
            System.out.println("Bleu");
            Hypothese.add("Bleu");
            accusation.afficherArme();
            popup.close();
        });
        buttonJaune.setOnAction(value ->  {
            System.out.println("Jaune");
            Hypothese.add("Jaune");
            accusation.afficherArme();
            popup.close();

        });
        buttonRouge.setOnAction(value ->  {
            System.out.println("Rouge");
            Hypothese.add("Rouge");
            accusation.afficherArme();
            popup.close();

        });
        buttonVert.setOnAction(value ->  {
            System.out.println("Vert");
            Hypothese.add("Vert");
            accusation.afficherArme();
            popup.close();
        });
        buttonViolet.setOnAction(value ->  {
            System.out.println("Violet");
            Hypothese.add("Violet");
            accusation.afficherArme();
            popup.close();

        });

        borderPanePop.setTop(gridPane);
        Scene scene = new Scene(borderPanePop);
        popup.setScene(scene);
        popup.show();

    }

    public void afficherArme(){
        Accusation accusation = new Accusation(cluedo,primaryStage);
        BorderPane borderPanePopARME = new BorderPane();
        GridPane gridPaneARME = new GridPane ();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        VBox vBox3 = new VBox();
        vBox3.getChildren().add(canvas);

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
        gridPaneARME.add (buttonchandelier, 0, 0, 1, 1);
        gridPaneARME.add (buttonpistolet, 1, 0, 1, 1);
        gridPaneARME.add (buttoncorde, 2, 0, 1, 1);
        gridPaneARME.add (buttonCouteau, 3, 0, 1, 1);
        gridPaneARME.add (buttonCle, 4, 0, 1, 1);
        gridPaneARME.add (buttonBaton, 5, 0, 1, 1);

        buttonchandelier.setOnAction(value ->  {
            System.out.println("chandelier");
            Hypothese.add("chandelier");
            accusation.afficherPieces();
            popup.close();
        });
        buttonpistolet.setOnAction(value ->  {
            System.out.println("pistolet");
            Hypothese.add("pistolet");
            accusation.afficherPieces();
            popup.close();
        });
        buttoncorde.setOnAction(value ->  {
            System.out.println("corde");
            Hypothese.add("corde");
            accusation.afficherPieces();
            popup.close();
        });
        buttonCouteau.setOnAction(value ->  {
            System.out.println("couteau");
            Hypothese.add("couteau");
            accusation.afficherPieces();
            popup.close();
        });
        buttonCle.setOnAction(value ->  {
            System.out.println("cle");
            Hypothese.add("cle");
            accusation.afficherPieces();
            popup.close();
        });
        buttonBaton.setOnAction(value ->  {
            System.out.println("Baton");
            Hypothese.add("Baton");
            accusation.afficherPieces();
            popup.close();
        });

        borderPanePopARME.setTop(gridPaneARME);
        Scene sceneArme = new Scene(borderPanePopARME);
        popup.setScene(sceneArme);
        popup.show();

    }

    public void afficherPieces(){
        Accusation accusation = new Accusation(cluedo,primaryStage);

        BorderPane borderPanePopPiece = new BorderPane();
        GridPane gridPanePiece = new GridPane ();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(primaryStage);
        VBox vBox3 = new VBox();
        vBox3.getChildren().add(canvas);

        Image salle_a_manger = new Image("Image/Piece/diningroom.jpg");
        Image cuisine = new Image("Image/Piece/kitchen.jpg");
        Image salon = new Image("Image/Piece/lounge.jpg");
        Image Salle_de_Bal = new Image("Image/Piece/ballroom.jpg");
        Image Salle_de_Billard = new Image("Image/Piece/billiardroom.jpg");
        Image Conservatoire = new Image("Image/Piece/conservatory.jpg");
        Image Hall = new Image("Image/Piece/hall.jpg");
        Image Librairie = new Image("Image/Piece/library.jpg");
        Image Bureau = new Image("Image/Piece/study.jpg");
        Button buttonsalle_a_manger = new Button();
        Button buttoncuisine = new Button();
        Button buttonsalon= new Button();
        Button buttonSalle_de_Bal = new Button();
        Button buttonSalle_de_Billard = new Button();
        Button buttonConservatoire = new Button();
        Button buttonHall = new Button();
        Button buttonLibrairie = new Button();
        Button buttonBureau = new Button();

        buttonsalle_a_manger.setGraphic(new ImageView(salle_a_manger));
        buttoncuisine.setGraphic(new ImageView(cuisine));
        buttonsalon.setGraphic(new ImageView(salon));
        buttonSalle_de_Bal.setGraphic(new ImageView(Salle_de_Bal));
        buttonSalle_de_Billard.setGraphic(new ImageView(Salle_de_Billard));
        buttonConservatoire.setGraphic(new ImageView(Conservatoire));
        buttonHall.setGraphic(new ImageView(Hall));
        buttonLibrairie.setGraphic(new ImageView(Librairie));
        buttonBureau.setGraphic(new ImageView(Bureau));

        gridPanePiece.add (buttonsalle_a_manger, 0, 0, 1, 1);
        gridPanePiece.add (buttoncuisine, 1, 0, 1, 1);
        gridPanePiece.add (buttonsalon, 2, 0, 1, 1);
        gridPanePiece.add (buttonSalle_de_Bal, 3, 0, 1, 1);
        gridPanePiece.add (buttonSalle_de_Billard, 4, 0, 1, 1);
        gridPanePiece.add (buttonConservatoire, 5, 0, 1, 1);
        gridPanePiece.add (buttonHall, 6, 0, 1, 1);
        gridPanePiece.add (buttonLibrairie, 7, 0, 1, 1);
        gridPanePiece.add (buttonBureau, 8, 0, 1, 1);

        buttonsalle_a_manger.setOnAction(value ->  {
            System.out.println("salle a manger");
            Hypothese.add("salle_a_manger");
            popup.close();
        });
        buttoncuisine.setOnAction(value ->  {
            System.out.println("Cuisine");
            Hypothese.add("Cuisine");
        });
        buttonsalon.setOnAction(value ->  {
            System.out.println("Salon");
            Hypothese.add("Salon");
            popup.close();
        });
        buttonSalle_de_Bal.setOnAction(value ->  {
            System.out.println("Salle de Bal");
            Hypothese.add("Salle_de_Bal");
            popup.close();
        });
        buttonSalle_de_Billard.setOnAction(value ->  {
            System.out.println("Salle de Billard");
            Hypothese.add("Salle_de_Billard");
            popup.close();
        });
        buttonConservatoire.setOnAction(value ->  {
            System.out.println("Conservatoire");
            Hypothese.add("Conservatoire");
            popup.close();
        });
        buttonHall.setOnAction(value ->  {
            System.out.println("Hall");
            Hypothese.add("Hall");
            popup.close();
        });
        buttonLibrairie.setOnAction(value ->  {
            System.out.println("Librairie");
            Hypothese.add("Librairie");
            popup.close();
        });
        buttonBureau.setOnAction(value ->  {
            System.out.println("Bureau");
            Hypothese.add("Bureau");
            popup.close();
        });

        borderPanePopPiece.setTop(gridPanePiece);
        Scene scenePiece = new Scene(borderPanePopPiece);
        popup.setScene(scenePiece);
        popup.show();


    }
    public ArrayList<String> getHypothese() {
        return Hypothese;
    }



    public void afficherArmes(InitCartes pers) {
        canvas.getGraphicsContext2D().restore();
        for (int i = 0; i < pers.getPaquetArme().size(); i++) {
            canvas.getGraphicsContext2D().drawImage(pers.getPaquetArme().getCarte(i).getImageCarte(), 20 + i * 160, 50);
        }
        popup.show();
    }
    public void afficherPieces(InitCartes pers) {
        canvas.getGraphicsContext2D().restore();
        for (int i = 0; i < pers.getPaquetLieu().size(); i++) {
            canvas.getGraphicsContext2D().drawImage(pers.getPaquetLieu().getCarte(i).getImageCarte(), 20 + i * 160, 50);
        }
        popup.show();
    }

}
