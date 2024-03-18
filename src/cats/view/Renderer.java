package cats.view;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cats.controller.Controller;

public class Renderer
{
	private static Frame frame;
	private static Canvas canvas;
	
	private static int canvasWidth = 0;
	private static int canvasHeight = 0;
	
	private static final int GAME_WIDTH = 400;
	private static final int GAME_HEIGHT = 225;
	
	private static int gameWidth = 0;
	private static int gameHeight = 0;
	
	public static void init()
	{
		getBestSize();
		
		frame = new Frame();
		canvas = new Canvas();
		
		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		
		frame.add(canvas);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing (WindowEvent event)
			{
				Controller.quit();
			}
		});
		
		frame.setVisible(true);
	}

	private static void getBestSize()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int scale = Math.min(screenSize.width / GAME_WIDTH, screenSize.height / GAME_HEIGHT);
		
		canvasWidth = GAME_WIDTH * scale;
		canvasHeight = GAME_HEIGHT * scale;
		
		int xDiff = screenSize.width - canvasWidth;
		int yDiff = screenSize.height - canvasHeight;
		
		gameWidth = canvasWidth / scale + xDiff / scale;
		gameHeight = canvasHeight / scale + yDiff / scale;
		
	}
}
