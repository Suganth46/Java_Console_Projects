package Service;

import DB.DataBase;
import Model.Menu;
import Model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    private Scanner sc;
    private DataBase dataBase;
    public RestaurantService() {
        sc = new Scanner(System.in);
        dataBase = new DataBase();
        int restaurantId;
        restaurantId=dataBase.addRestaurant(new Restaurant("Sam Hotel","sam@123","sam@gamil.com","1234567890","coimbatore",2));
        dataBase.addMenu(restaurantId,new Menu(restaurantId,"chapathi",15));
        dataBase.addMenu(restaurantId,new Menu(restaurantId,"poori",65));
        restaurantId=dataBase.addRestaurant(new Restaurant("kumaraguru Hotel","kumaraguru@123","kumaraguru@gamil.com","1234567890","coimbatore",3));
        dataBase.addMenu(restaurantId,new Menu(restaurantId,"Dosa",15));
        dataBase.addMenu(restaurantId,new Menu(restaurantId,"idly",7));
        restaurantId=dataBase.addRestaurant(new Restaurant("Rudhra Bakery","rudhra@123","rudhra@gamil.com","1234567890","coimbatore",4));
        dataBase.addMenu(restaurantId,new Menu(restaurantId,"Chicken Rice",110));
        dataBase.addMenu(restaurantId,new Menu(restaurantId,"Veg Rice",90));
    }

    public int getRestaruant() {
        System.out.println("<---Restaurant List--->");
        List<Restaurant> restaurants =dataBase.getRestaruant();
        for (Restaurant restaurant:restaurants){
            System.out.println( restaurant.toString());
        }
        System.out.print("Enter restaurant id for Menu: ");
        int id=sc.nextInt();
        sc.nextLine();
        return id;
    }

    public void menu(int res) {
        System.out.println("<---Menu List--->");
        List<Menu>  menus =new ArrayList<>(dataBase.getMenu(res).values());
        for (Menu menu:menus){
            if(res==menu.getRestaurantId()){
                System.out.println(menu.toString());
            }
        }
    }

    public void order(int res) {
        System.out.println("Select the Food to order: ");
        HashMap<Integer,Menu> menus =dataBase.getMenu(res);
        while(true){
            System.out.print("Enter id of food to order: ");
            int id=sc.nextInt();
            sc.nextLine();

        }
    }
}
