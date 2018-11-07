import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin {
	private ImageView imgView;

	
	public Coin()
	{
		
		this.imgView = new ImageView(new Image("file:src/coin.png"));
		imgView.setFitHeight(25);
		imgView.setFitWidth(25);
	}
	
	public ImageView getImgView()
	{
		return imgView;
	}
}
