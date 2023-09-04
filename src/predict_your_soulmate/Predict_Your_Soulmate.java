
package predict_your_soulmate;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Predict_Your_Soulmate extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
     
       Parent  root  = FXMLLoader.load(getClass().getResource("MainSoulmateDesign.fxml"));
       
       Scene scr = new Scene(root);
       primaryStage.setTitle("PREDICT YOUR SOULMATE");
       primaryStage.setScene((scr));
       primaryStage.show();
       
       
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
