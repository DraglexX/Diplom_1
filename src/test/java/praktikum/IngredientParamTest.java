package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    @Parameterized.Parameters(name = "{index}: type={0}, name=\"{1}\", price={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { IngredientType.SAUCE,   "hot sauce", 100.0f },
                { IngredientType.SAUCE,   "",          0.0f },
                { IngredientType.FILLING, "cutlet",   150.5f },
                { null,                   "mystery",   -5.0f },
                { IngredientType.FILLING, null,        20.0f }
        });
    }

    private final IngredientType type;
    private final String         name;
    private final float          price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type  = type;
        this.name  = name;
        this.price = price;
    }

    @Test
    public void testGetType() {
        Ingredient ing = new Ingredient(type, name, price);
        assertEquals(
                "getType() должен возвращать тип, переданный в конструктор",
                type, ing.getType()
        );
    }

    @Test
    public void testGetName() {
        Ingredient ing = new Ingredient(type, name, price);
        assertEquals(
                "getName() должен возвращать имя, переданное в конструктор",
                name, ing.getName()
        );
    }

    @Test
    public void testGetPrice() {
        Ingredient ing = new Ingredient(type, name, price);
        assertEquals(
                "getPrice() должен возвращать цену, переданную в конструктор",
                price, ing.getPrice(), 0.001f
        );
    }
}
