package DB;

import Model.Customer;
import Model.DeliveryBoy;
import Model.Menu;
import Model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private ArrayList<Customer> customers;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<DeliveryBoy> deliveryBoys;
    private ArrayList<Menu> menus;
    public DataBase() {
        customers = new ArrayList<>();
        restaurants = new ArrayList<>();
        deliveryBoys = new ArrayList<>();
        menus = new ArrayList<>();
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
    public List<Menu> getMenu() {
        return menus;
    }
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

}
