package Model;

import java.util.*;

public class PaquetCartes {
    private Queue<Carte> packetCartes;

    public PaquetCartes() {
        packetCartes = new ArrayDeque<>();
    }

    public Queue<Carte> getPacketCartes() {
        return packetCartes;
    }

    public void add(PaquetCartes paquetCartes){
        for (Carte carte: paquetCartes.getPacketCartes()) {
            this.packetCartes.add(carte);
        }
    }

    public Carte tirerCarte(){
        return packetCartes.poll();
    }

    public void add(Carte carte){
        packetCartes.add(carte);
    }

    public void melangerPacket(){
        List<Carte> list = new ArrayList<>();
        for (Carte c : packetCartes) {
            list.add(c);
        }

        Collections.shuffle(list);
        packetCartes.clear();
        for (Carte c : list) {
            packetCartes.add(c);
        }
    }

    public int size(){
        return packetCartes.size();
    }
}
