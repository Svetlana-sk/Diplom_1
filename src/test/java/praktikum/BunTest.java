package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
                {null, 177},
                {"", 300},
                {"!@#$%^&*()", 0},
                {"bun bun", 100f}
        });
    }

    // Проверяем, что название и цена устанавливаются правильно
    @Test
    public void testBunProperties() {
        bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(),0);
    }
}