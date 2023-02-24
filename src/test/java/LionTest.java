import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensUseFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeMaleReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("Самец doesHaveMane() возвращает true", lion.doesHaveMane());
    }

    @Test
    public void doesHaveManefemailReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse("Самка doesHaveMane() возвращает false", lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void doesHaveManeOtherSexReturnsTrow() throws Exception {
        Lion lion = new Lion("ERROR", feline);
    }

    @Test
    public void getFoodUsePredatorFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
