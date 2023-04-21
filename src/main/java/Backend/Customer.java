package Backend;

public class Customer extends Person {

    private int id;
    public Customer() {
        super();
    }

    public Customer(String cnic, String phoneNo, String email, String password, Date dateOfBirth, Name name, Address address, int id) {
        super(cnic, phoneNo, email, password, dateOfBirth, name, address);
        this.id = id;
    }


    public Customer(Person p1, int id) {
        super(p1);
        this.id = id;
    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
