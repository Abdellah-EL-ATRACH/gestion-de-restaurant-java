package FController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
//import java.text.ParseException;

import dbconnection.connecttodb;
//import dbconnection.dbconnectioninfo;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


public class controllerlogin  implements Initializable{
	@FXML private VBox vbox;
	@FXML private Parent fxml;
	@FXML private TextField userf;
	@FXML private TextField passf;
	@FXML private Label lable1;
	@FXML private VBox vbox2;
	@FXML private Parent fxml2;
	@FXML private TextField name;
	@FXML private TextField email;
	@FXML private TextField tel;
	@FXML private TextField username;
	@FXML private TextField password;
	@FXML private Label lable2;
	@FXML
    private AnchorPane Main;
	@FXML 
	public void singin(ActionEvent event)  throws SQLException{
		Connection con = connecttodb.connect();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String sql = "select * from client where username=? and password=?";
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1,userf.getText().toString());
			pstm.setString(2,passf.getText().toString());
			rset = pstm.executeQuery();
			if(rset.next()) {
				Stage stage = new Stage();
				stage.setResizable(false);
				lable1.setText("connecter");
				Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
				Scene scene = new Scene(root);
				Main.getScene().getWindow().hide();
				stage.setScene(scene);
				stage.setTitle("Menu");
				stage.show();
				
			}else {
				lable1.setText("password or username invalide !");
			}
		}catch(Exception e) {
			
		}
	} 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TranslateTransition t = new TranslateTransition(Duration.seconds(1),vbox);
		t.setToX(vbox.getLayoutX() * 600);
		t.play();
		t.setOnFinished((e)->
		{
			try {
				
				   fxml=FXMLLoader.load(getClass().getResource("/view/singupp.fxml"));
				   vbox.getChildren().removeAll();
				   vbox.getChildren().setAll(fxml);
				
			}catch(IOException ex) {
				
			}
		});
	}
	
	@FXML public void open_singup (ActionEvent  event)
	{
	
		TranslateTransition t = new TranslateTransition(Duration.seconds(1),vbox);
		t.setToX(0);
		t.play();
		t.setOnFinished((e)->
		{
				try {
					   fxml=FXMLLoader.load(getClass().getResource("/view/singupp.fxml"));
					   vbox.getChildren().removeAll();
					   vbox.getChildren().setAll(fxml);
					
				}catch(IOException ex) {
					
				}	
		});	
	}
	
	
	public  void getclient(ActionEvent event) throws SQLException {
		Connection con=connecttodb.connect();
		String nom=name.getText().toString();
		String em =email.getText().toString();
		String tl=tel.getText().toString();
		String user= username.getText().toString();
		String pass=password.getText().toString();
		
		if(!nom.equals("") && !em.equals("") && !user.equals("") && !tl.equals("")) {
			try {			
				String sql="insert into client values (?,?,?,?,?)";
				PreparedStatement pstm=con.prepareStatement(sql);
				pstm.setString(1,nom);
				pstm.setString(2,em);
				pstm.setString(3,user);
				pstm.setString(4,pass);
				pstm.setString(5,tl);
				ResultSet rset = pstm.executeQuery();
				if(rset.next()) {
					lable2.setText("Successful !");
					
				}
				con.close();
			}				
			catch(Exception e) {
				e.printStackTrace();
			}	
		}else {
				lable2.setText("Veuillez remplir tout les champs ! ");//.textProperty("-fx-color: red;");
		}
		

	}
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		// TODO Auto-generated method stub
//		
//	}
}
/**/
