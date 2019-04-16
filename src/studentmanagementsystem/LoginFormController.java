package studentmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author Luo(Jack) Feng
 */
public class LoginFormController {
    
    @FXML
    private TextField emailTextField;
    
    @FXML
    private TextField passwordTextfield;
    
    @FXML
    private TextField resField;
    
    @FXML
    private TextField stuUserId;
    
    @FXML
    private TextField stuEmail;
    
    @FXML
    private TextField stuPassword;
    
    @FXML
    private TextField stuPasswordAgain;
    
    @FXML
    private TextField stuResField;
    
    @FXML
    private TextField proUserId;
    
    @FXML
    private TextField proEmail;
    
    @FXML
    private TextField proPassword;
    
    @FXML
    private TextField proPasswordAgain;
    
    @FXML
    private TextField proCourse;
    
    @FXML
    private TextField proResField;
    
    public static Student student;
    public static Professor professor;
    
    public void onBtnContinue(ActionEvent e) throws Exception {
        
        if (emailTextField.getText().equals("Student") && passwordTextfield.getText().equals("123")) {
            Stage primaryStage = new Stage();
            Parent loginFace = FXMLLoader.load(getClass().getResource("/StudentManagementSystem/StudentDashBoard.fxml"));
            Scene scene = new Scene(loginFace, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else if (emailTextField.getText().equals("Professor") && passwordTextfield.getText().equals("456")) {
            Stage primaryStage = new Stage();
            Parent loginFace = FXMLLoader.load(getClass().getResource("/StudentManagementSystem/ProfessorDashBoard.fxml"));
            Scene scene = new Scene(loginFace, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else {
            resField.setText("You have entered wrong User ID and password!!!");
        }
    }
    
    public void onStuRegisterBtn(ActionEvent e) throws Exception {
        if (stuUserId.getText().equals("Tom") && stuEmail.getText().equals("tom@bu.com") 
                && stuPassword.getText().equals("12345") && stuPasswordAgain.getText().equals("12345")) {
            stuResField.setText("You have registered for the account!");
        }
        else if (stuUserId.getText().equals("") || stuEmail.getText().equals("") 
                || stuPassword.getText().equals("") || stuPasswordAgain.getText().equals("")) {
            stuResField.setText("You need to fill in all the fields! Try Again!");
        }
    }
    
    public void onProRegisterBtn(ActionEvent e) throws Exception {
        if (proUserId.getText().equals("John") && proEmail.getText().equals("john@bu.com") 
                && proPassword.getText().equals("6789") && proPasswordAgain.getText().equals("6789") 
                && proCourse.getText().equals("CS622")) {
            proResField.setText("You have registered for the account!");
        }
        else if (proUserId.getText().equals("") || proEmail.getText().equals("") 
                || proPassword.getText().equals("") || proPasswordAgain.getText().equals("")
                || proCourse.getText().equals("")) {
            proResField.setText("You need to fill in all the fields! Try Again!");
        }
    }
}
