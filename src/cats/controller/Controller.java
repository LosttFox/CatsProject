package cats.controller;

import cats.model.*;

public class Controller 
{
	private ShelterCats cats;
	
	public Controller()
	{
		this.cats = new ShelterCats();
	}
	
	public void start()
	{
		cats.callShelterCats();
	}
}
