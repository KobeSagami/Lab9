import javafx.scene.shape.Rectangle;

public class GameEnder
{
	private Rectangle rectangle;

	
	public GameEnder()
	{
		rectangle = new Rectangle();
		rectangle.setHeight(50);
		rectangle.setWidth(50);
	}
	
	public Rectangle getRectangle()
	{
		return rectangle;
	}
}
