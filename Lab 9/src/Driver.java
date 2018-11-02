import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
	ImageView myPlayer;
	ImageView wall;
	Rectangle blankWall;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
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
		
		myPane =  new FlowPane();
		myPlayer = new ImageView(new Image("file:src/redcircle.png"));
		
		mazeScanner = new Scanner(selectedMaze);
		
		int x = 0;
		int y = 0;
		String row;
		String[] line;
		
		while (mazeScanner.hasNextLine())
		{			
			row = mazeScanner.nextLine();
			line = row.split(" ");
			
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
			x = 0;
			y += 50;
		}
		
		
		myGroup = new Group(myPane);
		myScene = new Scene(myGroup, psb.getWidth() *.9, psb.getHeight() * .9);
		
		primaryStage.setTitle("Maze");
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

}
