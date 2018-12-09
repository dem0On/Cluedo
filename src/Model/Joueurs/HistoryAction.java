package Model.Joueurs;

import java.util.ArrayList;
import java.util.List;

public class HistoryAction {
    private List<Actions> listActions;

    public HistoryAction() {
        listActions = new ArrayList<>();
    }

    public void add(Actions actions){
        listActions.add(actions);
    }

    public List<Actions> getListActions() {
        return listActions;
    }
}
