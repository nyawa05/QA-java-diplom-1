import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import services.IngredientGenerator;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void burgerGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        assertEquals("Возвращается неверное значение стоимости бупгера", 300f, burger.getPrice(),0);
    }

    @Test
    public void burgerGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Название булочки");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredient.getName()).thenReturn("Название ингредиента");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        String receipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n"
                , "Название булочки", "filling", "Название ингредиента", "Название булочки", 300f);
        assertEquals("Возвращается неверное значение чека", receipt, burger.getReceipt());
    }

    @Test
    public void burgerMoveIngredient() {
        Burger burger = new Burger();
        burgerAddIngredients(burger, 6);
        Ingredient ingredient1 = burger.ingredients.get(2);
        Ingredient ingredient2 = burger.ingredients.get(4);
        Ingredient ingredient3 = burger.ingredients.get(0);
        burger.moveIngredient(2, 4);
        assertEquals("Третий ингридиент из списка должен стать пятым элементом", ingredient1, burger.ingredients.get(4));
        assertEquals("Пятый ингредиент из списка должен стать четвертым элементом", ingredient2, burger.ingredients.get(3));
        burger.moveIngredient(3,0);
        assertEquals("Пятый ингридиент из списка должен стать первым элементом", ingredient2, burger.ingredients.get(0));
        assertEquals("Первый ингридиент из списка должен стать вторым элементом", ingredient3, burger.ingredients.get(1));
        assertEquals("Размер списка ингредиентов не должен измениться", 6, burger.ingredients.size());
    }

    @Test
    public void burgerAddIngredient() {
        Burger burger = new Burger();
        int size = RandomUtils.nextInt(0,11);
        burgerAddIngredients(burger, size);
        String name = IngredientGenerator.randomName();
        float price = IngredientGenerator.randomPrice();
        IngredientType type = IngredientGenerator.randomType();
        Ingredient ingredient1 = new Ingredient(type, name, price);
        burger.addIngredient(ingredient1);
        assertEquals("Размер списка ингредиентов должен увеличиться на 1", size+1, burger.ingredients.size());
        assertEquals("Возвращается неверное значение ингредиента", ingredient1, burger.ingredients.get(size));
        }

    @Test
    public void burgerRemoveIngredient() {
        Burger burger = new Burger();
        int size = RandomUtils.nextInt(1,11);
        burgerAddIngredients(burger, size);
        int index = RandomUtils.nextInt(0, size);
        Ingredient ingredient1 = burger.ingredients.get(index);
        burger.removeIngredient(index);
        assertEquals("Размер списка ингредиентов должен уменьшиться на 1", size-1, burger.ingredients.size());
        assertFalse("В списке ингредиентов не должно быть удаленного ингредиента", burger.ingredients.contains(ingredient1));
    }

    public void burgerAddIngredients(Burger burger,int size) {
        for (int i = 0; i < size; i++) {
            burger.addIngredient(IngredientGenerator.randomIngredient());
        }
    }

}
