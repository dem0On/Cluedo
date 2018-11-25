package View;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//Pour l'instant ne sert à rien !
public class Plateau extends Parent {
    private GraphicsContext graphicsContext;

    public Plateau(){
        Image plateau = new Image("Image/plateau.jpg");
        Canvas canvas = new Canvas(500, 500);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(plateau,500,500);
        this.getChildren().add(canvas);
    }

}
