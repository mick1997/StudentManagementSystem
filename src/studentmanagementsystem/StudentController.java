/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Callback;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Luo(Jack) Feng
 */
public class StudentController implements Initializable {

    @FXML
    private AnchorPane main;
    
    @FXML
    private JFXTreeTableView<User> stuTreeView;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<User, String> courseCol = new JFXTreeTableColumn<>("Course");
        courseCol.setPrefWidth(150);
        courseCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().course;
            }
        });
        
        JFXTreeTableColumn<User, String> teacherIdCol = new JFXTreeTableColumn<>("Teacher ID");
        teacherIdCol.setPrefWidth(150);
        teacherIdCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().teacherId;
            }
        });
        
        JFXTreeTableColumn<User, String> teacherNameCol = new JFXTreeTableColumn<>("Teacher Name");
        teacherNameCol.setPrefWidth(150);
        teacherNameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().teacherName;
            }
        });
        
        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new User("CS622", "001", "Dr. John"));
        users.add(new User("CS767", "010", "Dr. Erick"));
        
        final TreeItem<User> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);
        stuTreeView.getColumns().setAll(courseCol, teacherIdCol, teacherNameCol);
        stuTreeView.setRoot(root);
        stuTreeView.setShowRoot(false);
    }
    
    class User extends RecursiveTreeObject<User> {
        
        StringProperty course;
        StringProperty teacherId;
        StringProperty teacherName;
        
        public User(String course, String teacherId, String teacherName) {
            this.course = new SimpleStringProperty(course);
            this.teacherId = new SimpleStringProperty(teacherId);
            this.teacherName = new SimpleStringProperty(teacherName);
        }
    }
    
}
