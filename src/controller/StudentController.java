/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Luo(Jack) Feng
 */
public class StudentController implements Initializable {

    @FXML
    private AnchorPane main;
    
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
        
        ObservableList<Student> users = FXCollections.observableArrayList();
        users.add(new Student("CS622", "001", "Dr. John", "A"));
        users.add(new Student("CS767", "010", "Dr. Erick", "B"));
        users.add(new Student("CS669", "011", "Dr. Tom", "B"));
        users.add(new Student("CS699", "012", "Dr. Lee", "B"));
        
        final TreeItem<Student> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);
        stuTreeView.getColumns().setAll(courseCol, teacherIdCol, teacherNameCol, gradeCol);
        stuTreeView.setRoot(root);
        stuTreeView.setShowRoot(false);
    }
    
    class Student extends RecursiveTreeObject<Student> {
        
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
    
    @FXML
    public void onEnrollBtn() {
        
        enrollBtn.setOnAction((ActionEvent a) -> {
            try {
                Stage primaryStage = new Stage();
                Parent stuMainPage = FXMLLoader.load(StudentController.this.getClass().getResource("/view/StudentEnrolledDashBoard.fxml"));
                Scene scene = new Scene(stuMainPage);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            catch (IOException e) {
            }
        });
    }
    
    @FXML
    public void onExitBtn() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
}