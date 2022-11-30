package ForgotPassword;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
    static int generatedCode = 123;//new java.security.SecureRandom().nextInt(101);
    public static Stage stage;
    public static Scene forgotPasswordScreen;

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        MainApp.stage = stage;
        forgotPasswordScreen = createForgotPasswordScene();
        ResetPasswordScene.resetPasswordScreen = ResetPasswordScene.createResetPasswordScene();
        stage.setScene(forgotPasswordScreen);
        stage.show();
    }

    public static Scene createForgotPasswordScene() {
        TextField emailAddress = new TextField("Enter Email Here");
        Label emailAddressLabel = new Label("Email Address");

        Text status = new Text();
        status.setFill(Color.RED);

        Button sendCode = new Button("Send");
        sendCode.setBackground(Background.fill(Color.GREEN));
        sendCode.setTextFill(Color.WHITE);
        sendCode.setOnAction(actionEvent -> {
            status.setFill(Color.MIDNIGHTBLUE);
            status.setText("Sent Code to '" + emailAddress.getText() +"'");
        });

        /////////////////////////////////////////////
        TextField enterCode = new TextField("Enter Code Here");

        Button checkCode = new Button("Check");
        checkCode.setBackground(Background.fill(Color.GREEN));
        checkCode.setTextFill(Color.WHITE);
        checkCode.setOnAction(actionEvent -> {
            if(!enterCode.getText().equals(String.valueOf(generatedCode))) {
                status.setFill(Color.RED);
                status.setText("Invalid Code. Click on Send to send another code.");
                return;
            }
            status.setText("");
            stage.setScene(ResetPasswordScene.resetPasswordScreen);
        });

        /////////////////////////////////////////////
        GridPane gridPane = new GridPane();
        gridPane.setBackground(Background.fill(Color.CORNSILK));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(5);

        gridPane.add(emailAddressLabel, 0, 0, 5, 1);
        gridPane.add(emailAddress, 6, 0, 7, 1);
        gridPane.add(enterCode, 13, 0);
        gridPane.add(sendCode, 6, 1);
        gridPane.add(checkCode, 13, 1);
        gridPane.add(status, 0, 2, 20, 1);

        return new Scene(gridPane, 750, 500);
    }
}
