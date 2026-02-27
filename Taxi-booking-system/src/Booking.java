public class Booking {
    private long customerId;
    private char pickUpPoint;
    private char dropPoint;
    private long pickupTime;
    private double charges;
    public Booking(long customerId, char dropPoint, char pickUpPoint, long pickupTime,double charges) {
        this.customerId = customerId;
        this.dropPoint = dropPoint;
        this.pickUpPoint = pickUpPoint;
        this.pickupTime = pickupTime;
        this.charges = charges;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }

    public char getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(char pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public long getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(long pickupTime) {
        this.pickupTime = pickupTime;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }
}
