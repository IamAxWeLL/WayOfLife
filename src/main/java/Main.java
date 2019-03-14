import Entity.Aim;
import Entity.User;
import Services.AimService;
import Services.UserService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AimService aimService = new AimService();
        UserService userService = new UserService();


       // aimService.add(new Aim(0,"aim1",new Date(2019,4,19),true,1));
       // userService.add(new User(1,"login",1111,1));
        try {
            aimService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
