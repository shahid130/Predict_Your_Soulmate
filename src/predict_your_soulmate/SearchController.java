/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predict_your_soulmate;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SearchController implements Initializable {

    @FXML
    private ComboBox<String> Division;
    @FXML
    private Button searchReturn;
    @FXML
    private TableView<users> table_users;
    @FXML
    private TableColumn<users, Integer> colId;
    @FXML
    private TableColumn<users, String> colName;
    @FXML
    private TableColumn<users, String> colGender;
    @FXML
    private TableColumn<users, Integer> colAge;
    @FXML
    private TableColumn<users, String> colReligion;
    @FXML
    private TableColumn<users, String> colDivision;
    @FXML
    private TableColumn<users, String> colProfession;
    @FXML
    private TableColumn<users, String> colEmail;
    @FXML
    private Button btnSearch;
    ObservableList<users> listM;
    @FXML
    private ComboBox<String> GenderSelection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String>List = FXCollections.observableArrayList("Dhaka","Mymensingh","Rajshahi","Sylhet","Barishal","Chittagong","Rangpur","Dinajpur");
            
        Division.setItems(List);
        
       ObservableList<String>ListG = FXCollections.observableArrayList("Male","Female");
            
        GenderSelection.setItems(ListG);
        
        
        //...........................................
       /* colId.setCellValueFactory(new PropertyValueFactory<users,Integer>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<users,String>("Name"));
        colGender.setCellValueFactory(new PropertyValueFactory<users,String>("Gender"));
        colAge.setCellValueFactory(new PropertyValueFactory<users,Integer>("Age"));
        colReligion.setCellValueFactory(new PropertyValueFactory<users,String>("Religion"));
        colDivision.setCellValueFactory(new PropertyValueFactory<users,String>("Division")); 
        colProfession.setCellValueFactory(new PropertyValueFactory<users,String>("Profession"));
        colEmail.setCellValueFactory(new PropertyValueFactory<users,String>("Email"));
        
        try {
            listM = mySQLConnect.getDatausers();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        table_users.setItems(listM);*/
    }    

    @FXML
    private void DivisionOnAction(ActionEvent event) {
    }
    
    
    
    @FXML
   public void search_users() throws ClassNotFoundException, SQLException{
             ObservableList<users>  dataList = mySQLConnect.searchUser(Division.getValue(),GenderSelection.getValue());
             
             
        colId.setCellValueFactory(new PropertyValueFactory<users,Integer>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<users,String>("Name"));
        colGender.setCellValueFactory(new PropertyValueFactory<users,String>("Gender"));
        colAge.setCellValueFactory(new PropertyValueFactory<users,Integer>("Age"));
        colReligion.setCellValueFactory(new PropertyValueFactory<users,String>("Religion"));
        colDivision.setCellValueFactory(new PropertyValueFactory<users,String>("Division")); 
        colProfession.setCellValueFactory(new PropertyValueFactory<users,String>("Profession"));
        colEmail.setCellValueFactory(new PropertyValueFactory<users,String>("Email"));
        
        table_users.setItems(dataList);
   }
   
    @FXML
    private void searchReturnOnAction(ActionEvent event) throws IOException {
         Parent  root  = FXMLLoader.load(getClass().getResource("SecondPage.fxml"));
                  Stage window = (Stage)searchReturn.getScene().getWindow();
                  window.setScene(new Scene (root,1005,737));
                  window.setTitle("LogIn");
    }

    @FXML
    private void getSelected(MouseEvent event) {
    }

    @FXML
    private void GenderSelectionOnAction(ActionEvent event) {
    }
    
}
