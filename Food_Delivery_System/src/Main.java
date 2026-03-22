

import Service.CustomerService;
import Service.DeliverBoyService;
import Service.RestaurantService;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("1. Customer\n" +
                    "2. Restaurant\n" +
                    "3. DeliverBoy\n" +
                    "4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    CustomerService customerService = new CustomerService();
                    customerService.dashBoardView();
                    break;
                case 2:
                    RestaurantService restaurantService = new RestaurantService();
//                    restaurantService.dashBoardView();
                    break;
                case 3:
                    DeliverBoyService deliverBoyService = new DeliverBoyService();
                    deliverBoyService.dashBoardView();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
