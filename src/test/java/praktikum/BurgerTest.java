package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static praktikum.IngredientType.FILLING;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    // Проверяем, что булочка установлена корректно
    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    // Проверяем, что размер списка ингредиентов увеличился
    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    // Проверяем, что размер списка ингредиентов уменьшился
    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    // Проверяем, что ингредиенты перемещены правильно
    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Ingredient firstIngredient = Mockito.mock(Ingredient.class);
        Ingredient secondIngredient = Mockito.mock(Ingredient.class);
        Ingredient thirdIngredient = Mockito.mock(Ingredient.class);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(new ArrayList<>(Arrays.asList(secondIngredient, firstIngredient, thirdIngredient)), burger.ingredients);
    }

    // Проверяем, что общая стоимость вычислена правильно
    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient firstIngredient = Mockito.mock(Ingredient.class);
        burger.ingredients.add(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(20f);
        float actual = burger.getPrice();
        assertThat(actual, equalTo(30f));
    }

    // Проверяем чек с информацией о бургере
    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient = Mockito.mock(Ingredient.class);

        when(bun.getName()).thenReturn("Краторная булка N-200i");
        when(bun.getPrice()).thenReturn(100F);
        when(ingredient.getType()).thenReturn(FILLING);
        when(ingredient.getName()).thenReturn("Говяжий метеорит (отбивная)");
        when(ingredient.getPrice()).thenReturn(500F);

        burger.ingredients.add(ingredient);

        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expected, burger.getReceipt());
    }
}
