package studentmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author Luo(Jack) Feng
 */
public class LoginFormController implements Initializable {
    
    @FXML
    private JFXRadioButton stuCheckBox;
    
    @FXML
    private JFXRadioButton proCheckBox;
    
    @FXML
    private ToggleGroup loginType;
    
    @FXML
    private TextField emailTextField;
    
    @FXML
    private TextField passwordTextfield;
    
    @FXML
    private JFXButton conBTn;
    
    public static Student student;
    public static Professor professor;
    
    public void onClickSignin(ActionEvent a) {
        
        try {
            if ("Student".equals(((JFXRadioButton) loginType.getSelectedToggle()).getText())) {
                
            }
            else if ("Professor".equals(((JFXRadioButton) loginType.getSelectedToggle()).getText())) {
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBtnContinue(ActionEvent e) throws Exception {
        
        if (emailTextField.getText().equals("Student") && passwordTextfield.getText().equals("123")) {
            Stage primaryStage = new Stage();
            Parent loginFace = FXMLLoader.load(getClass().getResource("/StudentManagementSystem/StudentDashBoard.fxml"));
            Scene scene = new Scene(loginFace, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
//            Stage app = (Stage)((Node) e.getSource()).getScene().getWindow();
//            app.setScene(new Scene(loginFace));
//            app.show();
        }
        else if (emailTextField.getText().equals("Professor") && passwordTextfield.getText().equals("456")) {
            System.out.println("hello");
            Stage primaryStage = new Stage();
            Parent loginFace = FXMLLoader.load(getClass().getResource("/StudentManagementSystem/ProfessorDashBoard.fxml"));
            Scene scene = new Scene(loginFace, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
