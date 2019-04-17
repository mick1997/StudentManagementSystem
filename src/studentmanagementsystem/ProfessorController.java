/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Luo(Jack) Feng
 */
public class ProfessorController implements Initializable {

    
    @FXML
    private AnchorPane main;
    
    @FXML
    private JFXTreeTableView<Professor> proTreeView;
    
    @FXML
    private JFXButton exitBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        JFXTreeTableColumn<Professor, String> stdIdCol = new JFXTreeTableColumn<>("Student ID");
        stdIdCol.setPrefWidth(150);
        stdIdCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Professor, String> param) -> param.getValue().getValue().stuId);
        
        JFXTreeTableColumn<Professor, String> stuNameCol = new JFXTreeTableColumn<>("Student Name");
        stuNameCol.setPrefWidth(150);
        stuNameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Professor, String> param) -> param.getValue().getValue().stuName);
        
        JFXTreeTableColumn<Professor, String> gradeCol = new JFXTreeTableColumn<>("Grade");
        gradeCol.setPrefWidth(150);
        gradeCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Professor, String> param) -> param.getValue().getValue().grade);
       
        ObservableList<Professor> users = FXCollections.observableArrayList();
        users.add(new Professor("001", "John", "A"));
        users.add(new Professor("002", "Erick", "B"));
        
        final TreeItem<Professor> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);
        proTreeView.getColumns().setAll(stdIdCol, stuNameCol, gradeCol);
        proTreeView.setRoot(root);
        proTreeView.setShowRoot(false);
    }    
    
    class Professor extends RecursiveTreeObject<Professor> {
        
        StringProperty stuId;
        StringProperty stuName;
        StringProperty grade;
        
        public Professor(String stuId, String stuName, String grade) {
            this.stuId = new SimpleStringProperty(stuId);
            this.stuName = new SimpleStringProperty(stuName);
            this.grade = new SimpleStringProperty(grade);
        }
    }
    
    @FXML
    public void onExitBtn() {
        
        exitBtn.setOnAction((ActionEvent a) -> { System.exit(0);});
    }
}
