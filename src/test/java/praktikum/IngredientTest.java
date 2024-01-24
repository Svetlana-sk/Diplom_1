package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", 90},
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88},
                {IngredientType.FILLING, "Плоды Фалленианского дерева", 874},
                {IngredientType.FILLING, "Кристаллы марсианских альфа-сахаридов", 762},
        };
    }

    // Проверяем, что возвращается ожидаемый тип: начинка или соус
    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    // Проверяем, что возвращается ожидаемое название
    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    // Проверяем, что возвращается ожидаемая цена
    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }
}