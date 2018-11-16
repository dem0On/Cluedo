package Model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Carte> main;

    public Main() {
        this.main = new ArrayList<>();
    }

    public void ajouter(Carte carte){
        main.add(carte);
    }

    public void print(){
        System.out.println("Main:");
        for (Carte carte : main) {
            System.out.println("- " + carte.print());
        }
    }

    public List<Carte> getMain() {
        return main;
    }
}