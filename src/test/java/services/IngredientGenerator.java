package services;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientGenerator {
    static int targetStringLength = 6;
    static int targetIngredientTypeLength = IngredientType.values().length;

    public static String randomName() {
        return RandomStringUtils.randomAlphabetic(targetStringLength);
    }
    public static float randomPrice() { return RandomUtils.nextFloat(); }

    public static IngredientType randomType() { return IngredientType.values()[RandomUtils.nextInt(0,targetIngredientTypeLength)]; }
    public static Ingredient randomIngredient() { return new Ingredient(randomType(), randomName(), randomPrice()); }
}
