package cats.model;

import java.util.Scanner;

public class ShelterCats 
{
	private Scanner input;
	private boolean hasEnoughCats;
	private boolean userSaysEnoughCats;
	private boolean userHasDecided;
	private boolean correctValue;
	private int catCount;
	private int neededCatCount;
	private int oldNeededCatCount;
	private String wantsLessCats;
	private String sameCatCount;
	private String userCatsOpinion;
	
	public ShelterCats()
	{
		this.input = new Scanner(System.in);
		
		this.hasEnoughCats = false;
		this.userSaysEnoughCats = false;
		this.userHasDecided = false;
		this.correctValue = false;
		this.catCount = 0;
		this.neededCatCount = 100;
		this.oldNeededCatCount = -1;
		this.wantsLessCats = "";
		this.sameCatCount = "";
		this.userCatsOpinion = "";
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
				getCatFromShelter();
			}
			
			
			while (!userHasDecided)
			{
				isCatCountEnough();
			}
		}

		System.out.println("Yayyy!!!! We have " + catCount + " cats now! :3");
	}
	
	public boolean saysYes(String opinion)
	{
		if ((opinion.contains("yes") || opinion.contains("ya") || opinion.contains("ok") || opinion.contains("sure") || opinion.contains("yea")) && !(opinion.contains("no") || opinion.contains("nuh uh") || opinion.contains("not")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean saysNo(String opinion)
	{
		if ((opinion.contains("no") || opinion.contains("nuh uh") || opinion.contains("not")) && !(opinion.contains("yes") || opinion.contains("ya") || opinion.contains("ok") || opinion.contains("sure") || opinion.contains("yea")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void confirmNeededCats()
	{
		System.out.println("You think we need to have " + neededCatCount + " cats?");
		userCatsOpinion = input.nextLine();

		if (saysYes(userCatsOpinion))
		{
			System.out.println("Okay! Time to go to the shelter!");
			correctValue = true;
			hasEnoughCats = false;
			userHasDecided = true;
		}
		else if (saysNo(userCatsOpinion))
		{
			System.out.println("Oh, sorry. How many cats did you say we need?");
		}
		else
		{
			System.out.println("Sorry, I didn't understand what you said. You can say yes to confirm or no to deny the questions.");
		}

	}

	public void confirmWantsLessCats()
	{
		System.out.println("... That's less cats then what we currently have. Are you saying you want to get rid of some cats?");
		wantsLessCats = input.nextLine();
		if (saysYes(wantsLessCats))
		{
			System.out.println(".. Oh... ");
			System.out.println("I guess we could return some cats to the shelter..");
		}
		else if (saysNo(wantsLessCats))
		{
			System.out.println("Oh yay! Sooo.. How many cats do we need?");
		}
	}

	public void confirmSameCatCount()
	{
		System.out.println("... That's how many cats we already have. Did you mean to put that in?");
		sameCatCount = input.nextLine();

		if (saysYes(sameCatCount))
		{
			System.out.println("Ok, well uh.. I'm just gonna say that " + catCount + " is enough cats then.");
			userHasDecided = true;
			userSaysEnoughCats = true;
			correctValue = true;
		}
		else if (saysNo(sameCatCount))
		{
			System.out.println("I assumed so. How many cats did you mean to say we needed?");
		}
	}

	public void userSaysMoreCats()
	{
		System.out.println("You know what, you're right. How many cats do we need?");
		hasEnoughCats = false;
		correctValue = false;
		oldNeededCatCount = neededCatCount;
		while (!correctValue)
		{
			neededCatCount = input.nextInt();
			input.nextLine();
			if (oldNeededCatCount > neededCatCount)
			{
				confirmWantsLessCats();
			}
			else if (oldNeededCatCount == neededCatCount)
			{
				confirmSameCatCount();
			}
			else
			{
				confirmNeededCats();
			}
		}
	}

	public void isCatCountEnough()
	{
		System.out.println("Is " + catCount + " enough cats?");
		userCatsOpinion = input.nextLine();


		if (saysYes(userCatsOpinion))
		{
			userHasDecided = true;
			userSaysEnoughCats = true;
		}
		else if (saysNo(userCatsOpinion))
		{
			userSaysMoreCats();
		}
		else
		{
			System.out.println("Please say 'yes' or 'no'");
		}
	}

	public void getCatFromShelter()
	{
		System.out.println("Go to the shelter, you need another cat!");
		catCount++;

		if (catCount >= neededCatCount)
		{
			hasEnoughCats = true;
			userHasDecided = false;
		}
	}
}
