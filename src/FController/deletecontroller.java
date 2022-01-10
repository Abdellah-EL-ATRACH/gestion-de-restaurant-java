package FController;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbconnection.connecttodb;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import models.Commande;


public class deletecontroller implements Initializable  {
	@FXML private TextField idE;
	@FXML private Label lable;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	 @FXML
	 public void deletecommande() {
		 String serche=idE.getText();
		 try {
			 String sql="delete from commande where idplat="+serche+"";
			 Connection con = connecttodb.connect();
			 PreparedStatement pstm = con.prepareStatement(sql);
				pstm.executeUpdate();
				lable.setText("votre commande est supprimer !");
				con.close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 @FXML 
	 public void retourn() {
//		 try {
//				Stage stage = new Stage();
//				stage.setResizable(false);
//				Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
//				Scene scene = new Scene(root);
//				MenuMain.getScene().getWindow().hide();
//				stage.setScene(scene);
//				stage.setTitle("Menu");
//				stage.show();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
	 }
	 
//		try {
//			//String sqln = "insert into commande (id_plat,n_plat,prix,tel) select id_plat,n_plat,prix,tel from client cl,commande cm,plat pl where cm.tel=cl.tel and cm.id_plat=pl.id_plat";
//			String sql="INSERT INTO COMMANDE (idplat,nplat,prix,tel) SELECT id_plat,n_plat,prix,id_image FROM plat where id_plat=2";
//			PreparedStatement pstm = con.prepareStatement(sql);
//			pstm.executeUpdate();
//
//			Alert alert= new Alert(AlertType.INFORMATION);
//			//alert.setHeaderText("commande");
//			alert.setTitle("commander");
//			alert.setContentText("Plat bien ajouter !");
//			alert.show(); 		
//			con.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//			Alert alert= new Alert(AlertType.INFORMATION);
//			alert.setHeaderText("Plat");
//			alert.setTitle("commander");
//			alert.setContentText("Plat bien ajouter !");
//			alert.show();
//		}
//	}
	
}
