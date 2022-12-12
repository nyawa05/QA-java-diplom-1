import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;


    @Test
    public void burgerGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(100f);
        assertEquals("Возвращается неверное значение стоимости бупгера", 300f, burger.getPrice(),0);
    }

    @Test
    public void burgerGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getName()).thenReturn("Название булочки");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredient1.getName()).thenReturn("Название ингредиента");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(100f);
        String receipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n"
                , "Название булочки", "filling", "Название ингредиента", "Название булочки", 300f);
        assertEquals("Возвращается неверное значение чека", receipt, burger.getReceipt());
    }

    @Test
    public void burgerMoveIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        int expectedSize = burger.ingredients.size();
        burger.moveIngredient(0, 2);
        assertEquals("Первый ингридиент из списка должен стать третьим элементом", ingredient1, burger.ingredients.get(2));
        assertEquals("Второй ингредиент из списка должен стать первым элементом", ingredient2, burger.ingredients.get(0));
        assertEquals("Третий ингридиент из списка должен стать вторым элементом", ingredient3, burger.ingredients.get(1));
        assertEquals("Размер списка ингредиентов не должен измениться", expectedSize, burger.ingredients.size());
    }

    @Test
    public void burgerAddIngredient() {
        Burger burger = new Burger();
        int size = burger.ingredients.size();
        burger.ingredients.add(ingredient1);
        assertEquals("Размер списка ингредиентов должен увеличиться на 1", size+1, burger.ingredients.size());
        assertEquals("Возвращается неверное значение ингредиента", ingredient1, burger.ingredients.get(size));
        }

    @Test
    public void burgerRemoveIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        int size = burger.ingredients.size();
        burger.removeIngredient(1);
        assertEquals("Размер списка ингредиентов должен уменьшиться на 1", size-1, burger.ingredients.size());
        assertFalse("В списке ингредиентов не должно быть удаленного ингредиента", burger.ingredients.contains(ingredient2));
    }

}
