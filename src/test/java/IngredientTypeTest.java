import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
final String name;
final int ordinal;

    public IngredientTypeTest(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {"SAUCE", 0},
                {"FILLING", 1},
        };
    }

    @Test
    public void getIngredientTypeOrdinal() {
        IngredientType ingredientType = IngredientType.valueOf(name);
        assertEquals("Возвращается неверное значение номера элемента перечисления", ordinal, ingredientType.ordinal());
    }
}
