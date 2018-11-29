package View;

public class PopUp {

    private PopUpMain popUpMain;
    private Accusation accusation;
    private NoteView noteView;

    public PopUp(PopUpMain popUpMain, Accusation accusation, NoteView noteView) {
        this.popUpMain = popUpMain;
        this.accusation = accusation;
        this.noteView = noteView;
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
}
