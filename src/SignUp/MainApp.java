package SignUp;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static Stage stage;
    public static Scene signUpScreen;

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        MainApp.stage = stage;
        signUpScreen = createSignUpScene();
        SignedUpScreen.signedUpScreen = SignedUpScreen.createSignedUpScene();
        stage.setScene(signUpScreen);
        stage.setTitle("Sign-Up");
        stage.show();
    }

    public static Scene createSignUpScene() {
        //first name, last name, dob, country, age, phone no, email, password,
        Label[] labels = new Label[] {new Label("First Name"), new Label("Last Name"), new Label("Date of Birth"),
                new Label("Country"), new Label("Age"), new Label("Phone No"), new Label("Email"), new Label("Password")};
        TextField[] textFields = new TextField[labels.length-1];

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(100, 10, 100, 10));
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(50);
        gridPane.setHgap(5);

        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new TextField();
            labels[i].setTextFill(Color.SNOW);
            labels[i].setMinWidth(75);
            labels[i].setAlignment(Pos.CENTER_RIGHT);
            gridPane.add(labels[i], (i+1) % 2 == 0? 10 : 0, i / 2, 5, 1);
            gridPane.add(textFields[i], (i+1) % 2 == 0? 15 : 5, i / 2, 5, 1);
        }
        labels[labels.length-1].setTextFill(Color.SNOW);
        labels[labels.length-1].setMinWidth(75);
        labels[labels.length-1].setAlignment(Pos.CENTER_RIGHT);

        gridPane.add(labels[labels.length-1], 10, (labels.length-1) / 2, 5, 1);
        gridPane.add(new PasswordField(), 15, (labels.length-1) / 2, 5, 1);

        Button signUpBtn = new Button("Sign-Up");
        signUpBtn.setBackground(Background.fill(Color.SKYBLUE));

        Text validationText = new Text("");
        validationText.setFont(new Font(18));
        validationText.setFill(Color.LIGHTSTEELBLUE);

        addEventHandlers(signUpBtn, textFields, labels, validationText);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(signUpBtn);
        vBox.getChildren().add(validationText);

        gridPane.add(vBox, 1, labels.length/2, 15, 1);
        gridPane.setBackground(Background.fill(Color.DARKVIOLET));

        return new Scene(gridPane, 750, 500);
    }

    private static void addEventHandlers(Button sign_up,
                                         TextField[] textFields,
                                         Label[] labels,
                                         Text validationText) {
        sign_up.setOnAction(actionEvent -> {
            for (int i = 0; i < textFields.length; i++)
                if(!validateUserInput(textFields[i], labels[i].getText().toLowerCase(), validationText))
                    return;

            stage.setScene(SignedUpScreen.signedUpScreen);
        });
    }

    static boolean validateUserInput(TextField textFieldToCheck, String labelName, Text validationText){
        validationText.setText("");
        String titleCaseLabelName = labelName.toUpperCase().charAt(0) + labelName.substring(1);

        if(textFieldToCheck == null || textFieldToCheck.getText().equals(""))
            validationText.setText(titleCaseLabelName + " is empty");

        else if((labelName.contains("name") || labelName.contains("country")) && textFieldToCheck.getText().length() < 2)
            validationText.setText(titleCaseLabelName + " must have at least 2 characters");

        else if(labelName.contains("age") && !textFieldToCheck.getText().matches("^[0-9]+$"))
            validationText.setText(titleCaseLabelName + " must only have numbers");

        else if(labelName.contains("age") && textFieldToCheck.getText().compareTo("18") < 0)
            validationText.setText("You must be at least 18 years old to register");

        else if(labelName.contains("phone") && !textFieldToCheck.getText().matches("^[0-9]{4}-[0-9]{7}$"))
            validationText.setText(titleCaseLabelName + " must be of format XXXX-YYYYYYY");

        else if(labelName.contains("email") && !textFieldToCheck.getText()
                .matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+([.][a-zA-Z0-9]{2,3})+$"))
            validationText.setText(titleCaseLabelName + " must be of format abc@def.ghi");

        else if(labelName.contains("date of birth") && !textFieldToCheck.getText()
                .matches("^[0-9]{2}.[0-9]{2}.[0-9]{4}$"))
            validationText.setText(titleCaseLabelName + " must be of DD/MM/YYYY format");

        return validationText.getText().equals("");
    }
}
