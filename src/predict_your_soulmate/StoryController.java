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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StoryController implements Initializable {

    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn1;
    @FXML
    private Text RoseAndJackStory;
    @FXML
    private Text RajAndFihi;
    @FXML
    private Text FoysAndRimu;
    @FXML
    private Button btnStoryBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn2OnAction(ActionEvent event) {
        
          RoseAndJackStory.setVisible(true);
          
          FoysAndRimu.setVisible(false);
          RajAndFihi.setVisible(false);
          
         
    }

    @FXML
    private void btn3OnAction(ActionEvent event) {
        FoysAndRimu.setVisible(true);
        
        RoseAndJackStory.setVisible(false);
        RajAndFihi.setVisible(false);
        
         
    }

    @FXML
    private void btn1OnAction(ActionEvent event) {
          RajAndFihi.setVisible(true);
          
          RoseAndJackStory.setVisible(false);
           FoysAndRimu.setVisible(false);
          
       
    }

    @FXML
    private void btnStoryBackOnAction(ActionEvent event) throws IOException {
        Parent  root  = FXMLLoader.load(getClass().getResource("SecondPage.fxml"));
         Stage window = (Stage)btnStoryBack.getScene().getWindow();
          window.setScene(new Scene (root,1005,737));
          window.setTitle("LogIn");
    }
    
}
