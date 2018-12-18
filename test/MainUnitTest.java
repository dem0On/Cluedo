import Model.Joueurs.Main;
import Model.Joueurs.Note;
import Model.Joueurs.Pions;
import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.Random;

public class MainUnitTest {

    @Test
    public void testLancerMain(){
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt(6)).thenReturn(1, 5);
        Main main = new Main("", new Note(), new Pions(Color.BLUE));
        Point point = main.lancerDes(random);
        Assert.assertEquals(point.x, 1);
        Assert.assertEquals(point.y, 5);
    }
}