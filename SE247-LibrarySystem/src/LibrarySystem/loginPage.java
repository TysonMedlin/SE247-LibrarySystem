/*
 * This class offers account creation options to the user.
 * The user can attempt to sign in from this class.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Tyson Medlin, 
 * Date: 10/24/2019
 */
package LibrarySystem;
import java.util.Scanner;

public class loginPage {
	//When loginPage is constructed, the user is offered login related choices.
	public loginPage()
	{
		int choice = 0;
		startPage.getLine();
		String[] choices = {"Login", "Create account","Return to home page"};
		choice = startPage.getUserChoice(choices, choices.length);
		getResponseForChoice(choice);
	}
	/* Gives this class's appropriate response given the users choice
	 * @param the users choice in integer format
	 * @returns none
	 */
	private void getResponseForChoice(int usersChoice)
	{
		Scanner key = new Scanner(System.in);
		switch(usersChoice) {
			case 1:
				String name;
				String password;
				System.out.println("Please enter the account name");
				name = key.nextLine();
				System.out.println("Please enter the password");
				password = key.nextLine();
				login( password, name );
				return;
			case 2:
				createNewUser();
				return;
		}
		
	}
	/* Creates a new user account and adds to userDatabase. 
	 * @param none
	 * @returns none
	 */
	public static void createNewUser()
	{
		boolean successfulCreation;
		userCreationPage userCreationPage = new userCreationPage();
		successfulCreation = userCreationPage.createAccount();
		if(successfulCreation == false) {
			System.out.println("Failure to create account");  return ;}
		else
			System.out.println("Account successfully created!\nYou are now logged in!");
		//startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
	}
	/* allows the user to login to an account. 
	 * @param users password, users name
	 * @returns Boolean true if successful, false if fails.
	 */
	public boolean login( String password, String name)
	{
		userDatabase.getInstance();
		//Iterator<baseUser> databaseIterator = userDatabase.returnIterator();
		for(int i = 0; i < userDatabase.database.size(); i++)
		{
			if(name.equalsIgnoreCase(userDatabase.database.get(i).getName())) //if the names match
			{
				if(password.equalsIgnoreCase(userDatabase.database.get(i).getPassword())) //if the passwords match
				{
					System.out.println("Login successful!");
					startPage.changeToCurrentUser(userDatabase.database.get(i));
					startPage.feesAppliedThisUser = false;
					startPage.checkedForAvailableHolds = false;
					return true;
				}
			}
		}
		startPage.makeUserLookAtThisMessageLoop("Account not found.");
		return false;
	}
}
