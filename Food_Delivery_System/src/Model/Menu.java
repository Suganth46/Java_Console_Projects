package Model;

public class Menu {
    private int restaurantId;
    private String Item;
    private double price;
    public Menu(int restaurantId, String Item, double price) {
        this.restaurantId = restaurantId;
        this.Item = Item;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item: " + Item + ", price: " + price;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
