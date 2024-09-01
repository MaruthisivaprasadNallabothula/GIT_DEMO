package example_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
//@Component
public class WELLCOME_TO_ABC_TRAVELS {
	//@Autowire
	private User userObject;
	private login loginObject;
	private Planjourney planjourneyObject;
	private Available_Travels availableTravelsObject;

	private int userChoosenNumber;

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Hello broo!! changes done");
		FileInputStream fin = new FileInputStream(
				"C:\\Users\\Maruthi\\eclipse-workspace\\Example Core Java Project\\src\\abc.txt");
		try {
			int i = 0;
			while ((i = fin.read()) != -1) {
				System.out.print((char) i);
			}
			fin.close();

		} catch (IOException e) {
			System.out.println(e);

		}
		// Creating Object For Existing Classes
		WELLCOME_TO_ABC_TRAVELS wellcomeObject = new WELLCOME_TO_ABC_TRAVELS();
		User userObject = new User();
		login loginObject = new login();
		Planjourney planjourneyObject = new Planjourney();
		Available_Travels availableTravelsObject = new Available_Travels();

		// Injecting Objects For Depended Classes
		// 1.In WELLCOME_TO_ABC_TRAVELS
		wellcomeObject.setUserObject(userObject);
		wellcomeObject.setLoginObject(loginObject);
		wellcomeObject.setPlanjourneyObject(planjourneyObject);
		wellcomeObject.setAvailableTravelsObject(availableTravelsObject);

		// 2.In User class
		userObject.setWellcomeObject(wellcomeObject);
		userObject.setLoginObject(loginObject);

		// 3.Login Class
		loginObject.setWellcomeObject(wellcomeObject);
		loginObject.setUserObject(userObject);

		// 4. PlanJourney Class
		planjourneyObject.setWellcomeObject(wellcomeObject);
		planjourneyObject.setAvailableTravelsObject(availableTravelsObject);
		planjourneyObject.setUserObject(userObject);

		// 5. Available_Travels class
		availableTravelsObject.setWellcomeObject(wellcomeObject);
		availableTravelsObject.setPlanjourneyObject(planjourneyObject);
		availableTravelsObject.setUserObject(userObject);

		wellcomeObject.homeScreenMethod();

	}

	public void homeScreenMethod() {
		try {
			System.out.println("");
			System.out.println("Please Choose The Below Menu");
			System.out.println("Press 1 for User Registration");
			System.out.println("Press 2 for Lock Accounts");
			System.out.println("Press 3 for Plan Journey");
			System.out.println("press 4 for Exit");
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the menu number");
			int choosenNumber = sc.nextInt();
			this.setUserChoosenNumber(choosenNumber);

			if (choosenNumber >= 5) {
				System.out.println("Please Choose Between 1 - 4");
				homeScreenMethod();
			}

			if (choosenNumber == 1) {
				userObject.userRegistrationMethod();
			} else if (choosenNumber == 2) {
				if (userObject.getEmailId() == null) {
					System.out.println("Your Data Is Not There");
					System.out.println("Please SignUp First By Entering 1");
					userChoosenNumber = choosenNumber;
					homeScreenMethod();
				}
				loginObject.loginPage();
			} else if (choosenNumber == 3) {
				planjourneyObject.planJorney();
			} else if (choosenNumber == 4) {
				System.out.println("System Exiting.....");
				sc.close();
			} else {
				System.out.println("Please Choose Correct Number");
				System.out.println("Please Enter Number Between 1 - 4");
				homeScreenMethod();
			}
		} catch (InputMismatchException inputMismatchExceptionObject) {
			System.out.println("Please Enter Valid Input");
			System.out.println("InputMismatchException");
			homeScreenMethod();
		} catch (NoSuchElementException noSuchElementExceptionObject) {
			System.out.println("No Such Element Exception");
			System.out.println("Please Enter Valid Input");
			// have got exception in Plan Journey while edit feature
			// So has of now just commented
			// homeScreenMethod();
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}

	}

	public User getUserObject() {
		return userObject;
	}

	public void setUserObject(User userObject) {
		this.userObject = userObject;
	}

	public login getLoginObject() {
		return loginObject;
	}

	public void setLoginObject(login loginObject) {
		this.loginObject = loginObject;
	}

	public int getUserChoosenNumber() {
		return userChoosenNumber;
	}

	public void setUserChoosenNumber(int userChoosenNumber) {
		this.userChoosenNumber = userChoosenNumber;
	}

	public Planjourney getPlanjourneyObject() {
		return planjourneyObject;
	}

	public void setPlanjourneyObject(Planjourney planjourneyObject) {
		this.planjourneyObject = planjourneyObject;
	}

	public Available_Travels getAvailableTravelsObject() {
		return availableTravelsObject;
	}

	public void setAvailableTravelsObject(Available_Travels availableTravelsObject) {
		this.availableTravelsObject = availableTravelsObject;
	}

}
