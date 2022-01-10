package FController;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import dbconnection.connecttodb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
//import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Commande;

public class controllercommande implements Initializable {
	@FXML private TableView<Commande> table;
	@FXML private TableColumn<Commande,Integer> idplat;
	@FXML private TableColumn<Commande,String> nplat;
	@FXML private TableColumn<Commande,Float> prix;
	@FXML private TableColumn<Commande,String>tel;
	 @FXML
	    private AnchorPane MenuMain;
	public ObservableList<Commande> data = FXCollections.observableArrayList();
	@FXML
	public void mescommandes() {
		try {
			String sql = "select * from commande";
			Connection con = connecttodb.connect();
			PreparedStatement pstm= con.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			while(rset.next()) {
				data.add(new Commande(rset.getInt(1),rset.getString(2),rset.getFloat(3),rset.getString(4)));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		idplat.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idplat"));
		nplat.setCellValueFactory(new PropertyValueFactory<Commande,String>("nplat"));
		prix.setCellValueFactory(new PropertyValueFactory<Commande,Float>("prix"));
		tel.setCellValueFactory(new PropertyValueFactory<Commande,String>("tel"));
		table.setItems(data);
	}
	
	public void quitter() {
		System.exit(0);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	//
	public void deletecommande() {
		try {
		Stage stage = new Stage();
		stage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("/views/deletecommande.fxml"));
		Scene scene = new Scene(root);
//		MenuMain.getScene().getWindow().hide();
		stage.setScene(scene);
		stage.setTitle("Commande");
		stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
		public void rechercher(ActionEvent event) {
			
		try{
		Stage stage = new Stage();
		stage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("/views/searche.fxml"));
		Scene scene = new Scene(root);
//		MenuMain.getScene().getWindow().hide();
		stage.setScene(scene);
		stage.setTitle("Commande");
		stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
		@FXML public void retourn() {
			try{
				Stage stage = new Stage();
				stage.setResizable(false);
				
				Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
//				MenuMain.getScene().getWindow().hide();
				stage.setTitle("Commande");
				stage.show();
				}catch(Exception e) {
					e.printStackTrace();
				}
		}
}
