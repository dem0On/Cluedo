package View;

import javafx.scene.image.Image;

public class AffectCarte {

    private final Image[] LIST_IMAGE = new Image[]{
        new Image("Image/Personnage/blanc.jpg"),
        new Image("Image/Personnage/rouge.jpg"),
        new Image("Image/Personnage/jaune.jpg"),
        new Image("Image/Personnage/bleu.jpg"),
        new Image("Image/Personnage/vert.jpg"),
        new Image("Image/Personnage/violet.jpg"),
        new Image("Image/Arme/candlestick.jpg"),
        new Image("Image/Arme/revolver.jpg"),
        new Image("Image/Arme/rope.jpg"),
        new Image("Image/Arme/knife.jpg"),
        new Image("Image/Arme/pipe.jpg"),
        new Image("Image/Arme/wrench.jpg"),
        new Image("Image/Piece/diningroom.jpg"),
        new Image("Image/Piece/kitchen.jpg"),
        new Image("Image/Piece/lounge.jpg"),
        new Image("Image/Piece/ballroom.jpg"),
        new Image("Image/Piece/billiardroom.jpg"),
        new Image("Image/Piece/conservatory.jpg"),
        new Image("Image/Piece/hall.jpg"),
        new Image("Image/Piece/library.jpg"),
        new Image("Image/Piece/study.jpg")
    };

    public AffectCarte() {}

    public Image[] getLIST_IMAGE() {
        return LIST_IMAGE;
    }
}
