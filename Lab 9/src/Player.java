import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Player
{
	int score;
	private Label scoreLabel;
	private Stage stage;
	private Scene primaryScene;
	private ImageView imgView;
	private Coin coin;
	private GameEnder gameEnder;
	private Text myText;
	private Group myGroup;
	
	private Rectangle2D psb = Screen.getPrimary().getVisualBounds();
	private Random r;
	
	public Player(Scene primaryScene, Image inputImage, Stage stage, Coin coin, int score, Label scoreLabel, GameEnder gameEnder)
	{
		this.stage = stage;
		this.primaryScene = primaryScene;
		this.imgView = new ImageView(inputImage);
		imgView.setFitHeight(50);
		imgView.setFitWidth(50);
		this.coin = coin;
		this.scoreLabel=scoreLabel;
		this.score = score;
		this.gameEnder = gameEnder;
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
	
	public int playerScore()
	{
		return score;
	}
	
	public boolean areRectsColliding(double r1TopLeftX, double
			r1BottomRightX,double r1TopLeftY, double r1BottomRightY, double
			r2TopLeftX,double r2BottomRightX, double r2TopLeftY, double
			r2BottomRightY)
	{
		if (r1TopLeftX < r2BottomRightX && r1BottomRightX >
			r2TopLeftX && r1TopLeftY < r2BottomRightY && r1BottomRightY >
			r2TopLeftY) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void collect() 
	{
		if (areRectsColliding(playerGetX(),
				playerGetX() + 50,
				playerGetY(),
				playerGetY() + 50,
				coin.getImgView().getLayoutX(),
				coin.getImgView().getLayoutX() + 25,
				coin.getImgView().getLayoutY(),
				coin.getImgView().getLayoutY() + 25)
				== true)
		{	
			score+=1;
			scoreLabel.setText("Score: " + score);
			coin.getImgView().setVisible(false);
		}
	}
	
	public void gameover() 
	{
		if (areRectsColliding(playerGetX(),
				playerGetX() + 50,
				playerGetY(),
				playerGetY() + 50,
				gameEnder.getRectangle().getLayoutX(),
				gameEnder.getRectangle().getLayoutX() + 25,
				gameEnder.getRectangle().getLayoutY(),
				gameEnder.getRectangle().getLayoutY() + 25)
				== true)
		{	
			myText = new Text(90, 30,"Game Over");
			myGroup = new Group(myText);
			Scene gameOverScene = new Scene(myGroup, 250, 50);
			stage.setScene(gameOverScene);
		}
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
		collect();
		gameover();
	}
}

