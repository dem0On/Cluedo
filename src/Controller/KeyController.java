package Controller;


import Model.Cluedo;
import Model.Plateau.TypeCase;
import View.Fenetre;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyController implements EventHandler<KeyEvent> {
    private Cluedo cluedo;
    private Fenetre fenetre;

    public KeyController(Cluedo cluedo, Fenetre fenetre) {
        this.cluedo = cluedo;
        this.fenetre = fenetre;
    }

    @Override
    public void handle(KeyEvent event) {
        fenetre.getCanvas().getGraphicsContext2D().setFill(cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getCouleur());
        int x = (int) cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().getX();
        int y = (int) cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().getY();
        if(!cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().isDeplacement()) {
            if (event.getCode() == KeyCode.Z) {
                if (isDeplacementHaut(x, y)) {
                    cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(0, -1);
                    cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().deplacement();
                    mettreHypothese();
                } else fenetre.afficheErreur("vous etez bloquer", "déplacement");
            } else if (event.getCode() == KeyCode.S) {
                if (isDeplacementBas(x, y)) {
                    cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(0, 1);
                    cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().deplacement();
                    mettreHypothese();
                } else fenetre.afficheErreur("vous etez bloquer", "déplacement");
            } else if (event.getCode() == KeyCode.Q) {
                if (isDeplacementGauche(x, y)) {
                    cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(-1, 0);
                    cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().deplacement();
                    mettreHypothese();
                } else fenetre.afficheErreur("vous etez bloquer", "déplacement");
            } else if (event.getCode() == KeyCode.D) {
                if (isDeplacementDroite(x, y)) {
                    cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(1, 0);
                    cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().deplacement();
                    mettreHypothese();
                } else fenetre.afficheErreur("vous etez bloquer", "déplacement");
            }
            fenetre.actualiserPlateau();
            fenetre.actualiserInterface();
        }
        else fenetre.afficheErreur("vous n'avez plus de déplacement", "déplacement");
    }

    private void mettreHypothese(){
        int x = (int) cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().getX();
        int y = (int) cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().getY();
        if(cluedo.getPlateau()[x][y] != TypeCase.Couloir) {
            cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().setNbfDeplacement(0);
            fenetre.mettreHypothese();
        }
    }

    private boolean isDeplacementHaut(int x, int y){
        if(y==0) return false;
        if(cluedo.getPlateau()[x][y-1] != TypeCase.PorteVerticale) {
            if(cluedo.getPlateau()[x][y-1] != TypeCase.Couloir) return false;
        }
        if(cluedo.getPlateau()[x][y-1] == TypeCase.PorteVerticale) cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(0, -1);
        return true;
    }

    private boolean isDeplacementBas(int x, int y){
        if(y==24) return false;
        if(cluedo.getPlateau()[x][y+1] != TypeCase.PorteVerticale) {
            if(cluedo.getPlateau()[x][y+1] != TypeCase.Couloir) return false;
        }
        if(cluedo.getPlateau()[x][y+1] == TypeCase.PorteVerticale) cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(0, 1);
        return true;
    }

    private boolean isDeplacementGauche(int x, int y){
        if(x==0) return false;
        if(cluedo.getPlateau()[x-1][y] != TypeCase.PorteHorizontal) {
            if(cluedo.getPlateau()[x-1][y] != TypeCase.Couloir) return false;
        }
        if(cluedo.getPlateau()[x-1][y] == TypeCase.PorteHorizontal) cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(-1, 0);
        return true;
    }

    private boolean isDeplacementDroite(int x, int y){
        if(x==23) return false;
        if(cluedo.getPlateau()[x+1][y] != TypeCase.PorteHorizontal){
            if(cluedo.getPlateau()[x+1][y] != TypeCase.Couloir) return false;
        }
        if(cluedo.getPlateau()[x+1][y] == TypeCase.PorteHorizontal) cluedo.getListJoueurs().get(cluedo.getJoueurCourant()).getPion().getPoint().translate(1, 0);
        return true;
    }
}
