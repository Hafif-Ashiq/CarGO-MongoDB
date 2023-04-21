package Pages;

import Pages.Login;
import Pages.Login_Signup;
import Pages.User_HomeScreen;

public class Main {
    // Screen Essentials
    public static int screen_Width = 1280;
    public static int screen_Height = 759;
    public static int fg = 57; // Foreground Color All rgb -> Darker Shade
    public static int bg = 236; // Background Color All rgb -> Lighter Shade
    public static String screen_Title = "CarGo";
    public static String screen_Image_Location = "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Dark-PNG.png";


    // ------------------------------------------------- //
    // ----------------- Customers --------------------- //
        /*Login_Signup main_page = new Login_Signup(screen_Width, screen_Height, screen_Title, screen_Image_Location);
        main_page.setVisible(true);*/

        /*User_HomeScreen home_page = new User_HomeScreen(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        home_page.setVisible(true);*/

        /*Store store_page = new Store(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        store_page.setVisible(true);*/
    //store_page.dispose();

         /*Type type_page = new Type(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        type_page.setVisible(true);*/

        /*Car car_page = new Car(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        car_page.setVisible(true);*/
    //car_page.dispose();

         /*Booking booking_page = new Booking(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        booking_page.setVisible(true);*/
    //booking_page.dispose();

         /*Payment payment_page = new Payment(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        payment_page.setVisible(true);*/

         /*Login login_page = new Login(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        login_page.setVisible(true);*/

        /*Signup signup_pageA = new Signup(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        signup_pageA.setVisible(true);

        Signup signup_pageB = new Signup(screen_Width, screen_Height, screen_Title, screen_Image_Location, "Abdullah");
        signup_pageB.setVisible(true);*/

    // For Customers
         /*ListCars list_page = new ListCars(screen_Width, screen_Height, screen_Title, screen_Image_Location, "Sedan", "Abdullah");
        list_page.setVisible(true);*/

    // -----------------------------------------------------------//
    // ----------------------- Company ---------------------------//
        /*Company_HomeScreen company_home_page = new Company_HomeScreen(screen_Width, screen_Height, screen_Title, screen_Image_Location, screen_Image_Location, "Abdullah");
        company_home_page.setVisible(true);*/

    // For Company
        /*ListProducts list_product_page = new ListProducts(screen_Width, screen_Height, screen_Title, screen_Image_Location, "Sedan", "Abdullah");
        list_product_page.setVisible(true);*/

        /*Modify modify_page = new Modify(screen_Width, screen_Height, screen_Title, screen_Image_Location, "Modify", "Abdullah");
        modify_page.setVisible(true);*/

        /*Add_Product add_product_page = new Add_Product(screen_Width, screen_Height, screen_Title, screen_Image_Location, "Modify", "Abdullah");
        add_product_page.addCoupe();
        add_product_page.addPic();
        add_product_page.setVisible(true);*/

    // -----------------------------------------------------------//
    // ---------------------------- Admin ------------------------//
        /*AdminHome admin_home_page = new AdminHome(screen_Width, screen_Height, screen_Title, screen_Image_Location, "Modify", "Abdullah");
        admin_home_page.setVisible(true);*/

        /*AdminUsers admin_user_page = new AdminUsers(screen_Width, screen_Height, screen_Title, screen_Image_Location, "Users", "Abdullah");
        admin_user_page.setVisible(true);*/

        /*AdminStats admin_stats_page = new AdminStats(screen_Width, screen_Height, screen_Title, screen_Image_Location, "Statistics - Person Name", "Abdullah");
        admin_stats_page.setVisible(true);*/

    // Open New Page

