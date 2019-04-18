package controller;

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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luo(Jack) Feng
 */
public class ProfessorController implements Initializable {

    /***
     * JFXTreeTableView<Professor>: proTreeView
     * JFXButton exitBtn
     */
    
    @FXML
    private JFXTreeTableView<Professor> proTreeView;
    
    @FXML
    private JFXButton exitBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // set JFXTreeTableView<Professor> each column as Student ID, Student Name and Grade
        JFXTreeTableColumn<Professor, String> stdIdCol = new JFXTreeTableColumn<>("Student ID");
        stdIdCol.setPrefWidth(200);
        stdIdCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Professor, String> param) -> param.getValue().getValue().stuId);
        
        JFXTreeTableColumn<Professor, String> stuNameCol = new JFXTreeTableColumn<>("Student Name");
        stuNameCol.setPrefWidth(200);
        stuNameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Professor, String> param) -> param.getValue().getValue().stuName);
        
        JFXTreeTableColumn<Professor, String> gradeCol = new JFXTreeTableColumn<>("Grade");
        gradeCol.setPrefWidth(200);
        gradeCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Professor, String> param) -> param.getValue().getValue().grade);
       
        // use ObservableList to store all the information
        ObservableList<Professor> users = FXCollections.observableArrayList();
        users.add(new Professor("001", "John Franklin", "A"));
        users.add(new Professor("002", "Erick Educade", "B+"));
        users.add(new Professor("003", "Tom Papper", "B"));
        users.add(new Professor("004", "Alice Lee", "A-"));
        users.add(new Professor("005", "Michael Dee", "B-"));
        users.add(new Professor("006", "Jack Song", "B+"));
        users.add(new Professor("007", "Hank Tomsham", "B"));
        users.add(new Professor("008", "Walrd Dalles", "B"));
        
        // set all column to proTreeView
        final TreeItem<Professor> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);
        proTreeView.getColumns().setAll(stdIdCol, stuNameCol, gradeCol);
        proTreeView.setRoot(root);
        proTreeView.setShowRoot(false);
    }    
    
    // Professor nested class
    class Professor extends RecursiveTreeObject<Professor> {
        
        // instance variable: stuId, stuName, grade
        StringProperty stuId;
        StringProperty stuName;
        StringProperty grade;
        
        public Professor(String stuId, String stuName, String grade) {
            this.stuId = new SimpleStringProperty(stuId);
            this.stuName = new SimpleStringProperty(stuName);
            this.grade = new SimpleStringProperty(grade);
        }
    }
    
    /***
     * exit the current window
     */
    @FXML
    public void onExitBtn() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
}
