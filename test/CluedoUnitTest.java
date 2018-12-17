import Model.Cluedo;
import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;


public class CluedoUnitTest {
    @Test
    public void testLancerMain(){
        Cluedo cluedo = new Cluedo(new Color[]{Color.BLUE, Color.GREEN}, new String[]{"bleu", "vert"});
        Assert.assertTrue(cluedo.getJoueurCourant() == 0);
        cluedo.joueurSuivant();
        Assert.assertTrue(cluedo.getJoueurCourant() == 1);
    }
}
