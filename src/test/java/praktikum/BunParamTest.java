package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunParamTest {

    @Parameterized.Parameters(name = "{index}: name=\"{0}\", price={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { "black bun", 100.0f },
                { "white bun", 200.0f },
                { "",           0.0f },
                { "stale bun", -10.5f },
                { null,         50.0f }
        });
    }

    private final String name;
    private final float  price;

    public BunParamTest(String name, float price) {
        this.name  = name;
        this.price = price;
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(name, price);
        assertEquals(
                "getName() должен возвращать имя, переданное в конструктор",
                name, bun.getName()
        );
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(
                "getPrice() должен возвращать цену, переданную в конструктор",
                price, bun.getPrice(), 0.001f
        );
    }
}
