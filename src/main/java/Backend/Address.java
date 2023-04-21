package Backend;

public class Address {
    private int Zip;
    private String City;
    
    // Constructor
    public Address(int Zip_prime, String City_prime){
        
        this.Zip = Zip_prime;

        if(City_prime != null){
            this.City = City_prime;
        
        }
        else{
            this.City = ""; 
        }

    }


    // Setters
    public void setZip(int zip) {
        Zip = zip;
    }

    public void setCity(String City_prime) {
        if(City_prime != null){
            this.City = City_prime;
        
        }
        else{
            this.City = ""; 
        }
    }


    // Gettes
    public String getCity() {
        return City;
    }
    public int getZip() {
        return Zip;
    }

    // toString
    public String toString() {

        return  (Zip + "") + City;
    }
}
