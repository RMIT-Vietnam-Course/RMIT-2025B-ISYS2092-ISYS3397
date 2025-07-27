import java.util.*;

public class CartService {
    private List<String> items = new ArrayList<>();

    public void addItem(String name) {
        items.add(name);
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<String> getItems() {
        return items;
    }

    public List<String> getItemsCopy() {
        return new ArrayList<>(items);
    }

    public void clear() {
        items.clear();
    }
}