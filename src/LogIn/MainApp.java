package LogIn;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static Stage stage;
    public static Scene logInScreen;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainApp.stage = stage;
        logInScreen = createLogInScene();
        LoggedInScene.loggedInScreen = LoggedInScene.createLoggedInScene();
        stage.setScene(logInScreen);
        stage.setTitle("Log-In Screen");
        stage.show();
    }

    public static Scene createLogInScene() {
        Button log_In = new Button("Log-In");
        log_In.setBackground(Background.fill(Color.TAN));

        TextField userNameField = new TextField();
        PasswordField passwordField = new PasswordField();

        Label userNameLabel = new Label("Username:");
        userNameLabel.setTextFill(Color.DARKOLIVEGREEN);
        userNameLabel.setBackground(Background.fill(Color.TRANSPARENT));
        userNameLabel.setAlignment(Pos.CENTER);
        userNameLabel.setMinSize(75, 25);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.DARKOLIVEGREEN);
        passwordLabel.setBackground(Background.fill(Color.TRANSPARENT));
        passwordLabel.setAlignment(Pos.CENTER);
        passwordLabel.setMinSize(75,25);

        Text validationText = new Text("");
        validationText.setFill(Color.BLACK);
        validationText.setFont(new Font(14));

        addEventHandlers(log_In, userNameField, passwordField, validationText);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50, 100, 50, 100));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setBackground(Background.fill(Color.WHEAT));

        gridPane.add(userNameLabel, 0, 0, 3, 1);
        gridPane.add(passwordLabel, 0, 1, 3, 1);
        gridPane.add(userNameField, 4, 0, 7, 1);
        gridPane.add(passwordField, 4, 1, 7, 1);
        gridPane.add(log_In, 1, 2);
        gridPane.add(validationText, 0, 3, 7, 1);

        return new Scene(gridPane, 750, 500);
    }

    private static void addEventHandlers(Button log_In,
                                         TextField userNameField, PasswordField passwordField,
                                         Text validationText) {
        log_In.setOnAction(actionEvent -> {
            String userName = userNameField.getText();
            String password = passwordField.getText();

            if(userName == null || password == null || userName.equals("") || password.equals("")) {
                validationText.setText("Username or Password is empty");
                return;
            }
            if(!(isUserNameCorrect(userName) && isPasswordCorrect(password))){
                validationText.setText("Invalid Username or Password");
                return;
            }
            stage.setScene(LoggedInScene.loggedInScreen);
        });
    }

    static boolean isPasswordCorrect(String password) {
        return CommonData.password.equals(password);
    }

    static boolean isUserNameCorrect(String userName) {
        return CommonData.username.equals(userName);
    }
}
