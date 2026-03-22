package org.console;

import org.console.model.Habits;
import org.console.model.Reward;
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
    private Reward reward=new Reward();
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
            System.out.println("1. Add Habit\n" +
                    "2. View Habits\n" +
                    "3. Mark as Complete\n" +
                    "4. Delete Habit\n" +
                    "5. My Progress\n" +
                    "6. Logout\n");
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
                case 3:
                    m.markComplete();
                    break;
                case 4:
                    m.deletHabit();
                    break;
                case 5:
                    m.progress();
                case 6:
                    System.out.println("Logout.........");
                    System.exit(0);
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    private void progress() {
        System.out.println("Progress for "+currentUser.getUserName());
        int total=0;
        int completed=0;
        for(Habits h:habits){
            if(currentUser.getUserId()==h.getUserId()){
                total++;
                completed=h.isStatus()?completed+1:completed;
            }
        }
        System.out.println("Total: "+total);
        System.out.println("Completed: "+completed);
        System.out.println("Progress: "+(total-completed));
        System.out.println("Completion: "+(total==0?0:(completed*100.0/total)));
        String[] freq={"daily","weekly","monthly"};
        for(String f:freq){
            long count=habits.stream().filter(h-> {
                            return currentUser.getUserId()==h.getUserId() && h.getFrequency().equals(f);
            }).count();
            long comp=habits
                    .stream()
                    .filter(h->{
                        return currentUser.getUserId()==h.getUserId() && h.getFrequency().equals(f) && h.isStatus();
                    }).count();
            System.out.println(f+" "+comp+"/"+count);
        }
    }

    private void deletHabit() {
        viewHabits();
        System.out.println("Enter Habit ID to Delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        for(Habits h:habits){
            if(h.getHabitId()==id){
                habits.remove(h);
                return;
            }
        }
        System.out.println("There is no such habit with that ID");
    }

    private void markComplete() {
        viewHabits();
        System.out.print("Enter Habit ID to mark complete: ");
        int id = sc.nextInt();
        sc.nextLine();
        for(Habits h:habits){
            if(h.getHabitId()==id){
                h.setStatus(true);
                currentUser.addPoints(reward.pointFor(h.getFrequency()));
                return;
            }
        }
        System.out.println("There is no such habit with that ID");
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
                        "\nFrequency: "+h.getFrequency()+
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
        System.out.print("Enter frequency(eg. Daily, Weekly, Monthly): ");
        String frequency = sc.nextLine().toLowerCase();
        habits.add(new Habits(currentUser.getUserId(),habitName,frequency));
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