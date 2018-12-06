package View;

public class PopUp {

    private PopUpMain popUpMain;
    private Accusation accusation;
    private NoteView noteView;
    private DebutTour debutTour;

    public PopUp(PopUpMain popUpMain, Accusation accusation, NoteView noteView, DebutTour debutTour) {
        this.popUpMain = popUpMain;
        this.accusation = accusation;
        this.noteView = noteView;
        this.debutTour = debutTour;
    }

    public PopUpMain getPopUpMain() {
        return popUpMain;
    }

    public Accusation getAccusation() {
        return accusation;
    }

    public NoteView getNoteView() {
        return noteView;
    }

    public DebutTour getDebutTour() {
        return debutTour;
    }
}
