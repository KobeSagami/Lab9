import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Player
{
	int score;
	Label scoreLabel;
	Stage stage;
	Scene primaryScene;
	ImageView imgView;
	Coin coin;
	
	public Player(Scene primaryScene, Image inputImage, Stage stage, Coin coin, int score, Label scoreLabel)
	{
		this.stage = stage;
		this.primaryScene = primaryScene;
		this.imgView = new ImageView(inputImage);
		imgView.setFitHeight(50);
		imgView.setFitWidth(50);
		this.coin = coin;
		this.scoreLabel=scoreLabel;
		this.score = score;
	}
	
	
	public ImageView getImgView()
	{
		return imgView;
	}
	
	public void playermove()
	{
		primaryScene.setOnKeyPressed(this::move);
	}
	
	public double playerGetX() {
		
		return imgView.getLayoutX();
	}
	public double playerGetY() {
		
		return imgView.getLayoutY();
	}
	
	public void move(KeyEvent movement)
	{
		switch(movement.getCode())
		{
			case D:
				imgView.setLayoutX(imgView.getLayoutX() + 50);
				//currentScore.setText("Current Score: " + addScore.playerScore());
				break;
			case A:
				imgView.setLayoutX(imgView.getLayoutX() - 50);
				//currentScore.setText("Current Score: " + addScore.playerScore());
				break;
			case W:
				imgView.setLayoutY(imgView.getLayoutY() - 50);
				//currentScore.setText("Current Score: " + addScore.playerScore());
				break;
			case S:
				imgView.setLayoutY(imgView.getLayoutY() + 50);
				//currentScore.setText("Current Score: " + addScore.playerScore());
				break;
			default:
				break;
		}
	}
	
	
}

