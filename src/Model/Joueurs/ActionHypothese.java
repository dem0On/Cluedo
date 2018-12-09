package Model.Joueurs;

import Model.Cartes.Carte;

public class ActionHypothese extends Actions {

    public ActionHypothese(Carte cartePersonnage, Carte carteArme, Carte cartePiece) {
        super(cartePersonnage, carteArme, cartePiece);
    }

    public boolean isHypothese(){
        return true;
    }
}
