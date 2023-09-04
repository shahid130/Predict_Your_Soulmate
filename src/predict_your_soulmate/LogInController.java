/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predict_your_soulmate;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LogInController implements Initializable {

    @FXML
    private Button btn_login;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TextField tfInputEmail;
    @FXML
    private PasswordField tfInputPassword;
    @FXML
    private Button btnReturn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogIn(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        conn = mySQLConnect.ConnectDb();
         String sql = "Select*  from users where Email=? and Password =?";
         try{
             pst = conn.prepareStatement(sql);
             pst.setString(1, tfInputEmail.getText());
             pst.setString(2, tfInputPassword.getText());
             rs =  pst.executeQuery();
            if(rs.next())
            {
                  Parent  root  = FXMLLoader.load(getClass().getResource("SecondPage.fxml"));
                  Stage window = (Stage)btn_login.getScene().getWindow();
                  window.setScene(new Scene (root,1005,737));
                  window.setTitle("LogIn");
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Email or Password");
            }
             
         }catch(HeadlessException | SQLException e){
             JOptionPane.showMessageDialog(null, e);
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
    
}
