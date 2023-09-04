
package predict_your_soulmate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainSoulmateDesignController implements Initializable {

    private ComboBox Division;
    private Button TermsAndConditions;
    private Button About;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLogin;

   
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
         //ObservableList<String>List = FXCollections.observableArrayList("Dhaka","Mymensingh","Rajshahi","Sylhet","Barishal","Chittagong","Rangpur","Dinajpur");
        
        //Division.setItems(List);
    }    


    private void DivisionOnAction(ActionEvent event) {
        
        String s = Division.getSelectionModel().getSelectedItem().toString();   
    }

   

   /* private void RegisterOnAction(ActionEvent event) {
          try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1)); 
              stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("REGISTER");
            stage.show();
            
          }catch(Exception e)
          {
              System.out.println("Can't load new window");  
          }
        
     
    }*/

    

 

    @FXML
    public void handleBtn1() throws IOException{
        Parent  root  = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage window = (Stage)btnRegister.getScene().getWindow();
        window.setScene(new Scene (root,1236,1000));
        window.setTitle("Register");
        
    }

    @FXML
    private void LogInButtonOnAction(ActionEvent event) throws IOException {
        Parent  root  = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Stage window = (Stage)btnLogin.getScene().getWindow();
        window.setScene(new Scene (root,721,729));
        window.setTitle("LogIn");
    }
    
  
        
        
    }
    
    

