import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Locale;
public class ShoppingInstanceTest {
    @Test
    public void testCalculatePrice() {
        ShoppingLocalized.ShoppingInstance shoppingInstance = new ShoppingLocalized.ShoppingInstance(new Locale("en", "US"));
        assertEquals(10f, shoppingInstance.CalculatePrice(4, 2.5f), 0.001);
    }
    @Test
    public void testCalculateCart() {
        ShoppingLocalized.ShoppingInstance shoppingInstance = new ShoppingLocalized.ShoppingInstance(new Locale("en", "US"));
        assertEquals(20.05f, shoppingInstance.CalculatePrice(2, 5.02f) + shoppingInstance.CalculatePrice(1, 10.01f), 0.001);
    }
}