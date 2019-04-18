package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luo(Jack) Feng
 */
public class StudentEnrolledController implements Initializable {
    
    @FXML
    private AnchorPane main;
    
    @FXML
    private JFXTreeTableView<StudentEnroll> stuEnrollTreeView;
    
    @FXML
    private JFXButton backBtn;
    
    @FXML
    private JFXButton enrollBtn;
    
    @FXML
    private TextField courseNameTextField;
    
    @FXML
    private TextField sectionTextField;
    
    @FXML
    private TextField resTextField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<StudentEnroll, String> courseCol = new JFXTreeTableColumn<>("Course");
        courseCol.setPrefWidth(150);
        courseCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<StudentEnroll, String> param) -> param.getValue().getValue().course);
        
        JFXTreeTableColumn<StudentEnroll, String> courseNameCol = new JFXTreeTableColumn<>("Course Name");
        courseNameCol.setPrefWidth(150);
        courseNameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<StudentEnroll, String> param) -> param.getValue().getValue().courseName);
        
        JFXTreeTableColumn<StudentEnroll, String> sectionCol = new JFXTreeTableColumn<>("Section");
        sectionCol.setPrefWidth(150);
        sectionCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<StudentEnroll, String> param) -> param.getValue().getValue().section);
        
        JFXTreeTableColumn<StudentEnroll, String> teacherNameCol = new JFXTreeTableColumn<>("Professor");
        teacherNameCol.setPrefWidth(150);
        teacherNameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<StudentEnroll, String> param) -> param.getValue().getValue().teacherName);
        
        ObservableList<StudentEnroll> users = FXCollections.observableArrayList();
        users.add(new StudentEnroll("CS622", "Advance Java Programming", "A", "Dr. John"));
        users.add(new StudentEnroll("CS622", "Advance Java Programming", "B", "Dr. John"));
        users.add(new StudentEnroll("CS622", "Advance Java Programming", "C", "Dr. John"));
        users.add(new StudentEnroll("CS622", "Advance Java Programming", "O1", "Dr. John"));
        users.add(new StudentEnroll("CS767", "Machine Learning", "B", "Dr. Erick"));
        users.add(new StudentEnroll("CS767", "Machine Learning", "C", "Dr. Erick"));
        users.add(new StudentEnroll("CS767", "Machine Learning", "D", "Dr. Erick"));
        
        final TreeItem<StudentEnroll> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);
        stuEnrollTreeView.getColumns().setAll(courseCol, courseNameCol, sectionCol, teacherNameCol);
        stuEnrollTreeView.setRoot(root);
        stuEnrollTreeView.setShowRoot(false);
    }    
    
    class StudentEnroll extends RecursiveTreeObject<StudentEnroll> {
        
        StringProperty course;
        StringProperty courseName;
        StringProperty section;
        StringProperty teacherName;
        
        public StudentEnroll(String course, String courseName, String section, String teacherName) {
            this.course = new SimpleStringProperty(course);
            this.courseName = new SimpleStringProperty(courseName);
            this.section = new SimpleStringProperty(section);
            this.teacherName = new SimpleStringProperty(teacherName);
        }
    }
    
    @FXML
    public void onFinishedEnroll() {
        
        if (courseNameTextField.getText().equals("CS622") && sectionTextField.getText().equals("O1")) {
            enrollBtn.setOnAction((ActionEvent a) -> {
            resTextField.setText("You have enrolled in this course!");
            });
        }
        else if (courseNameTextField.getText().equals("") || sectionTextField.getText().equals("")) {
            resTextField.setText("You need to fill in all the fields! Try Again!");
        }
    }
    
    @FXML
    public void onBackStuMain() {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
    }
}
