package praktikum;

import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testValuesLength() {
        IngredientType[] values = IngredientType.values();
        assertEquals(
                "IngredientType.values().length должно быть 2",
                2, values.length
        );
    }

    @Test
    public void testValuesOrderAndContent() {
        IngredientType[] values = IngredientType.values();
        assertEquals("Первое значение должно быть SAUCE",   IngredientType.SAUCE,   values[0]);
        assertEquals("Второе значение должно быть FILLING", IngredientType.FILLING, values[1]);
    }
}
