/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predict_your_soulmate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TermsAndConditionsController implements Initializable {

    @FXML
    private Button tncReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void termsandconditionsOnAction(ActionEvent event) throws IOException {
         Parent  root  = FXMLLoader.load(getClass().getResource("SecondPage.fxml"));
                  Stage window = (Stage)tncReturn.getScene().getWindow();
                  window.setScene(new Scene (root,1005,737));
                  window.setTitle("LogIn");
       
        
    }
    
}
