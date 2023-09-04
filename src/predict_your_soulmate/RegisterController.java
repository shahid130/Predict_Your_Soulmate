/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predict_your_soulmate;

import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class RegisterController implements Initializable {

    @FXML
    private Button btnReturnFromRegister;
    @FXML
    private TableView<users> table_users;
    @FXML
    private TableColumn<users, Integer> colId;
    @FXML
    private TableColumn<users, String> colName;
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
    
    ObservableList<users> listM;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfReligion;
    @FXML
    private TextField tfDivision;
    @FXML
    private TextField tfProfession;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfId;

    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
    //.........................................................................@@@@@@@@@Fariya
    int checker = 0;
     public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }

    public static boolean isDigit(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
    @FXML
    private Label DivisionLabel;
    @FXML
    private Label NameLabel;
    @FXML
    private Label AgeLabel;
    @FXML
    private Label ReligionLabel;
   // private Label Profession;
    @FXML
    private Label EmailLabel;
    @FXML
    private Label ProfessionLabel;
    //..........................................................................................@@@@@@@@@@@Fariya.
    //new  gender colum add..............................Roshni
    @FXML
    private TableColumn<users, String> colGender;
    @FXML
    private TextField tfGender;
    private TextField getDivision;
    @FXML
    private Label GenderLabel;
    @FXML
    private TableColumn<users, String> colPassword;
    @FXML
    private TextField tfPassword;
    @FXML
    private Label PasswordLabel;
    
    @FXML
    public void handleBtnOfRegister() throws IOException{
        Parent  root  = FXMLLoader.load(getClass().getResource("MainSoulmateDesign.fxml"));
        Stage window = (Stage)btnReturnFromRegister.getScene().getWindow();
        window.setScene(new Scene (root,1236,857));
        window.setTitle("PREDICT YOUR SOULMATE");
        
    }
    @FXML
    public void Add_users() throws ClassNotFoundException, SQLException{
        conn = mySQLConnect.ConnectDb();
        String sql ="insert into users (Name,Gender,Age,Religion,Division,Profession,Email,Password)values(?,?,?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, tfName.getText());
            pst.setString(2, tfGender.getText());
             pst.setString(3, tfAge.getText());
            pst.setString(4, tfReligion.getText());
            pst.setString(5, tfDivision.getText());
            pst.setString(6, tfProfession.getText());
            pst.setString(7, tfEmail.getText());
             pst.setString(8, tfPassword.getText());
            pst.execute();
            
            //JOptionPane.showMessageDialog(null,"Users add success");
            UpdateTable();
            
            
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        //.............................................................................@@@@@@@@@Fariya
        String Name = tfName.getText();
        String Gender = tfGender.getText();
        String Religion = tfReligion.getText();
        String Division = tfDivision.getText();
        String Profession_input = tfProfession.getText();
        String Age = tfAge.getText();
        String Email = tfEmail.getText();
        String Password = tfPassword.getText();
        
        checker = 0;
        if (Profession_input.equals(" ")||Name.equals("") ||Religion.equals("")||Gender.equals("")||Division.equals("")||Age.equals("") || Email.equals("")||Password.equals("")  ) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        }
        
        //Exception
        try {
          
            if (!isAlpha(Name)) {
              NameLabel.setText("Invalid Input");
                checker = 1;
            }else 
            {
                  NameLabel.setText("");
            
            }
             if (!isAlpha(Gender)) {
                GenderLabel.setText("Invalid Input");
                checker = 1;
            }
          else 
            {  
             GenderLabel.setText("");     
            }
            if (!isAlpha(Religion)) {
                ReligionLabel.setText("Invalid Input");
                checker = 1;
            }
          else 
            {  
             ReligionLabel.setText("");     
            }
          if (!isAlpha(Division)) {
                DivisionLabel.setText("Invalid Input");
                checker = 1;
            }
          else 
            {  
             DivisionLabel.setText("");     
            }

            if (!isDigit(Age)) {
               AgeLabel.setText("Invalid Input");
                checker = 1;
            }else
            {
           AgeLabel.setText("");
            
            }
           if (!isAlpha(Profession_input)) {
                ProfessionLabel.setText("Invalid Input");
                checker = 1;
            }
          else 
            { 
 
            ProfessionLabel.setText("");    
 
            }
             if (!validEmail()) {
                EmailLabel.setText("Invalid Input");
                checker = 1;
            }
          else 
            { 
 
            EmailLabel.setText("");    
 
            }



           /* if (checker == 1) {
                throw new Exception();
            } else if (checker == 0) {
                users= new users(Name,Religion,Age,Profession);
                System.out.println(Information);
                DatabaseAction dbAction = new DatabaseAction();
                dbAction.insertDonor(Information);
                Name.clear();
                FatherName.clear();
                MotherName.clear();
                Age.clear();
                Profession.setText("");
                Division.getSelectionModel().clearSelection();
                
            }*/

        } catch (Exception e) {
            System.out.println(e);
        }
        //...................................................@@@@@@@@@@@@@@Fariya.
    
   
    }

   /* @FXML
    private void Edit(ActionEvent event) {
    }

    @FXML
    private void Delete(ActionEvent event) {
    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
    }
      */  
        
    
    
    
    
    
    public void UpdateTable(){
        colId.setCellValueFactory(new PropertyValueFactory<users,Integer>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<users,String>("Name"));
        colGender.setCellValueFactory(new PropertyValueFactory<users,String>("Gender"));
        colAge.setCellValueFactory(new PropertyValueFactory<users,Integer>("Age"));
        colReligion.setCellValueFactory(new PropertyValueFactory<users,String>("Religion"));
        colDivision.setCellValueFactory(new PropertyValueFactory<users,String>("Division")); 
        colProfession.setCellValueFactory(new PropertyValueFactory<users,String>("Profession"));
        colEmail.setCellValueFactory(new PropertyValueFactory<users,String>("Email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<users,String>("Password"));
        
        try {
            listM = mySQLConnect.getDatausers();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        table_users.setItems(listM);
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        
       
    }  
//method for select users.................
    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
         index = table_users.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            return;
        }
        tfId.setText(colId.getCellData(index).toString());
        tfName.setText(colName.getCellData(index));
        tfGender.setText(colGender.getCellData(index));
        tfAge.setText(colAge.getCellData(index).toString());
        tfReligion.setText(colReligion.getCellData(index));
        tfDivision.setText(colDivision.getCellData(index));
        tfProfession.setText(colProfession.getCellData(index));
        tfEmail.setText(colEmail.getCellData(index));
         tfPassword.setText(colPassword.getCellData(index));
    }
    
    
    @FXML
     public void Edit(){
        try{
            conn = mySQLConnect.ConnectDb();
            String value1 = tfId.getText();
            String value2 =tfName.getText();
            String value3 = tfGender.getText();
            String value4 = tfAge.getText();
            String value5= tfReligion.getText();
            String value6= tfDivision.getText();
            String value7= tfProfession.getText();
            String value8 = tfEmail.getText();
            String value9 = tfPassword.getText();
            
            
            String sql = "update users set Id ='"+value1+"',Name ='"+value2+"',Gender='"+value3+"',Age='"+value4+"',Religion ='"+value5+"',Division ='"+value6+"', Profession ='"+value7+"',Email ='"+value8+"',Password='"+value9+"'   where Id='"+value1+"'  ";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
           // JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            
        }catch(HeadlessException | ClassNotFoundException | SQLException e){
              JOptionPane.showMessageDialog(null, e);
        }
    }
     
    @FXML
     public void Delete() throws ClassNotFoundException, SQLException{
         conn = mySQLConnect.ConnectDb();
         String sql = "delete from users where Id=?";
         try{
             pst = conn.prepareStatement(sql);
             pst.setString(1, tfId.getText());
             pst.executeUpdate();
             //JOptionPane.showMessageDialog(null, "Delete");
             UpdateTable();
             
         }catch(HeadlessException | SQLException e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
     //..........................search
     /*public void search_users() throws ClassNotFoundException, SQLException{
             ObservableList<users>  dataList = mySQLConnect.searchUser(getDivision.getText());
             
             
        
        
        table_users.setItems(dataList);
             
     }*/
     
     
     //.........................................@@@Fariya
     private boolean validEmail()
{
Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
Matcher m = p.matcher(tfEmail.getText());
if(m.find() && m.group().equals(tfEmail.getText()))
{

 return true;

} else
  {

    Alert alert = new Alert (AlertType.WARNING);
    alert.setTitle("Validate Email ");
    alert.setHeaderText(null);
    alert.setContentText("Please Enter Email Address");
    alert.showAndWait();

  return false;

  }

}

    @FXML
    private void ResetOnAction(ActionEvent event) {
         
        tfId.setText(" ");
        tfName.setText(" ");
        tfGender.setText(" ");
        tfAge.setText(" ");
        tfReligion.setText(" ");
        tfDivision.setText(" ");
        tfProfession.setText(" ");
        tfEmail.setText(" ");
        tfPassword.setText(" ");
        NameLabel.setText(" ");
        GenderLabel.setText(" ");
        AgeLabel.setText(" ");
        ReligionLabel.setText(" ");
        DivisionLabel.setText(" ");
        ProfessionLabel.setText(" ");
        EmailLabel.setText(" ");
        //PasswordLabel.setText(" ");
         
    }
}

    

