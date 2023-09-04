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
public class SecondPageController implements Initializable {

    @FXML
    private Button TermsAndConditions;
    @FXML
    private Button Search;
    @FXML
    private Button About;
    @FXML
    private Button btnReturn;
    @FXML
    private Button AboutUs;
    @FXML
    private Button Story;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void TermsAndConditionsOnAction(ActionEvent event) {
          try {
          Parent  root  = FXMLLoader.load(getClass().getResource("TermsAndConditions.fxml"));
         Stage window = (Stage)TermsAndConditions.getScene().getWindow();
         window.setScene(new Scene (root,1204,898));
         window.setTitle("Terms And Conditions");
            
          }catch(IOException e)
          {
              System.out.println("Can't load new window");  
          }
    }

    @FXML
    private void SearchOnAction(ActionEvent event) {
          try {
           Parent  root  = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Stage window = (Stage)Search.getScene().getWindow();
        window.setScene(new Scene (root,1095,800));
        window.setTitle("Search");
            
          }catch(IOException e)
          {
              System.out.println("Can't load new window"+e);  
          }
    }

    @FXML
    private void AboutOnAction(ActionEvent event) {
        
        try {
           Parent  root  = FXMLLoader.load(getClass().getResource("About.fxml"));
        Stage window = (Stage)About.getScene().getWindow();
        window.setScene(new Scene (root,1095,764));
        window.setTitle("About");
            
          }catch(IOException e)
          {
              System.out.println("Can't load new window");  
          }
    }

    @FXML
    private void ReturnToHomePage(ActionEvent event) {
         try {
           Parent  root  = FXMLLoader.load(getClass().getResource("MainSoulmateDesign.fxml"));
        Stage window = (Stage)btnReturn.getScene().getWindow();
        window.setScene(new Scene (root,1236,857));
        window.setTitle("PREDICT YOUR SOULMATE");
            
          }catch(IOException e)
          {
              System.out.println("Can't load new window");  
          }
    }

    @FXML
    private void AboutUsOnAction(ActionEvent event) {
        try {
           Parent  root  = FXMLLoader.load(getClass().getResource("ABOUT_US_FINAL.fxml"));
        Stage window = (Stage)AboutUs.getScene().getWindow();
        window.setScene(new Scene (root,988,664));
        window.setTitle("About Us");
            
          }catch(IOException e)
          {
              System.out.println("Can't load new window"+e);  
          }
        
    }

    @FXML
    private void StoryOnAction(ActionEvent event) {
          try {
           Parent  root  = FXMLLoader.load(getClass().getResource("Story.fxml"));
        Stage window = (Stage)Story.getScene().getWindow();
        window.setScene(new Scene (root,1208,769));
        window.setTitle("Story");
            
          }catch(IOException e)
          {
              System.out.println("Can't load new window"+e);  
          }
    }
    
}
