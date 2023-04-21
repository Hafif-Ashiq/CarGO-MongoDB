package Backend;

import java.sql.*;
import Backend.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.*;


public class InsertSQL {
    public static void insert(Object obj, MongoCollection st){


        if(obj instanceof Admin){
            Admin g1 = (Admin) obj;
            try {
                // Super Bakwaas
//                st.executeUpdate("INSERT INTO PERSON VALUES (" + F1.getSSN() +",'"+ F1.getSex() +"'," + "TO_DATE('" + F1.getDate().getDay() + "/" + F1.getDate().getMonth() + "/" + F1.getDate().getYear() + "', 'DD/MM/YYYY'))");
//                st.executeUpdate("INSERT INTO NAME VALUES ('" + F1.getName().getF_name() + "','" + F1.getName().getM_name() + "','" + F1.getName().getL_name() + "','" + F1.getSSN() + "')");
//                st.executeUpdate("INSERT INTO ADDRESS VALUES (" + F1.getAdress().getNO() + ",'" + F1.getAdress().getStreet() + "'," + F1.getAdress().getApt_no() + ",'" + F1.getSSN() + "','" + F1.getAdress().getCity() + "','" + F1.getAdress().getState() + "'," + F1.getAdress().getZip() + ")");
               st.insertOne(
                       new Document("cnic",g1.getCnic())
                               .append("email", g1.getEmail())
                               .append("password",g1.getPassword())
                               .append("phone", g1.getPhoneNo())
                               .append("f_name", g1.getName().getF_name())
                               .append("l_name", g1.getName().getL_name())
                               .append("city", g1.getAddress().getCity())
                               .append("zip_code", g1.getAddress().getZip())
                               .append("dob", g1.getDateOfBirth().toString())
               );
                // Faculty Now
//                st.executeUpdate("INSERT INTO FACULTY VALUES (" + F1.getRank() + ",'" + F1.getF_Office() + "','" + F1.getF_Phone() + "'," + F1.getSalary() + ",'" + F1.getSSN() + "'," + F1.getFaculty_ID() + ")");
            }
            catch (Exception er){
                System.out.println("Error!<Admin>");
            }
        }

        else if(obj instanceof Manufacturer){
            Manufacturer g1 = (Manufacturer) obj;
            try {
                st.insertOne(
                        new Document("cnic",g1.getCnic())
                                .append("email", g1.getEmail())
                                .append("password",g1.getPassword())
                                .append("phone", g1.getPhoneNo())
                                .append("f_name", g1.getName().getF_name())
                                .append("l_name", g1.getName().getL_name())
                                .append("city", g1.getAddress().getCity())
                                .append("zip_code", g1.getAddress().getZip())
                                .append("dob", g1.getDateOfBirth().toString())
                                .append("company",g1.getCompany())
                                .append("id",g1.getId())
                                .append("picture",g1.getCarPicture().getPicture_address())
                );
            }

            catch (Exception er){
                System.out.println("Error!<Manufacturer>");
            }
        }

        else if(obj instanceof Customer){
            Customer g1 = (Customer) obj;

            try {
                st.insertOne(
                        new Document("cnic",g1.getCnic())
                                .append("email", g1.getEmail())
                                .append("password",g1.getPassword())
                                .append("phone", g1.getPhoneNo())
                                .append("f_name", g1.getName().getF_name())
                                .append("l_name", g1.getName().getL_name())
                                .append("city", g1.getAddress().getCity())
                                .append("zip_code", g1.getAddress().getZip())
                                .append("dob", g1.getDateOfBirth().toString())
                                .append("id",g1.getId())
                );
                }
            catch (Exception ex){
                System.out.println("Error!<Customer>");
            }
        }
//        else if(obj instanceof Person){
//            Person G1 = (Person) obj;
//
//            try {
//                st.executeUpdate("INSERT INTO PERSON VALUES ('" + G1.getCnic() + "','" + G1.getEmail() + "','"+G1.getPassword()+"',TO_DATE('"+G1.getDateOfBirth().getDay() + "/"+G1.getDateOfBirth().getMonth() +"/"+ G1.getDateOfBirth().getYear() + "','DD/MM/YYYY'),'"+G1.getPhoneNo() + "')");
//                st.executeUpdate("INSERT INTO NAME VALUES ('" + G1.getCnic() + "','"+ G1.getName().getF_name() + "','" + G1.getName().getL_name() +"')");
//                st.executeUpdate("INSERT INTO ADDRESS VALUES ('" + G1.getCnic() + "','"+ G1.getAddress().getCity() + "'," + G1.getAddress().getZip() +")");
//
//            }
//            catch (Exception ex){
//                System.out.println("Error!<Person>");
//            }
//        }
//
        else if(obj instanceof Payment){
            Payment G1 = (Payment) obj;
            // int payment_id, int CVV, int card_no, Date payment_date
            try {
//                st.executeUpdate("INSERT INTO PAYMENT VALUES (" + G1.getPayment_id() + ","+ G1.getCVV() + ",'" + G1.getCard_no() +"',TO_DATE('"+G1.getPayment_date().getDay() + "/"+G1.getPayment_date().getMonth() +"/"+ G1.getPayment_date().getYear() + "','DD/MM/YYYY'))");

//                st.executeUpdate("INSERT INTO ADDRESS VALUES ('\" + G1.getCnic() + \"','\"+ G1.getAddress().getCity() + \"',\" + G1.getAddress().getZip() +\")")
            }
            catch (Exception ex){
                System.out.println("Error!<Payment>");
            }
        }

        /*else if(obj instanceof Booking){
            Booking G1 = (Booking) obj;

            // int booking_id, String car_name, String owner_name,String car_company, Date booking_date
            try {
                // Course
                st.executeUpdate("INSERT INTO BOOKING VALUES (" + G1.getBooking_id() + "," + G1.getCar_ID() + "," + G1.getOwner_ID() + ",'" + G1.getCar_company() + "','" + "',TO_DATE('"+ G1.getBooking_date().getDay() + "/"+ G1.getBooking_date().getMonth() +"/"+ G1.getBooking_date().getYear() +"')");
            }
            catch (Exception ex){
                System.out.println("Error!<Booking>");
            }
        }*/

        else if(obj instanceof Stats){
            Stats G1 = (Stats) obj;

            try {

//                st.executeUpdate("INSERT INTO STATS VALUES (" + G1.getStats_id() + "," + G1.getBooking_id() +")");
            }
            catch (Exception ex){
                System.out.println("Error!<Stats>");
            }
        }

        else if(obj instanceof Car){
            Car g1 = (Car) obj;

            System.out.println("On Car\n");
            System.out.println(g1.getType());
            System.out.println(g1.getCar_color());
            System.out.println(g1.getCar_id());
            System.out.println(g1.getCar_company());
            System.out.println(g1.getCar_name());
            System.out.println(g1.getCar_price());
            System.out.println(g1.getCar_quantity());
            System.out.println(g1.getCarTypeID());
            System.out.println(g1.getCar_picture().getPicture_id());
            System.out.println(g1.getCar_picture().getPicture_name());
            System.out.println(g1.getCar_picture().getPicture_address());

            try {
//                st.executeUpdate("INSERT INTO PICTURE VALUES (" + G1.getCar_picture().getPicture_id() + ",'"+G1.getCar_picture().getPicture_name() + "','"+G1.getCar_picture().getPicture_address() + "')");





                System.out.println("Till picture");

//                if (g1.getType().equalsIgnoreCase("SUV"))
                    st.insertOne(
                            new Document("car_name",g1.getCar_name())
                                    .append("coupe",g1.getCoupe())
                                    .append("company", g1.getCar_company())
                                    .append("color",g1.getCar_color())
                                    .append("quantity", g1.getCar_quantity())
                                    .append("price", g1.getCar_price())
                                    .append("picture_name", g1.getCar_picture().getPicture_name())
                                    .append("picture_address", g1.getCar_picture().getPicture_address())
                                    .append("id",g1.getCar_id())

                    );
//                    st.executeUpdate("INSERT INTO SUV VALUES (" + G1.getCarTypeID() + ",'" + G1.getCar_id() + "')");
//                else if (g1.getType().equalsIgnoreCase("Sports"))
//                    st.executeUpdate("INSERT INTO SPORTS VALUES (" + g1.getCarTypeID() + ",'" + g1.getCar_id() + "')");
//                else if (g1.getType().equalsIgnoreCase("SEDAN"))
//                    st.executeUpdate("INSERT INTO SEDAN VALUES (" + g1.getCarTypeID() + ",'" + g1.getCar_id() + "')");
//                else if (g1.getType().equalsIgnoreCase("JEEP"))
//                    st.executeUpdate("INSERT INTO JEEP VALUES (" + g1.getCarTypeID() + ",'" + g1.getCar_id() + "')");
//                else if (g1.getType().equalsIgnoreCase("Hatch Back"))
//                    st.executeUpdate("INSERT INTO HATCH_BACK VALUES (" + g1.getCarTypeID() + ",'" + g1.getCar_id() + "')");

            }
            catch (Exception ex){
                System.out.println("Error!<CAR>");
            }
        }




    }
    // -----------------------------------------------------//
}
