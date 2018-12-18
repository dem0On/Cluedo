import Model.Cluedo;
import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;


public class CluedoUnitTest {
    @Test
    public void testJoueurSuivantSansElliminer(){
        Cluedo cluedo = new Cluedo(new Color[]{Color.BLUE, Color.GREEN}, new String[]{"bleu", "vert"});
        Assert.assertTrue(cluedo.getJoueurCourant() == 0);
        cluedo.joueurSuivant();
        Assert.assertTrue(cluedo.getJoueurCourant() == 1);
    }

    @Test
    public void testJoueurSuivantAvecElliminer(){
        Cluedo cluedo = new Cluedo(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE}, new String[]{"bleu", "vert", "blanc"});
        cluedo.addElliminer();
        cluedo.joueurSuivant();
        cluedo.joueurSuivant();
        cluedo.joueurSuivant();
        Assert.assertFalse(cluedo.getJoueurCourant() == 0);
        Assert.assertTrue(cluedo.getJoueurCourant() == 1);
    }

    @Test
    public void testJoueurSuivantFin(){
        Cluedo cluedo = new Cluedo(new Color[]{Color.BLUE, Color.GREEN}, new String[]{"bleu", "vert"});
        cluedo.addElliminer();
        cluedo.joueurSuivant();
        Assert.assertFalse(cluedo.isEnd());
        cluedo.addElliminer();
        cluedo.joueurSuivant();
        Assert.assertTrue(cluedo.isEnd());
    }
}
