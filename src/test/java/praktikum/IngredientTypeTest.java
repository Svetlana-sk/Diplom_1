package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testSauceIngredientType() {
        IngredientType sauce = IngredientType.SAUCE;
        assertEquals("SAUCE", sauce.name());
    }

    @Test
    public void testFillingIngredientType() {
        IngredientType filling = IngredientType.FILLING;
        assertEquals("FILLING", filling.name());
    }
}