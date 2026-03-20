package org.console;

import org.console.model.Habits;
import org.console.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<User> users=new ArrayList<>();
    private ArrayList<Habits> habits=new ArrayList<>();
    private User currentUser;
    public static void main(String[] args) {
        Main m = new Main();
        do{
            System.out.println("HABIT TRACKER");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            System.out.print("Enter your choice: ");
            int  choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    m.register();
                    break;
                case 2:
                    m.login();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Wrong choice");
            }
        }while(false);

        System.out.println("Welcome, "+m.currentUser.getUserName());
        while(true){
            System.out.println("1. Add Habit\n2. View Habits");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    m.addHabit();
                    break;
                case 2:
                    m.viewHabits();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    private void viewHabits() {
        if(habits.size()==0){
            System.out.println("There is no Habits to view");
            return;
        }
        for(Habits h:habits){
            if(h.getUserId()==currentUser.getUserId()){
                System.out.println(h.getHabitId()+": "+h.getHabitName()+
                        "\nStatus: "+h.isStatus()+
                        "\nCreated At: "+dateAndTime(h.getDateTime()));
            }
        }
    }
    private String dateAndTime(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return date.format(dtf);
    }
    private void addHabit() {
        System.out.print("Enter Habit Name: ");
        String habitName = sc.nextLine();
        habits.add(new Habits(currentUser.getUserId(),habitName));
    }

    private void login() {
        System.out.println("Login Habit Tracker");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        for(User user:users){
            if(username.equals(user.getUserName()) && password.equals(user.getPassword())){
                System.out.println("Login Successful");
                currentUser=user;
                return;
            }
        }
        System.out.println("Login Failed");
    }

    private void register() {
        System.out.println("Register Habit Tracker");
        System.out.print("Enter a Username: ");
        String username = sc.nextLine();
        System.out.print("Enter a Password: ");
        String password = sc.nextLine();
        System.out.print("Enter a Email Address: ");
        String email = sc.nextLine();
        User user = new User(username, password, email);
        currentUser=user;
        users.add(user);
    }
}