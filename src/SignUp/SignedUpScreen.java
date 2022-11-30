package SignUp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SignedUpScreen {
    public static Scene signedUpScreen;

    public static Scene createSignedUpScene(){
        Text signedUpText = new Text("Signed Up!");
        signedUpText.setFont(new Font(40));
        signedUpText.setFill(Color.MISTYROSE);

        Button signOutBtn = new Button("Sign-Out");
        signOutBtn.setBackground(Background.fill(Color.PEACHPUFF));
        signOutBtn.setOnAction(actionEvent -> MainApp.stage.setScene(MainApp.signUpScreen));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(100);

        gridPane.add(signedUpText, 0, 0);
        gridPane.add(signOutBtn, 0, 1);

        gridPane.setBackground(Background.fill(Color.LIGHTSTEELBLUE));
        return new Scene(gridPane, 750, 500);
    }
}
