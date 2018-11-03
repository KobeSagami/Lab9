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
		this.coin = coin;
		this.scoreLabel=scoreLabel;
		this.score = score;
	}
	
	
	public void playermove()
	{
		primaryScene.setOnKeyPressed(this::move);
	}
	
	public void move(KeyEvent movement)
	{
		switch(movement.getCode())
		{
			case D:
				imgView.setLayoutX(imgView.getLayoutX() + 10);
				
				//currentScore.setText("Current Score: " + addScore.playerScore());
				break;
			case A:
				imgView.setLayoutX(imgView.getLayoutX() - 10);
				//currentScore.setText("Current Score: " + addScore.playerScore());
				break;
			case W:
				imgView.setLayoutY(imgView.getLayoutY() - 10);
				//currentScore.setText("Current Score: " + addScore.playerScore());
				break;
			case S:
				imgView.setLayoutY(imgView.getLayoutY() + 10);
				//currentScore.setText("Current Score: " + addScore.playerScore());
				break;
			default:
				break;
		}
	}
}
