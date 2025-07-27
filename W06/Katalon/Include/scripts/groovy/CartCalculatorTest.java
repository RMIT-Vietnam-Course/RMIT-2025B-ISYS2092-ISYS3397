import static org.junit.Assert.*;
import org.junit.Test;

public class CartCalculatorTest {
    @Test
    public void calculateTotal_ShouldReturnCorrectSum() {
        double[] prices = {10.0, 20.0, 5.0};
        int[] quantities = {1, 2, 3};
        assertEquals(65.0, CartCalculator.calculateTotal(prices, quantities), 0.001);
    }

    @Test
    public void emptyCart_ShouldReturnZero() {
        assertEquals(0.0, CartCalculator.calculateTotal(new double[]{}, new int[]{}), 0.001);
    }
}