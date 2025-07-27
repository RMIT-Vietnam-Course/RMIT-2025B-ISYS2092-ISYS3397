import org.junit.*;
import java.util.Arrays;
import java.util.List;

public class CartServiceTest {
    private CartService cart;

    @Before
    public void setUp() {
        cart = new CartService();
    }

    @Test
    public void shouldIncreaseItemCountWhenItemAdded() {
        cart.addItem("Apple");
        Assert.assertEquals(1, cart.getItemCount());
    }

    @Test
    public void shouldNotBeEmptyAfterAddingItem() {
        cart.addItem("Banana");
        Assert.assertFalse(cart.isEmpty());
    }

    @Test
    public void shouldBeEmptyAfterCartIsCleared() {
        cart.addItem("Orange");
        cart.clear();
        Assert.assertTrue(cart.isEmpty());
    }

    @Test
    public void shouldReturnItemsMatchingAddedOrder() {
        cart.addItem("Pen");
        cart.addItem("Notebook");
        List<String> expected = Arrays.asList("Pen", "Notebook");
        Assert.assertArrayEquals(expected.toArray(), cart.getItems().toArray());
    }

    @Test
    public void shouldCreateNonNullCartInstance() {
        Assert.assertNotNull(cart);
    }

    @Test
    public void shouldReturnSameReferenceForItemsList() {
        List<String> listRef = cart.getItems();
        Assert.assertSame(listRef, cart.getItems());
    }

    @Test
    public void shouldReturnDifferentInstancesFromGetItemsCopy() {
        List<String> copy1 = cart.getItemsCopy();
        List<String> copy2 = cart.getItemsCopy();
        Assert.assertNotSame(copy1, copy2);
    }
}