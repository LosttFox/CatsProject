package cats.view;

import javax.swing.JPanel;
import cats.controller.Controller;

public class CatPanel extends JPanel
{
	private Controller app;
	
	public CatPanel(Controller app)
	{
		super();
		this.app = app;
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
}
