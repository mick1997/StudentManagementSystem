package studentmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private TextField emailTextField;
    
    @FXML
    private TextField passwordTextfield;
    
    @FXML
    private JFXButton conBTn;    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
