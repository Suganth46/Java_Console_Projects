package Service;

import DB.DataBase;
import Model.Menu;
import Model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    private Scanner sc;
    private DataBase dataBase;
    public RestaurantService() {
        sc = new Scanner(System.in);
        dataBase = new DataBase();
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
        List<Menu>  menus =dataBase.getMenu();
        for (Menu menu:menus){
            if(res==menu.getRestaurantId()){
                System.out.println(menu.toString());
            }
        }
    }
}
