package FController;

//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;
import main.MyListener;
//import model.Commande;
import models.Plats;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dbconnection.connecttodb;

public class MenuController implements Initializable {
	@FXML 
	 private AnchorPane MenuMain;
    @FXML
    private VBox chosenPlatsCard;

    @FXML
    private GridPane grid;

    @FXML
    private ImageView platImg;

    @FXML
    private Label platNameLable;

    @FXML
    private Label platPriceLabel;

    @FXML
    private ScrollPane scroll;

    private List<Plats> plats = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    private List<Plats> getData() {
        List<Plats> plats = new ArrayList<>();
        Plats plat;

        plat = new Plats();
        plat.setName("Poulet");
        plat.setPrice(150);
        plat.setImgSrc("/img/poulet.png");
        plat.setColor("80080C");
        plats.add(plat);

        plat = new Plats();
        plat.setName("Tajine");
        plat.setPrice(100);
        plat.setImgSrc("/img/tajine.png");
        plat.setColor("A7745B");
        plats.add(plat);

        plat = new Plats();
        plat.setName("Crevette");
        plat.setPrice(200);
        plat.setImgSrc("/img/crevette2.png");
        plat.setColor("F16C31");
        plats.add(plat);

        plat = new Plats();
        plat.setName("salade");
        plat.setPrice(50);
        plat.setImgSrc("/img/salade.png");
        plat.setColor("291D36");
        plats.add(plat);

        plat = new Plats();
        plat.setName("Pizza");
        plat.setPrice(50);
        plat.setImgSrc("/img/pizza2.png");
        plat.setColor("FB5D03");
        plats.add(plat);

        plat = new Plats();
        plat.setName("Burger");
        plat.setPrice(100);
        plat.setImgSrc("/img/burger.png");
        plat.setColor("22371D");
        plats.add(plat);

        plat = new Plats();
        plat.setName("Coucous");
        plat.setPrice(100);
        plat.setImgSrc("/img/couscous (3).png");
        plat.setColor("FF4500");
        plats.add(plat);

        plat = new Plats();
        plat.setName("Thé");
        plat.setPrice(20);
        plat.setImgSrc("/img/thé.png");
        plat.setColor("E7C00F");
        plats.add(plat);

        plat = new Plats();
        plat.setName("Café");
        plat.setPrice(30);
        plat.setImgSrc("/img/café.png");
        plat.setColor("5F060E");
        plats.add(plat);

        plat = new Plats();
        plat.setName("Jus");
        plat.setPrice(30);
        plat.setImgSrc("/img/jus.png");
        plat.setColor("FFB605");
        plats.add(plat);

        return plats;
    }

    private void chosenPlats(Plats plat) {
        platNameLable.setText(plat.getName());
    	platPriceLabel.setText(plat.getPrice()+Main.CURRENCY);
        image = new Image(getClass().getResourceAsStream(plat.getImgSrc()));
        platImg.setImage(image);
        chosenPlatsCard.setStyle("-fx-background-color: #" + plat.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        plats.addAll(getData());
        if (plats.size() > 0) {
        	chosenPlats(plats.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Plats plat) {
                	chosenPlats(plat);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < plats.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(plats.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void commandelist() {
		try{
		Stage stage = new Stage();
		stage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("/views/Comm.fxml"));
		Scene scene = new Scene(root);
		MenuMain.getScene().getWindow().hide();
		stage.setScene(scene);
		stage.setTitle("Commande");
		stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ajouter () {
		Connection con = connecttodb.connect();
		try {
			//String sqln = "insert into commande (id_plat,n_plat,prix,tel) select id_plat,n_plat,prix,tel from client cl,commande cm,plat pl where cm.tel=cl.tel and cm.id_plat=pl.id_plat";
			String sql="INSERT INTO COMMANDE (idplat,nplat,prix,tel) SELECT id_plat,n_plat,prix,id_image FROM plat where id_plat=2";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.executeUpdate();

			Alert alert= new Alert(AlertType.INFORMATION);
			//alert.setHeaderText("commande");
			alert.setTitle("commander");
			alert.setContentText("Plat bien ajouter !");
			alert.show(); 		
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			Alert alert= new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Plat");
			alert.setTitle("commander");
			alert.setContentText("Plat bien ajouter !");
			alert.show();
		}
	}

}
