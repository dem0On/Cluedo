package View;

import Model.Cluedo;
import Model.Main;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class Fenetre extends Parent {
    private Cluedo cluedo;
    private GraphicsContext graphicsContext;

    public Fenetre( Cluedo cluedo){
        this.cluedo = cluedo;
        Canvas canvas = new Canvas(500, 200);
        graphicsContext = canvas.getGraphicsContext2D();
        afficherMain(cluedo.getListJoueurs().get(0));
        this.getChildren().add(canvas);
    }

    public void afficherMain(Main main){
        for (int i = 0; i < main.getMain().size(); i++) {
            graphicsContext.drawImage(main.getMain().get(i).getImageCarte(), 20+i*100, 50);
        }
    }
}
