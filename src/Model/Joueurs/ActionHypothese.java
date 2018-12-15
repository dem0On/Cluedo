package Model.Joueurs;

import Model.Cartes.Carte;

public class ActionHypothese extends Actions {

    public ActionHypothese(Carte cartePersonnage, Carte carteArme, Carte cartePiece, Main joueurQuiAFait) {
        super(cartePersonnage, carteArme, cartePiece, joueurQuiAFait);
    }

    public boolean isHypothese(){
        return true;
    }
}