    public static void openInstance(Object route) {

        if (route instanceof Login_Signup){
            Login_Signup main_page = (Login_Signup) route;
            main_page.setVisible(true);
            //System.out.println("Yes it is instance");
        }
        else if (route instanceof Login){
            Login login_page = (Login) route;
            login_page.setVisible(true);
            //System.out.println("Yes it is instance");

        }
        else if(route instanceof User_HomeScreen){
            User_HomeScreen home_page = (User_HomeScreen) route;
            home_page.setVisible(true);
        }
        else if(route instanceof Store){
            Store store_page = (Store) route;
            store_page.setVisible(true);
        }
        else if(route instanceof Type){
            Type type_page = (Type) route;
            type_page.setVisible(true);
        }
        else if(route instanceof Car){
            Car car_page = (Car) route;
            car_page.setVisible(true);
        }
        else if(route instanceof Booking){
            Booking booking_page = (Booking) route;
            booking_page.setVisible(true);
        }
        else if(route instanceof Payment){
            Payment payment_page = (Payment) route;
            payment_page.setVisible(true);
        }
        else if(route instanceof Login){
            Login login_page = (Login) route;
            login_page.setVisible(true);
        }
        else if(route instanceof Signup){
            Signup sign_page = (Signup) route;
            sign_page.setVisible(true);
        }
        else if(route instanceof ListCars){
            ListCars list_cars_page = (ListCars) route;
            list_cars_page.setVisible(true);
        }
        // ------------------------------------------------- //
        else if(route instanceof Company_HomeScreen){
            Company_HomeScreen company_homescreen_page = (Company_HomeScreen) route;
            company_homescreen_page.setVisible(true);
        }
        else if(route instanceof ListProducts){
            ListProducts list_product_page = (ListProducts) route;
            list_product_page.setVisible(true);
        }
        else if(route instanceof Modify){
            Modify modify_page = (Modify) route;
            modify_page.setVisible(true);
        }
        else if(route instanceof Add_Product){
            Add_Product add_product_page = (Add_Product) route;
            add_product_page.setVisible(true);
        }
        // ------------------------------------------------ //
        else if(route instanceof AdminHome){
            AdminHome admin_home_page = (AdminHome) route;
            admin_home_page.setVisible(true);
        }
        else if(route instanceof AdminUsers){
            AdminUsers admin_users_page = (AdminUsers) route;
            admin_users_page.setVisible(true);
        }
        else if(route instanceof AdminStats){
            AdminStats admin_stats_page = (AdminStats) route;
            admin_stats_page.setVisible(true);
        }


    }
    // Close Instance
    public static void closeInstance(Object route) {

        if (route instanceof Login_Signup){
            Login_Signup main_page = (Login_Signup) route;
            main_page.setVisible(false);
        }
        else if (route instanceof Login){
            Login login_page = (Login) route;
            login_page.setVisible(false);

        }
        else if(route instanceof User_HomeScreen){
            User_HomeScreen home_page = (User_HomeScreen) route;
            home_page.setVisible(false);
        }
        else if(route instanceof Store){
            Store store_page = (Store) route;
            store_page.setVisible(false);
        }
        else if(route instanceof Type){
            Type type_page = (Type) route;
            type_page.setVisible(false);
        }
        else if(route instanceof Car){
            Car car_page = (Car) route;
            car_page.setVisible(false);
        }
        else if(route instanceof Booking){
            Booking booking_page = (Booking) route;
            booking_page.setVisible(false);
        }
        else if(route instanceof Payment){
            Payment payment_page = (Payment) route;
            payment_page.setVisible(false);
        }
        else if(route instanceof Login){
            Login login_page = (Login) route;
            login_page.setVisible(false);
        }
        else if(route instanceof Signup){
            Signup sign_page = (Signup) route;
            sign_page.setVisible(false);
        }
        else if(route instanceof ListCars){
            ListCars list_cars_page = (ListCars) route;
            list_cars_page.setVisible(false);
        }
        // ------------------------------------------------- //
        else if(route instanceof Company_HomeScreen){
            Company_HomeScreen company_homescreen_page = (Company_HomeScreen) route;
            company_homescreen_page.setVisible(false);
        }
        else if(route instanceof ListProducts){
            ListProducts list_product_page = (ListProducts) route;
            list_product_page.setVisible(false);
        }
        else if(route instanceof Modify){
            Modify modify_page = (Modify) route;
            modify_page.setVisible(false);
        }
        else if(route instanceof Add_Product){
            Add_Product add_product_page = (Add_Product) route;
            add_product_page.setVisible(false);
        }
        // ------------------------------------------------ //
        else if(route instanceof AdminHome){
            AdminHome admin_home_page = (AdminHome) route;
            admin_home_page.setVisible(false);
        }
        else if(route instanceof AdminUsers){
            AdminUsers admin_users_page = (AdminUsers) route;
            admin_users_page.setVisible(false);
        }
        else if(route instanceof AdminStats){
            AdminStats admin_stats_page = (AdminStats) route;
            admin_stats_page.setVisible(false);
        }

    }
}

