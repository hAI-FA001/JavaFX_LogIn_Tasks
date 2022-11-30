package ForgotPassword;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ResetPasswordScene {
    public static Scene resetPasswordScreen;

    public static Scene createResetPasswordScene(){
        PasswordField newPassword = new PasswordField();
        Label enterPassword = new Label("Enter New Password:");
        PasswordField confirmPassword = new PasswordField();
        Label confirmPasswordLabel = new Label("Confirm Password:");

        Text status = new Text();
        status.setFill(Color.MIDNIGHTBLUE);

        Button reset = new Button("Reset");

        reset.setBackground(Background.fill(Color.YELLOW));
        reset.setMinWidth(200);
        reset.setOnAction(actionEvent -> {
            if(newPassword.getText().equals(confirmPassword.getText())) {
                status.setFill(Color.DARKBLUE);
                status.setText("Password Reset Successfully");
            }
            else {
                status.setFill(Color.RED);
                status.setText("Confirm Password Does Not Match New Password");
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setBackground(Background.fill(Color.CORNSILK));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(5);

        gridPane.add(enterPassword, 0, 0);
        gridPane.add(newPassword, 1, 0);
        gridPane.add(confirmPasswordLabel, 0, 1);
        gridPane.add(confirmPassword, 1, 1);
        gridPane.add(reset, 1, 2);
        gridPane.add(status, 0, 3, 7, 1);

        return new Scene(gridPane, 750, 500);
    }
}
