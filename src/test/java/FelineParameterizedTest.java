import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private final int kittens;
    private final int expectedKittensCount;

    public FelineParameterizedTest(int kittens, int expectedKittensCount) {
        this.kittens = kittens;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {10, 10},
        };
    }

    @Test
    public void getKittensReturnKittensUseTestData() {
        Feline feline = new Feline();
        Assert.assertEquals(expectedKittensCount, feline.getKittens(kittens));

    }
}
