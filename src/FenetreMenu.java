import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class FenetreMenu extends Parent {
    private VBox vBox;
    private int nbJoueur;
    private Appli appli;
    private Color[] tabCouleur;
    private Canvas canvas;
    private BorderPane bd;

    private String[] tabNom;
    private RadioButton[] tabRadioButton;

    public FenetreMenu(Appli appli) {

        HBox hBox = new HBox();
        bd =new BorderPane();
        this.appli = appli;
        vBox = new VBox();
        canvas = new Canvas(800, 800);
        vBox.getChildren().add(canvas);
        hBox.getChildren().add(vBox);
        initMenu();
        this.getChildren().add(hBox);
    }


    private void initMenu(){
        vBox.getChildren().clear();
        Button buttonJouer = new Button("Jouer");
        Button buttonQuitter = new Button("Quitter");
        buttonJouer.setOnAction(value ->{
            fenetreNbJoueur();
        });

        buttonQuitter.setOnAction(value ->{
            System.exit(0);
        });

        vBox.getChildren().add(buttonJouer);
        vBox.getChildren().add(buttonQuitter);
    }

    private void fenetreNbJoueur(){
        vBox.getChildren().clear();
        Label labelNbJoueur = new Label("Nombre de joueur : ");
        int[] tabNbJoueur = new int[]{3,4,5,6};
        Color[] tabColor = new Color[]{ Color.RED, Color.YELLOW, Color.PURPLE, Color.WHITE, Color.GREEN, Color.BLUE };
        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.setPromptText("Choississez le nombre de joueurs");
        for (int option : tabNbJoueur) {
            comboBox.getItems().add(option);
        }
        Button buttonSuivant = new Button("Suivant");
        buttonSuivant.setOnAction(value ->{
            tabRadioButton = new RadioButton[]{new RadioButton(), new RadioButton(), new RadioButton(), new RadioButton(), new RadioButton(), new RadioButton()};
            nbJoueur = comboBox.getSelectionModel().getSelectedItem();
            tabCouleur = new Color[nbJoueur];
            tabNom = new String[nbJoueur];
            fenetreNomColorJoueur(0, tabColor);
        });

        Button buttonRetour = new Button("Retour");
        buttonRetour.setOnAction(value ->{
            initMenu();
        });

        vBox.getChildren().add(labelNbJoueur);
        vBox.getChildren().add(comboBox);
        vBox.getChildren().add(buttonSuivant);
        vBox.getChildren().add(buttonRetour);
    }

    private void fenetreNomColorJoueur(int cptJoueur, Color[] tabColor){
        vBox.getChildren().clear();
        if(cptJoueur>=nbJoueur){
            lancerJeu();
        }

        HBox hBoxNom = new HBox();
        Label labelNomJoueur = new Label("Entrez votre nom :");
        TextField nomJoueur = new TextField();
        hBoxNom.getChildren().add(labelNomJoueur);
        hBoxNom.getChildren().add(nomJoueur);

        HBox hBoxColor = new HBox();
        ToggleGroup toggleGroup = new ToggleGroup();
        for (int i = 0; i < tabColor.length; i++) {
            Rectangle rect = new Rectangle(50, 50, tabColor[i]);
            for (int j = 0; j < tabRadioButton.length; j++) {
                if(tabRadioButton[j]!=null){
                    VBox vBoxColor = new VBox();
                    tabRadioButton[j].setToggleGroup(toggleGroup);
                    vBoxColor.getChildren().add(tabRadioButton[j]);
                    vBoxColor.getChildren().add(rect);
                    hBoxColor.getChildren().add(vBoxColor);
                }
            }
        }

        Button buttonSuivant = new Button("Suivant");
        buttonSuivant.setOnAction(value ->{
            for (int i = 0; i < tabRadioButton.length; i++) {
                if(tabRadioButton[i]!=null) {
                    if (toggleGroup.getSelectedToggle().equals(tabRadioButton[i])) {
                        tabNom[cptJoueur] = nomJoueur.getText();
                        tabCouleur[cptJoueur] = tabColor[i];
                        tabColor[i] = null;
                        tabRadioButton[i] = null;
                        fenetreNomColorJoueur(cptJoueur + 1, tabColor);
                    }
                }
            }
        });

        vBox.getChildren().addAll(hBoxNom, hBoxColor, buttonSuivant);
    }

    private void lancerJeu() {
        appli.lancerJeu(tabCouleur, tabNom);
    }
}