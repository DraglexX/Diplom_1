package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceParamTest {

    @Mock private Bun mockBun;
    @Mock private Ingredient mockIng1;
    @Mock private Ingredient mockIng2;

    private final float bunPrice;
    private final float ing1Price;
    private final float ing2Price;
    private final float expectedTotal;

    public BurgerPriceParamTest(float bunPrice, float ing1Price, float ing2Price, float expectedTotal) {
        this.bunPrice      = bunPrice;
        this.ing1Price     = ing1Price;
        this.ing2Price     = ing2Price;
        this.expectedTotal = expectedTotal;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "{index}: bun={0}, ing1={1}, ing2={2} -> total={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 50f,   10f,   20f,  130f },
                { 100f,  25.5f, 25.5f, 251f },
                { 30.5f, 50f,   40f,  151f }
        });
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIng1.getPrice()).thenReturn(ing1Price);
        when(mockIng2.getPrice()).thenReturn(ing2Price);

        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIng1);
        burger.addIngredient(mockIng2);

        assertEquals(expectedTotal, burger.getPrice(), 0.001f);
    }
}
