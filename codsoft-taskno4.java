import java.util.*;
class BankAc
{
	private	double bank_balance;

	public BankAc(double initial_bank_balance)
	{
		this.bank_balance = initial_bank_balance;
	}
	public double getbank_balance()
	{
		return bank_balance;
	}
	public void deposit_ammount(double ammount)
	{
		if(ammount > 0)
		{
			bank_balance = bank_balance + ammount;
			System.out.println("Rupees " + ammount  + " deposit successfully.");  	
			System.out.println("Your current balance is " + bank_balance);
		}
		else
		{
			System.out.println("Invalid Deposite Ammount !");
		}
	}
	public boolean Withdraw(double ammount)
	{
		if(ammount > 0 && ammount < bank_balance)
		{
			bank_balance = bank_balance - ammount;
			System.out.println("Transaction Succseccfull !");
			System.out.println("Rupees " + ammount + " was deducted from your account !");
  			System.out.println("Your current balance is " + bank_balance);
			return true;
			
		}
		else if(ammount < 0)
		{
			System.out.println("Invalid Ammount ! ");
			return false;
		}
		else
		{
			System.out.println("You don't have sufficient ammount to proceed this transaction");
			return false;
		}
	}
	
}
class Atm
{
	private BankAc bankAc;

	public Atm (BankAc bankAc)
	{
		this.bankAc = bankAc;
	}
	public void Display_Menu()
	{
		System.out.println("___ ATM MENU ___");
		System.out.println("1.Check Bank Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdrawl");
		System.out.println("4.Exit");

	}
	public void Transaction(int choice , double ammount)
	{
		switch (choice)
		{
			case 1:
			  System.out.println("Your current balance is = "+ bankAc.getbank_balance());
			  break;
			case 2:
			   bankAc.deposit_ammount(ammount);
			   break;
			case 3:
			   bankAc.Withdraw(ammount);
                           break;
			case 4:
			   System.out.println("Thank you !");
			   System.exit(0);
			   break;
			default:
			   System.out.println("Invalid choice !");
			
		}
	}
}
public class Main
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your initial balance = ");
		double initial_bank_balance = sc.nextDouble();
		
		BankAc Ac = new BankAc(initial_bank_balance);
		Atm atm = new Atm(Ac);

		while(true)
		{
			atm.Display_Menu();
			System.out.println("Please Enter Your Choice : ");
			int choice = sc.nextInt();
			if(choice > 1 && choice < 4)
			{
				System.out.println("Please Enter Your Ammount : ");
				double ammount = sc.nextDouble();
				atm.Transaction(choice,ammount);
			}
			else if(choice == 4)
			{
				atm.Transaction(choice,0);
			}
			else if(choice == 1)
			{
				atm.Transaction(choice,0);
			}
			else
			{
				System.out.println("You have to choice in between 1 to 4 ...");
			}
		}
	}
}
