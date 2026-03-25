package Model;

public class Menu {
    private static int count=0;
    private int id;
    private int restaurantId;
    private String Item;
    private double price;
    public Menu(int restaurantId, String Item, double price) {
        this.id=++count;
        this.restaurantId = restaurantId;
        this.Item = Item;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id: "+getId()+"Item: " + Item + ", price: " + price;
    }
    public int getId() {
        return id;
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
