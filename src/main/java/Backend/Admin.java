package Backend;

public class Admin extends Person {

    private int id;
    public Admin() {
        super();
    }

    public Admin(String cnic, String phoneNo, String email, String password, Date dateOfBirth, Name name, Address address, int id) {
        super(cnic, phoneNo, email, password, dateOfBirth, name, address);
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
