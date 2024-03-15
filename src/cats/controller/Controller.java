package cats.controller;

import cats.model.*;
import cats.view.Renderer;

public class Controller 
{
	private ShelterCats cats;
	private Renderer screen;
	
	public Controller()
	{
		this.cats = new ShelterCats();
		this.screen = new Renderer();
	}
	
	public void start()
	{
		screen.init();
		cats.callShelterCats();
	}
	
	public static void quit()
	{
		System.exit(0);
	}
}
