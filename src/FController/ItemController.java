package FController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import models.Plats;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(plat);
    }

    private Plats plat; 
    private MyListener myListener;

    public void setData(Plats plat, MyListener myListener) {
        this.plat = plat;
        this.myListener = myListener;
        nameLabel.setText(plat.getName());
        priceLable.setText( plat.getPrice()+Main.CURRENCY );
        Image image = new Image(getClass().getResourceAsStream(plat.getImgSrc()));
        img.setImage(image);
    }
}
