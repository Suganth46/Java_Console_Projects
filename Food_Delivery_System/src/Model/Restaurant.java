package Model;

public class Restaurant extends User{
    private int rating;

    public Restaurant(String name, String password, String email, String phone, String address, int i) {
        super(name, password, email, phone, address);
        this.rating = i;
    }

    @Override
    public String toString() {
        return "Id: " +getId()+"\n"
                +"Restaruant Name: "+getName()+"\n"
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
