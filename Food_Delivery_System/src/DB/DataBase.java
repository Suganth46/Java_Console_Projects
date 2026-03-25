package DB;

import Model.Customer;
import Model.DeliveryBoy;
import Model.Menu;
import Model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    private ArrayList<Customer> customers;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<DeliveryBoy> deliveryBoys;
    private HashMap<Integer, HashMap<Integer,Menu>> menus;
    public DataBase() {
        customers = new ArrayList<>();
        restaurants = new ArrayList<>();
        deliveryBoys = new ArrayList<>();
        menus = new HashMap<>();
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public List<Restaurant> getRestaruant() {
        return restaurants;
    }
    public HashMap<Integer,Menu> getMenu(int id) {
        return menus.get(id);
    }
    public void addMenu(int id,Menu menu) {
        if(menus.get(id)==null) {
            menus.put(id,new HashMap<>());
        }
        menus.get(id).put(id,menu);
    }

    public int addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        return restaurant.getId();
    }
}
