package cats.view;

import javax.swing.JFrame;

import cats.controller.Controller;

public class CatFrame extends JFrame
{
	private Controller app;
	
	public CatFrame(Controller app)
	{
		super();
		this.app = app;
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setTitle("Cats");
		this.setSize(1024, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setVisible(true);
	}
}
