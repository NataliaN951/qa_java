import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class FelineTest {

    @Test
    public void getFamilyReturnFeline() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeetUsePredator() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void getKittensWithoutArgumentsReturnKittens() {
        Feline feline = new Feline();
        feline.getKittens();
        Assert.assertEquals(1, feline.getKittens());
    }

}
