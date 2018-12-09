package Model.Joueurs;

import java.util.ArrayList;
import java.util.List;

public class Note {
    List<CheckNote> listNote;

    public Note() {
        listNote = new ArrayList<>();
    }

    public void addNote(CheckNote checkNote){
        listNote.add(checkNote);
    }

    public List<CheckNote> getListNote() {
        return listNote;
    }
}
