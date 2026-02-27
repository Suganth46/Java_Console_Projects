import java.util.ArrayList;
import java.util.List;

public class Taxi implements Comparable<Taxi>{
    private long id=0;
    private boolean available;
    private double earnings;
    private char currPoint;
    private long freeTime;
    private List<Booking> trips=new ArrayList<>();
    public Taxi(boolean available,  double earnings, char currPoint,long freeTime) {
        this.available = available;
        this.currPoint = currPoint;
        this.earnings = earnings;
        this.freeTime = freeTime;
    }

    @Override
    public int compareTo(Taxi o) {
        int res=Double.compare(this.earnings,o.earnings);
        if(res==0){
            return Math.toIntExact((int) this.id - o.id);
        }
        return res;
    }
    public char getCurrPoint() {
        return currPoint;
    }

    public void setCurrPoint(char currPoint) {
        this.currPoint = currPoint;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public List<Booking> getTrips() {
        return trips;
    }

    public void setTrips(List<Booking> trips) {
        this.trips = trips;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(long freeTime) {
        this.freeTime = freeTime;
    }
}
