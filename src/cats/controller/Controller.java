package cats.controller;

import cats.model.*;
import cats.view.CatFrame;

public class Controller 
{
	private ShelterCats cats;
	private CatFrame window;
	
	public Controller()
	{
		this.cats = new ShelterCats();
		this.window = new CatFrame(this);
	}
	
	public void start()
	{
		cats.callShelterCats();
	}
}
