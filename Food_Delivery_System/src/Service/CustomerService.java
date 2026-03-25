package Service;

import DB.DataBase;
import Model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private DataBase dataBase;
    private Customer customer;
    private RestaurantService restaurantService;
    public CustomerService() {
        dataBase = new DataBase();
        customer =new Customer();
        restaurantService = new RestaurantService();
    }
    Scanner sc = new Scanner(System.in);
    public void dashBoardView(){
        boolean flag=false;
        while(true){
        System.out.println("1. Register Customer\n" +
                "2. Login Customer\n" +
                "3. Exit Customer");
        int ch=sc.nextInt();
        sc.nextLine();
        switch(ch){
            case 1:
                flag=registerCustomer();;
                break;
            case 2:
                flag=loginCustomer();
                break;
            default:
                return;
        }
         if(flag){
                break;
         }
         else  {
             System.out.println("Login Failed");
         }
        }
        System.out.println("Welcome,"+customer.getName());
        while (true){
            System.out.println("1. Restaruant List\n" +
                    "Exit");
            System.out.print("Enter your choice: ");
            int ch=sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:
                    int res=restaurantService.getRestaruant();
                    restaurantService.menu(res);
                    restaurantService.order(res);
                    break;
                default:
                    return;
            }
        }
    }

    private boolean loginCustomer() {
        System.out.println("<---Login Customer-->");
        System.out.println("Enter your name: ");
        String name=sc.nextLine();
        System.out.println("Enter your password: ");
        String password=sc.nextLine();
        List<Customer> customers=dataBase.getCustomers();
        if(customers.isEmpty()){
            System.out.println("Customer is Empty");
        }
        else{
            for(Customer c:customers){
                if(c.getName().equals(name)&&c.getPassword().equals(password)){
                    customer=c;
                    System.out.println("Login Successful");
                    return true;
                }
            }
        }
        return false;
    }



    private boolean registerCustomer() {
        System.out.println("<---Register Customer--->");
//        System.out.print("Enter Customer Name: ");
//        String name=sc.nextLine();
//        System.out.print("Enter Customer Password: ");
//        String password=sc.nextLine();
//        System.out.print("Enter Customer Email: ");
//        String email=sc.nextLine();
//        System.out.print("Enter Customer Phone  Number: ");
//        String phone=sc.nextLine();
//        System.out.print("Enter Customer Address: ");
//        String address=sc.nextLine();
        customer=new Customer("Suganth","suganth@123","suganth@gmail.com","8262873223","coimbatore");
        dataBase.addCustomer(customer);
        System.out.println("Customer Registered Successfully");
        return true;
    }
}
