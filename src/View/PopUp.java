package View;

public class PopUp {

    private PopUpMain popUpMain;
    private Accusation accusation;
    private NoteView noteView;
    private DebutTour debutTour;
    private Hypothese hypothese;
    private LancerDes lancerDes;

    public PopUp(PopUpMain popUpMain, Accusation accusation, NoteView noteView, DebutTour debutTour, Hypothese hypothese, LancerDes lancerDes) {
        this.popUpMain = popUpMain;
        this.accusation = accusation;
        this.noteView = noteView;
        this.debutTour = debutTour;
        this.hypothese = hypothese;
        this.lancerDes = lancerDes;
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

    public Hypothese getHypothese() {
        return hypothese;
    }

    public LancerDes getLancerDes() {
        return lancerDes;
    }
}
