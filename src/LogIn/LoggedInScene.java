package LogIn;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoggedInScene {
    public static Scene loggedInScreen;

    public static Scene createLoggedInScene(){
        Text welcomeText = new Text("Welcome, " + CommonData.username + "!");
        welcomeText.setFont(new Font(40));
        welcomeText.setFill(Color.DARKSEAGREEN);

        Button log_Out = new Button("Log-Out");
        log_Out.setBackground(Background.fill(Color.DARKORANGE));
        log_Out.setOnAction(actionEvent -> {
            MainApp.stage.setScene(MainApp.logInScreen);
        });

        GridPane gridPane = new GridPane();
        gridPane.setBackground(Background.fill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.POWDERBLUE), new Stop(1, Color.MEDIUMSPRINGGREEN))));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(welcomeText, 0, 0);
        gridPane.add(log_Out, 0, 1);

        return new Scene(gridPane, 750, 500);
    }
}
