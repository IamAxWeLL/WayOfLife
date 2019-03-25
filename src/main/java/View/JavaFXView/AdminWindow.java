package View.JavaFXView;

import Entity.User;
import Services.UserService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminWindow {

    public static Scene adminScene;
    private VBox vBox;
    private UserService userService;
    private ArrayList<User> userViews;



    public AdminWindow(UserService userService)  {

        this.vBox = new VBox();
        this.userViews = new ArrayList();
        this.userService = userService;



        addButtons();
        fillUsers();

        this.adminScene = new Scene(vBox);
    }

    private void addButtons(){
        Button addUser = new Button("add user");
        addUser.setOnAction(event -> {
            addUser();
        });
        Button deleteUser = new Button("delete user");
        deleteUser.setOnAction(event -> {
            deleteUser();
        });

        Button logoutButton = new Button("logout");
        logoutButton.setOnAction(event -> {
            ControllerJavaFX.setScene(LoginWindow.loginScene);
        });
        TextField textField = new TextField();
        textField.setPromptText("enter user");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(addUser,deleteUser,logoutButton);
        vBox.getChildren().addAll(hBox,textField);

    }

    void fillUsers(){

      /*  try {
            userViews = (ArrayList)userService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



        for (int i = 0; i < 10; i++){
            userViews.add(new User(i, "user", 1,  1));

        }
        UserView userViewButtons = new UserView();
//        vBox.getChildren().add(userViewButtons.gethBox());
        userViews.stream().forEach(n -> {
            UserView userView = new UserView(n);
            vBox.getChildren().add(userView.gethBox());
        });
    }

    void addUser(){
        userService.add(new User(1, "user", 1,  1));
    }

    void deleteUser(){
        userService.remove(new User(1, "user", 1,  1));
    }
}
