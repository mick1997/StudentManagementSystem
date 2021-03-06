package controller;

import com.jfoenix.controls.JFXCheckBox;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Luo(Jack) Feng
 */
public class LoginFormController implements Initializable {
    
    /***
     * TextField: emailTextField, resField, stuUserId, stuEmail, stuResField, 
     *            proUserId, proEmail, proCourse, proResField
     * PasswordField: passwordTextfield, stuPassword, stuPasswordAgain, 
     *                proPassword, proPasswordAgain
     * JFXCheckBox: rememberMeCheckBox
     * Preferences: preferences
     */
    @FXML
    private TextField emailTextField;
    
    @FXML
    private PasswordField passwordTextfield;
    
    @FXML
    private TextField resField;
    
    @FXML
    private TextField stuUserId;
    
    @FXML
    private TextField stuEmail;
    
    @FXML
    private PasswordField stuPassword;
    
    @FXML
    private PasswordField stuPasswordAgain;
    
    @FXML
    private TextField stuResField;
    
    @FXML
    private TextField proUserId;
    
    @FXML
    private TextField proEmail;
    
    @FXML
    private PasswordField proPassword;
    
    @FXML
    private PasswordField proPasswordAgain;
    
    @FXML
    private TextField proCourse;
    
    @FXML
    private TextField proResField;
    
    @FXML
    private JFXCheckBox rememberMeCheckBox;
    
    Preferences preferences;
    
    /***
     * @param e
     * @throws Exception
     * check email and password for entering to account
     */
    @FXML
    public void onBtnContinue(ActionEvent e) throws Exception {
        
        if (emailTextField.getText().equals("Student@bu.edu") && passwordTextfield.getText().equals("123")) {
            rememberMe();
            Stage primaryStage = new Stage();
            Parent loginFace = FXMLLoader.load(getClass().getResource("/view/StudentDashBoard.fxml"));
            Scene scene = new Scene(loginFace);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Student Link");
            primaryStage.show();
        }
        else if (emailTextField.getText().equals("Professor@bu.edu") && passwordTextfield.getText().equals("456")) {
            rememberMe();
            Stage primaryStage = new Stage();
            Parent loginFace = FXMLLoader.load(getClass().getResource("/view/ProfessorDashBoard.fxml"));
            Scene scene = new Scene(loginFace);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Professor Link");
            primaryStage.show();
        }
        else {
            resField.setText("You have entered wrong User ID and password!!!");
        }
    }
    
    /***
     * remember email and password for next time use
     */
    public void rememberMe() {
        if (rememberMeCheckBox.isSelected()) {
                preferences.put("emailTextField", emailTextField.getText());
                preferences.put("passwordTextfield", passwordTextfield.getText());
            }
            else {
                preferences.put("emailTextField", "");
                preferences.put("passwordTextfield", "");
            }
    }
    
    /****
     * @param e
     * @throws Exception
     * registration for Student account
     */
    @FXML
    public void onStuRegisterBtn(ActionEvent e) throws Exception {
        
        if (stuUserId.getText().equals("Tom") && stuEmail.getText().equals("tom@bu.edu") 
                && stuPassword.getText().equals("12345") && stuPasswordAgain.getText().equals("12345")) {
            stuResField.setText("You have registered for the account!");
        }
        else if (stuUserId.getText().equals("") || stuEmail.getText().equals("") 
                || stuPassword.getText().equals("") || stuPasswordAgain.getText().equals("")) {
            stuResField.setText("You need to fill in all the fields! Try Again!");
        }
    }
    
    /***
     * @param e
     * @throws Exception
     * registration for Professor account
     */
    @FXML
    public void onProRegisterBtn(ActionEvent e) throws Exception {
        
        if (proUserId.getText().equals("John") && proEmail.getText().equals("john@bu.edu") 
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // preferences for using userNodeForPackage with LoginFormController.class
        preferences = Preferences.userNodeForPackage(LoginFormController.class);
        
        // make sure the preferences get emailTextField is not null and empty
        if (preferences != null) {
            if (preferences.get("emailTextField", null) != null && !preferences.get("emailTextField", null).isEmpty()) {
                emailTextField.setText(preferences.get("emailTextField", null));
                passwordTextfield.setText(preferences.get("passwordTextfield", null));
            }
        }
    }
}
