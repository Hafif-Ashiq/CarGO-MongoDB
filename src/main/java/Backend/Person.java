package Backend;


public class Person {
    private String cnic, phoneNo, email, password;
    private Date dateOfBirth;
    private Name name;
    private Address address;

    // Constructor


    public Person(String cnic, String phoneNo, String email, String password, Date dateOfBirth, Name name, Address address) {
        this.cnic = cnic;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.address = address;
    }

    // Constructor (for Admin)
    public Person(String cnic, Name name){
        this.cnic = cnic;
        this.name = name;
    }

    public Person(Person p1){
        dateOfBirth = p1.dateOfBirth;
        name = p1.name;
        address = p1.address;
    }

    public Person(){

    };




    // Setters


    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }



    public void setName(Name name_prime) {
        if (name_prime != null) {
            this.name = name_prime;
        }
    }

    public void setAdress(Address address_prime) {
        if (address_prime != null) {
            this.address = address_prime;
        } else {
            this.address = new Address(0,"");

        }
    }

    public void setDateOfBirth(Date date_prime) {
        if (date_prime != null) {
            this.dateOfBirth = date_prime;
        } else {
            dateOfBirth = new Date(1, 1, 1);
        }
    }


    // Getters
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Name getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    // toString
    public String toString() {
        return dateOfBirth + name.toString() + address.toString();
    }
}

