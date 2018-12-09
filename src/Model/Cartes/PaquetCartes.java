package Model.Cartes;

import java.util.*;

public class PaquetCartes {
    private ArrayList<Carte> packetCartes;

    public PaquetCartes() {
        packetCartes = new ArrayList<>();
    }

    public ArrayList<Carte> getPacketCartes() {
        return packetCartes;
    }

    public void add(PaquetCartes paquetCartes){
        for (Carte carte: paquetCartes.getPacketCartes()) {
            this.packetCartes.add(carte);
        }
    }

    public Carte tirerCarte(){
        Carte carte = packetCartes.get(0);
        packetCartes.remove(0);
        return carte;
    }
    public void add(Carte carte){
        packetCartes.add(carte);
    }
    public void melangerPacket(){
        Collections.shuffle(packetCartes);
    }

    public int size(){
        return packetCartes.size();
    }

    public Carte getCarte(int index){return packetCartes.get(index); }
}
