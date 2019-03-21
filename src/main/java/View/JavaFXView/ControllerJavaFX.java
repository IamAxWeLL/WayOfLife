package View.JavaFXView;

import Services.AimService;
import Services.RoleService;
import Services.UserService;
import javafx.scene.Scene;

import java.sql.SQLException;

public class ControllerJavaFX {
    public static Scene mainScene;
    private LoginWindow loginWindow;
    private  UserWindow userWindow;
    private UserService userService;
    private AimService aimService;
    private RoleService roleService;

    public ControllerJavaFX(UserService userService, AimService aimService, RoleService roleService) {
        this.userService = userService;
        this.aimService = aimService;
        this.roleService = roleService;
        this.loginWindow = new LoginWindow(userService);
        try {
            this.userWindow = new UserWindow(aimService, userService);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.mainScene = UserWindow.userScene;


    }

    public static void setScene(Scene scene){
        mainScene = scene;
    }

}
