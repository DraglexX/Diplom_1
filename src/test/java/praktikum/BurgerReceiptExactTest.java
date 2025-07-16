package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptExactTest {

    @Mock private Bun        mockBun;
    @Mock private Ingredient mockSauce;
    @Mock private Ingredient mockFilling;

    @Test
    public void testGetReceiptExact() {
        when(mockBun.getName()).thenReturn("С кунжутом");
        when(mockBun.getPrice()).thenReturn(50f);

        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("Кисло-сладкий");
        when(mockSauce.getPrice()).thenReturn(45f);

        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockFilling.getName()).thenReturn("Котлета");
        when(mockFilling.getPrice()).thenReturn(100f);

        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        String expected = String.format(
                "(==== С кунжутом ====)%n" +
                        "= sauce Кисло-сладкий =%n" +
                        "= filling Котлета =%n" +
                        "(==== С кунжутом ====)%n%n" +
                        "Price: 245,000000%n"
        );

        assertEquals(
                "Строка чека должна совпадать полностью и использовать запятую в качестве разделителя",
                expected, burger.getReceipt()
        );
    }
}
