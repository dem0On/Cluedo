package Controller;


import Model.Cluedo;
import View.Fenetre;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyController implements EventHandler<KeyEvent> {
    // pour remove on utilisera canvas.getContectGraphic2D().clearRect(double x, double y, double w, double h)
    private Cluedo cluedo;
    private Fenetre fenetre;

    public KeyController(Cluedo cluedo, Fenetre fenetre) {
        this.cluedo = cluedo;
        this.fenetre = fenetre;
    }

    @Override
    public void handle(KeyEvent event) {
        fenetre.getCanvas().getGraphicsContext2D().setFill(cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getCouleur());
        if(event.getCode() == KeyCode.Z) {
            System.out.println("fleche du haut");
            cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(0, -1);
        }
        else if(event.getCode() == KeyCode.S) {
            System.out.println("fleche du bas");
            cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(0, 1);
        }
        else if(event.getCode() == KeyCode.Q) {
            System.out.println("fleche de gauche");
            cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(-1, 0);
        }
        else if(event.getCode() == KeyCode.D) {
            System.out.println("fleche de droite");
            cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(1, 0);
        }
        fenetre.actualiser();
    }
}
