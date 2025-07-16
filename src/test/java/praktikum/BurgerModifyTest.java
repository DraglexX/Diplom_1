package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BurgerModifyTest {

    private Burger burger;
    private Ingredient a, b, c;

    @Before
    public void setUp() {
        a = new Ingredient(IngredientType.FILLING, "A", 1f);
        b = new Ingredient(IngredientType.FILLING, "B", 2f);
        c = new Ingredient(IngredientType.FILLING, "C", 3f);

        burger = new Burger();
        burger.setBuns(new Bun("bun", 10f));
        burger.addIngredient(a);
        burger.addIngredient(b);
        burger.addIngredient(c);
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(1);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals("После remove размер списка должен уменьшиться на 1", 2, ingredients.size());
        assertEquals("Первый элемент должен остаться A", a, ingredients.get(0));
        assertEquals("Второй элемент должен стать C", c, ingredients.get(1));
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(2, 0);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals("После move первый элемент должен быть C", c, ingredients.get(0));
        assertEquals("После move второй элемент должен быть A", a, ingredients.get(1));
        assertEquals("После move третий элемент должен быть B", b, ingredients.get(2));
    }
}
