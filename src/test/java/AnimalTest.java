import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalKind;
    private final List listOfFoodExpected;

    public AnimalTest(String animalKind, List listOfFoodExpected) {
        this.animalKind = animalKind;
        this.listOfFoodExpected = listOfFoodExpected;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodReturnsFood() throws Exception {
        Animal animal = new Animal();
        assertEquals(listOfFoodExpected, animal.getFood(animalKind));
    }

    @Test
    public void getFamilyReturnAnimalDescription() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test(expected = Exception.class)
    public void getFoodReturnsTrow() throws Exception {
        Animal animal = new Animal();
        animal.getFood("ERROR");
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        assertEquals(expected, animal.getFood("ERROR"));
    }
}
