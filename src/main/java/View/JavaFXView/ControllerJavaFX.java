package View.JavaFXView;

import Services.AimService;
import Services.RoleService;
import Services.UserService;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ControllerJavaFX {
    public static Scene mainScene;
    private LoginWindow loginWindow;
    private  UserWindow userWindow;
    private  AdminWindow adminWindow;
    private UserService userService;
    private AimService aimService;
    private RoleService roleService;
    public static Stage primaryStage;

    public ControllerJavaFX(UserService userService, AimService aimService, RoleService roleService, Stage primaryStage) {
        this.userService = userService;
        this.aimService = aimService;
        this.roleService = roleService;
        this.primaryStage = primaryStage;
        this.loginWindow = new LoginWindow(userService);
        this.adminWindow = new AdminWindow(userService);
        this.userWindow = new UserWindow(aimService, userService);
        
        this.mainScene = LoginWindow.loginScene;
    }

    public static void setScene(Scene scene){
        primaryStage.setScene(scene);
    }
}
