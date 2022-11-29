import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import services.BunGenerator;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    final String name;
    final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {BunGenerator.randomName(), BunGenerator.randomPrice()},
                {BunGenerator.randomName(), BunGenerator.randomPrice()},
                {BunGenerator.randomName(), BunGenerator.randomPrice()},
                {BunGenerator.randomName(), BunGenerator.randomPrice()},
                {BunGenerator.randomName(), BunGenerator.randomPrice()},
        };
    }

    @Test
    public void bunGetName() {
        Bun bun = new Bun(name, price);
        assertEquals("Возвращается неверное значение названия булочки", name, bun.getName());
    }
    @Test
    public void bunGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Возвращается неверное значение стоимости булочки", price, bun.getPrice(),0);
    }
}
