package Model;

public class Customer extends User {
    public Customer(String name, String password, String email, String phone, String address) {
        super(name,password,email,phone,address);
    }
    public Customer() {
        super();
    }
}
