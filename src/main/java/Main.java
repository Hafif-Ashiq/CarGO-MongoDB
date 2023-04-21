import Backend.InsertSQL;
import Backend.Picture;
import Essentials.*;
import Pages.*;
//import java.sql.*;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.*;

public class Main {


    public static void main(String[] args) {

        


        Login_Signup main_page = new Login_Signup(Pages.Main.screen_Width, Pages.Main.screen_Height, Pages.Main.screen_Title, Pages.Main.screen_Image_Location);
        main_page.setVisible(true);
        Static.route.push(main_page);
    
}
}
