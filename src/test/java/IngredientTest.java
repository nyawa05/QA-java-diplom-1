import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;
import services.IngredientGenerator;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    final String name;
    final float price;
    @Mock
    IngredientType type;

    public IngredientTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientGenerator.randomName(), IngredientGenerator.randomPrice()},
                {IngredientGenerator.randomName(), IngredientGenerator.randomPrice()},
                {IngredientGenerator.randomName(), IngredientGenerator.randomPrice()},
                {IngredientGenerator.randomName(), IngredientGenerator.randomPrice()},
                {IngredientGenerator.randomName(), IngredientGenerator.randomPrice()},
        };
    }

    @Test
    public void ingredientGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Возвращается неверное значение стоимости ингредиента", price, ingredient.getPrice(), 0);
    }

    @Test
    public void ingredientGetType() {
        IngredientType ingredientType = IngredientGenerator.randomType();
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals("Возвращается неверное значение типа ингредиента", ingredientType, ingredient.getType());
    }

    @Test
    public void ingredientGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Возвращается неверное значение названия ингредиента", name, ingredient.getName());
    }

}
