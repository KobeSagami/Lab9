import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Coin {
	private Rectangle2D psb = Screen.getPrimary().getVisualBounds();
	private ImageView imgView;
	private Scene scene;
	private Stage stage;
	
	public Coin(Scene primaryScene, Image inputImage, Stage stage)
	{
		
		this.imgView = new ImageView(new Image("file:src/coin.png"));
		imgView.relocate(psb.getWidth() * .3, psb.getHeight() * .3);
		imgView.setFitHeight(30);
		imgView.setFitWidth(30);
		this.stage = stage;
	}
	
	public ImageView getImgView()
	{
		return imgView;
	}
	

}
