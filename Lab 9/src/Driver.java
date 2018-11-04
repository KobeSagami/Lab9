import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

// Lab 9

public class Driver extends Application
{
	Group myGroup;
	Scene myScene;
	Rectangle2D psb = Screen.getPrimary().getVisualBounds();
	
	File selectedMaze;
	Scanner mazeScanner;
	int randomNumber;
	Random r;
	
	FlowPane myPane;
	
	Image coinImage;
	Coin coin;
	Image playerImage;
	Player myPlayer;
	Label scoreLabel;
	int score;
	
	ImageView wall;
	Rectangle blankWall;
	
	String row;
	String[] line;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// This selects which maze will be displayed randomly.
		r = new Random();
		randomNumber = r.nextInt(2);
		switch(randomNumber)
		{
		case 0:
			selectedMaze = new File("./src/Documents/Maze1.txt");
			break;
		case 1:
			selectedMaze = new File("./src/Documents/Maze2.txt");
			break;
		}
		
		// Creating the pane for the walls to go in.
		myPane =  new FlowPane();
		
		// Iterates through the text file and creates either a wall or a black rectangle.
		mazeScanner = new Scanner(selectedMaze);
		
		int x = 0;
		int y = 0;
		
		while (mazeScanner.hasNextLine())
		{			
			row = mazeScanner.nextLine();
			line = row.split("\\s+");
			
			for (int i = 0; i < line.length; i++)
			{
				String token = line[i];
				if (token.equals("1"))
				{
					wall = new ImageView(new Image("file:src/brick.png"));
					wall.setFitHeight(50);
					wall.setFitWidth(50);
					wall.setX(x);
					wall.setY(y);
					myPane.getChildren().add(wall);
				}
				else if (token.equals("0"))
				{
					blankWall = new Rectangle();
					blankWall.setHeight(50);
					blankWall.setWidth(50);
					blankWall.setX(x);
					blankWall.setY(y);
					myPane.getChildren().add(blankWall);
				}
				x += 50;
			}
			System.out.println("\n");
			x = 0;
			y += 50;
		}
		// Dynamically changes the wrapping depending on length of line in the maze.
		myPane.setPrefWrapLength(line.length * 50);

		// Grouping, Scene, and Stage
		myGroup = new Group(myPane);
		myScene = new Scene(myGroup, line.length * 50, y);
		
		scoreLabel = new Label("Score: ");
		score = 0;
		
		coinImage =  new Image("file:src/coin.png");
		coin = new Coin(myScene, coinImage, primaryStage);
		
		playerImage = new Image("file:src/redcircle.png");
		myPlayer = new Player(myScene, playerImage, primaryStage, coin, score, scoreLabel);
		if (randomNumber == 0)
		{
			myPlayer.getImgView().relocate(0, 100);
		}
		else
		{
			myPlayer.getImgView().relocate(200, 0);
		}
		
		myPlayer.playermove();
		myGroup.getChildren().addAll(myPlayer.getImgView());
		
		primaryStage.setTitle("Maze");
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

}
