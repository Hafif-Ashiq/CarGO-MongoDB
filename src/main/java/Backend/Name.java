package Backend;

public class Name {
    private String F_name;
    private String L_name;


    public Name(String F_prime, String L_prime){
        if(F_prime != null){
            this.F_name = F_prime;

        }
        else{
            this.F_name = "";
        }

        if(L_prime != null){
            this.L_name = L_prime;

        }
        else{
            this.L_name = "";
        }
    }


    // Setters
    public void setF_name(String F_prime) {
        if(F_prime != null){
            this.F_name = F_prime;
        
        }
        else{
            this.F_name = ""; 
        }
    }
    public void setL_name(String L_prime) {
        if(L_prime != null){
            this.L_name = L_prime;
        
        }
        else{
            this.L_name = ""; 
        }
    }


    // Getters
    public String getF_name() {
        return F_name;
    }
    public String getL_name() {
        return L_name;
    }

    // toString
    public String toString() {
        return F_name + L_name;

    }
}
