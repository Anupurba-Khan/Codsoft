import java.util.*;

public class Number_Guessing_Game
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int upper_limit=100,lower_limit=1,round=0,score=0,target_number,max_attempt=10,user_input,attempt=0;
		boolean play_game=true;

		while(play_game)
		{
			target_number = r.nextInt(upper_limit - lower_limit + 1) + lower_limit;
			System.out.println("Welcome to the Number Guessing game !!!" );
			System.out.println("Lets start !!! ");
			System.out.println("I am selecting a number in between "+lower_limit +" and "+upper_limit +" . Can you guess the number ? You have total 10 guesses !");
			
			boolean guessed=false;
			while(attempt < max_attempt && !guessed)
			{
				System.out.println("Please enter your guess =");
				user_input=sc.nextInt();

				if(user_input < target_number)
				{
					attempt++;
					int x = max_attempt - attempt;
					System.out.println("Too low !!! Please try again ! You have "+ x +" attempts left!");
				}
				else if(user_input > target_number)
				{
					attempt++;
					int y = max_attempt - attempt;
					System.out.println("Too high !!! Please try again ! You have "+ y +" attempts left!");
				}
				else
				{
					attempt++;
					System.out.println("Congratulation !!! You gueessed the correct number : " + target_number);
					guessed = true;
					score=(max_attempt - attempt);
				}
			}
			if(!guessed)
			{
				System.out.println("Sorry ! You are out of attempts ! The correct number was = "+target_number);
			}
			
			round++;
			System.out.println("Do you want to play one more round ? (Yes/No)");
			String response = sc.next();
			play_game = response.equalsIgnoreCase("yes");
		   	
		}
		System.out.println("Game Over !!! Your final score is : "+score+" points");
	}
}