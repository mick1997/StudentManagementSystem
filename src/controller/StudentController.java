package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Luo(Jack) Feng
 */
public class StudentController implements Initializable {

    /*****
     * JFXTreeTableView<Student>: stuTreeView
     * JFXButton: enrollBtn, exitBtn
     */
    
    @FXML
    private JFXTreeTableView<Student> stuTreeView;
    
    @FXML
    private JFXButton enrollBtn;
    
    @FXML
    private JFXButton exitBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // set JFXTreeTableView<Student> each column as Course, Teacher ID, Teacher Name, Grade
        JFXTreeTableColumn<Student, String> courseCol = new JFXTreeTableColumn<>("Course");
        courseCol.setPrefWidth(150);
        courseCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Student, String> param) -> param.getValue().getValue().course);
        
        JFXTreeTableColumn<Student, String> teacherIdCol = new JFXTreeTableColumn<>("Teacher ID");
        teacherIdCol.setPrefWidth(150);
        teacherIdCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Student, String> param) -> param.getValue().getValue().teacherId);
        
        JFXTreeTableColumn<Student, String> teacherNameCol = new JFXTreeTableColumn<>("Teacher Name");
        teacherNameCol.setPrefWidth(150);
        teacherNameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Student, String> param) -> param.getValue().getValue().teacherName);
        
        JFXTreeTableColumn<Student, String> gradeCol = new JFXTreeTableColumn<>("Grade");
        gradeCol.setPrefWidth(150);
        gradeCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Student, String> param) -> param.getValue().getValue().grade);
        
        // use ObservableList to store all the information
        ObservableList<Student> users = FXCollections.observableArrayList();
        users.add(new Student("CS622", "001", "Dr. John", "A"));
        users.add(new Student("CS767", "010", "Dr. Erick", "B"));
        users.add(new Student("CS669", "011", "Dr. Tom", "B"));
        users.add(new Student("CS699", "012", "Dr. Lee", "B"));
        
        // set all column to stuTreeView
        final TreeItem<Student> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);
        stuTreeView.getColumns().setAll(courseCol, teacherIdCol, teacherNameCol, gradeCol);
        stuTreeView.setRoot(root);
        stuTreeView.setShowRoot(false);
    }
    
    // Student nested class
    class Student extends RecursiveTreeObject<Student> {
        
        // instance variable: course, teacherId, teacherName, grade
        StringProperty course;
        StringProperty teacherId;
        StringProperty teacherName;
        StringProperty grade;
        
        public Student(String course, String teacherId, String teacherName, String grade) {
            this.course = new SimpleStringProperty(course);
            this.teacherId = new SimpleStringProperty(teacherId);
            this.teacherName = new SimpleStringProperty(teacherName);
            this.grade = new SimpleStringProperty(grade);
        }
    }
    
    /**
     * change the stage to enroll window
     */
    @FXML
    public void onEnrollBtn() {
        
        enrollBtn.setOnAction((ActionEvent a) -> {
            try {
                Stage primaryStage = new Stage();
                Parent stuMainPage = FXMLLoader.load(StudentController.this.getClass().getResource("/view/StudentEnrolledDashBoard.fxml"));
                Scene scene = new Scene(stuMainPage);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Student Enroll Link");
                primaryStage.show();
            }
            catch (IOException e) {
            }
        });
    }
    
    /**
     * exit the current window
     */
    @FXML
    public void onExitBtn() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
}
