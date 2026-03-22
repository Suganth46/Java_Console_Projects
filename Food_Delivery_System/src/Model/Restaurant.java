package Model;

public class Restaurant extends User{
    private int rating;
    @Override
    public String toString() {
        return "Restaruant Name: "+getName()+"\n"
                +"Rating: "+getRating()+"\n"
                +"Phone No: "+getPhone()+"\n"
                +"Address: "+getAddress()+"\n";
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
