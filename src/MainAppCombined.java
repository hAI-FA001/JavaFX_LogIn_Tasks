import ForgotPassword.ResetPasswordScene;
import LogIn.LoggedInScene;
import LogIn.MainApp;
import SignUp.SignedUpScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainAppCombined extends Application {
    static Stage stage;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        MainAppCombined.stage = stage;
        MainApp.stage = stage;
        SignUp.MainApp.stage = stage;
        ForgotPassword.MainApp.stage = stage;

        stage.setScene(initAllScenes());
        stage.show();
    }

    private Scene initAllScenes() {
        LoggedInScene.loggedInScreen = LogIn.LoggedInScene.createLoggedInScene();
        SignedUpScreen.signedUpScreen = SignedUpScreen.createSignedUpScene();
        ResetPasswordScene.resetPasswordScreen = ResetPasswordScene.createResetPasswordScene();

        MainApp.logInScreen = LogIn.MainApp.createLogInScene();
        SignUp.MainApp.signUpScreen = SignUp.MainApp.createSignUpScene();
        ForgotPassword.MainApp.forgotPasswordScreen = ForgotPassword.MainApp.createForgotPasswordScene();

        Button signUpBtn = new Button("Sign-Up");
        signUpBtn.setBackground(Background.fill(Color.TAN));
        signUpBtn.setOnAction(actionEvent -> stage.setScene(SignUp.MainApp.signUpScreen));

        Button forgotPasswordBtn = new Button("Forgot Password?");
        forgotPasswordBtn.setBackground(Background.fill(Color.TAN));
        forgotPasswordBtn.setOnAction(actionEvent -> stage.setScene(ForgotPassword.MainApp.forgotPasswordScreen));

        GridPane logInGridPane = ((GridPane) MainApp.logInScreen.getRoot());
        logInGridPane.add(signUpBtn, 0, logInGridPane.getRowCount(), 3, 1);
        logInGridPane.add(forgotPasswordBtn, 0, logInGridPane.getRowCount(), 3, 1);

        return MainApp.logInScreen;
    }
}
