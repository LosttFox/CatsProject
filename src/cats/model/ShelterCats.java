package cats.model;

import java.util.Scanner;

public class ShelterCats 
{
	private Scanner input;
	private boolean hasEnoughCats;
	private boolean userSaysEnoughCats = false;
	private boolean userHasDecided = false;
	private int catCount = 0;
	private int neededCatCount = 100;
	private int oldNeededCatCount;
	private String wantsLessCats;
	
	public ShelterCats()
	{
		this.input = new Scanner(System.in);
	}
	
	
	public void callShelterCats()
	{

		if (catCount >= neededCatCount)
		{
			hasEnoughCats = true;
		}
		else
		{
			hasEnoughCats = false;
		}
		
		while (!userSaysEnoughCats)
		{
			while (!hasEnoughCats)
			{
				System.out.println("Go to the shelter, you need another cat!");
				catCount++;
				
				if (catCount >= neededCatCount)
				{
					hasEnoughCats = true;
					userHasDecided = false;
				}
			}
			
			
			while (!userHasDecided)
			{
				System.out.println("Is " + catCount + " enough cats?");
				String userCatsOpinion = input.next();
				input.nextLine();
				
				
				if (userCatsOpinion.contains("yes"))
				{
					System.out.println("I think " + catCount + " is an alright amount of cats too.");
					userHasDecided = true;
					userSaysEnoughCats = true;
				}
				else if (userCatsOpinion.contains("no"))
				{
					System.out.println("You know what, you're right. How many cats do we need?");
					boolean correctValue = false;
					while (!correctValue)
					{
						oldNeededCatCount = neededCatCount;
						neededCatCount = input.nextInt();
						input.nextLine();
						if (oldNeededCatCount > neededCatCount)
						{
							System.out.println("... That's less cats then what we currently have. Are you saying you want to get rid of some cats?");
							wantsLessCats = input.nextLine();
							if (wantsLessCats.contains("yes"))
							{
								System.out.println(".. Oh... ");
								System.out.println("I guess we could return some cats to the shelter..");
							}
							else if (wantsLessCats.contains("no"))
							{
								System.out.println("Oh yay! ");
							}
							
						}
						System.out.println("You think we need to have " + neededCatCount + " cats?");
						userCatsOpinion = input.next();
						input.nextLine();
						if (userCatsOpinion.contains("yes"))
						{
							System.out.println("Okay! Time to go to the shelter!");
							correctValue = true;
							hasEnoughCats = false;
							userHasDecided = true;
						}
						else if (userCatsOpinion.contains("no"))
						{
							System.out.println("Oh, sorry. How many cats did you say we need?");
						}
					}
				}
				else
				{
					System.out.println("Please say 'yes' or 'no");
				}
			}
		}
	}
}
