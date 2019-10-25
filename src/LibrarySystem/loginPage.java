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
	public loginPage()
	{
		int choice = 0;
		startPage.getLine();
		String[] choices = {"Login", "Create account","Return to home page"};
		choice = startPage.getUserChoice(choices, choices.length);
		getResponseForChoice(choice);
	}
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
	public void createNewUser()
	{
		boolean successfulCreation;
		userCreationPage userCreationPage = new userCreationPage();
		successfulCreation = userCreationPage.createAccount();
		if(successfulCreation == false) {
			System.out.println("Failure to create account");  return ;}
		else
			System.out.println("Account successfully created!\nYou are now logged in");
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
	}
	public boolean login( String password, String name)
	{
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
		return false;
	}
}