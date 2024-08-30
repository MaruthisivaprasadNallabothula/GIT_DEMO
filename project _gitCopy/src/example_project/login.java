package example_project;

import java.util.Scanner;

public class login {
	private WELLCOME_TO_ABC_TRAVELS wellcomeObject;
	private User userObject;

	public void loginPage() {
		if (userObject.getEmailId() == null) {// if loop start
			System.out.println("Now Please SignIn");
			String savedEmail = wellcomeObject.getUserObject().getEmailId();
			String savedPassword = wellcomeObject.getUserObject().getPassword();
			Scanner sc = new Scanner(System.in);
			System.out.println("please enter  your email");
			String email = sc.next();

			System.out.println("please enter password");
			String password = sc.next();

			if (email.equals(savedEmail) & password.equals(savedPassword)) {
				System.out.println("Your are Logged in Succesfully");
				getUserObject().setFailedCount(0);
				getUserObject().setAccountStatus("ACtive");
				System.out.println("Your Failed Count is " + getUserObject().getFailedCount());
				userObject.setEmailId(email);// userObject.getEmailId();
				wellcomeObject.homeScreenMethod();
			}

			else {
				System.out.println("Wrong creditionals");
				int failedCount = getUserObject().getFailedCount();
				if (failedCount == 5) {
					getUserObject().setAccountStatus("Blocked");
					System.out.println("Your Account Status is " + getUserObject().getAccountStatus());
					System.exit(0);
				}
				failedCount++;// 1
				getUserObject().setFailedCount(failedCount);
				System.out.println("failedCount is " + getUserObject().getFailedCount());
				System.out.println("Please Signup again");
				loginPage();

			}
		} // if loop end

		else {
			System.out.println("Your Data Is Already Present In Our System");
			System.out.println("Your EmailId is " + userObject.getEmailId());
			wellcomeObject.homeScreenMethod();
		}

	}

	public User getUserObject() {
		return userObject;
	}

	public void setUserObject(User userObject) {
		this.userObject = userObject;
	}

	public WELLCOME_TO_ABC_TRAVELS getWellcomeObject() {
		return wellcomeObject;
	}

	public void setWellcomeObject(WELLCOME_TO_ABC_TRAVELS wellcomeObject) {
		this.wellcomeObject = wellcomeObject;
	}

}
