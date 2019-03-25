package View.JavaFXView;

import Entity.User;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class UserView {


    private Button idButton;
    private Button loginButton;
    private Button aimsQuantityButton;

    private HBox hBox;

    public UserView(User user) {
        this.idButton = new Button(String.valueOf(user.getId()));
        this.loginButton = new Button(String.valueOf(user.getLogin()));
        this.aimsQuantityButton = new Button(String.valueOf(user.getAims().size()));

        this.hBox = new HBox();

        hBox.getChildren().addAll(idButton,loginButton,aimsQuantityButton);
    }

    public UserView(){
        idButton = new Button("id");
        loginButton = new Button("login");
        aimsQuantityButton = new Button("aimsQuantity");
    }

    public HBox gethBox() {
        return hBox;
    }
}
