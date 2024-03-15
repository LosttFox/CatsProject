package cats.view;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
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
	private static final int GAME_HEIGHT = 400;
	
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
		
	}
}
