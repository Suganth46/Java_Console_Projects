import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static List<Taxi> taxi=new ArrayList<>();
    public static void main(String[] args) {
        int n=4;
        for(int i=0;i<n;i++){
            taxi.add(new Taxi(true,0.0,'A',0));
        }
        while(true){
            System.out.println("Call taxi booking : ");
            System.out.print("Customer id: ");
            long customerId=sc.nextLong();
            System.out.print("PickUp Point: ");
            char pickupPoint=Character.toUpperCase(sc.next().charAt(0));
            System.out.print("DropOff Point: ");
            char dropOffPoint=Character.toUpperCase(sc.next().charAt(0));
            System.out.print("Pickup Time: ");
            long pickupTime=sc.nextLong();
            double charges=100+((((dropOffPoint-pickupPoint)*15)-5)*10);
            Booking book=new Booking(customerId,pickupPoint,dropOffPoint,pickupTime,charges);
            boolean booked=false;
            for (int i=0;i<taxi.size();i++){
                Taxi curTaxi=taxi.get(i);
                if(curTaxi.isAvailable() && (curTaxi.getCurrPoint()<=pickupPoint)){
                    curTaxi.setAvailable(false);
                    curTaxi.setEarnings(curTaxi.getEarnings()+charges);
                    curTaxi.getTrips().add(book);
                    System.out.println(curTaxi.getId()+" is alloted");
                    booked=true;
                    break;
                }
            }
            if(!booked){
                System.out.println("No taxi booking found");
            }
        }
    }
}