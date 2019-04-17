package studentmanagementsystem;

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
    private TextField resTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<StudentEnroll, String> courseCol = new JFXTreeTableColumn<>("Course");
        courseCol.setPrefWidth(150);
        courseCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<StudentEnroll, String> param) -> param.getValue().getValue().course);
        
        JFXTreeTableColumn<StudentEnroll, String> teacherIdCol = new JFXTreeTableColumn<>("Teacher ID");
        teacherIdCol.setPrefWidth(150);
        teacherIdCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<StudentEnroll, String> param) -> param.getValue().getValue().teacherId);
        
        JFXTreeTableColumn<StudentEnroll, String> teacherNameCol = new JFXTreeTableColumn<>("Teacher Name");
        teacherNameCol.setPrefWidth(150);
        teacherNameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<StudentEnroll, String> param) -> param.getValue().getValue().teacherName);
        
        ObservableList<StudentEnroll> users = FXCollections.observableArrayList();
        users.add(new StudentEnroll("CS622", "001", "Dr. John"));
        users.add(new StudentEnroll("CS767", "010", "Dr. Erick"));
        
        final TreeItem<StudentEnroll> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);
        stuEnrollTreeView.getColumns().setAll(courseCol, teacherIdCol, teacherNameCol);
        stuEnrollTreeView.setRoot(root);
        stuEnrollTreeView.setShowRoot(false);
    }    
    
    class StudentEnroll extends RecursiveTreeObject<StudentEnroll> {
        
        StringProperty course;
        StringProperty teacherId;
        StringProperty teacherName;
        
        public StudentEnroll(String course, String teacherId, String teacherName) {
            this.course = new SimpleStringProperty(course);
            this.teacherId = new SimpleStringProperty(teacherId);
            this.teacherName = new SimpleStringProperty(teacherName);
        }
    }
    
    @FXML
    public void onFinishedEnroll() {
        
        enrollBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent a) {
                resTextField.setText("You have enrolled in this course!");
            }
        });
    }
    
    @FXML
    public void onBackStuMain() {
    
        backBtn.setOnAction((ActionEvent a) -> {
            try {
                Stage primaryStage = new Stage();
                Parent stuMainPage = FXMLLoader.load(StudentEnrolledController.this.getClass().getResource("/StudentManagementSystem/StudentDashBoard.fxml"));
                Scene scene = new Scene(stuMainPage, 400, 400);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
