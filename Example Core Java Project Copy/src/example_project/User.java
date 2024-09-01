package example_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class User {

	private String firstName;
	private String lastName;
	private long mobileNumber;
	private char gender;
	private String emailId;
	private String password;
	private static int failedCount;
	private String accountStatus;
	
	private WELLCOME_TO_ABC_TRAVELS wellcomeObject;
	private login loginObject;
   
	public User userRegistrationMethod(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please SignUp");
		System.out.println("Please Enter your first name");
		String firstName = sc.nextLine();

		System.out.println("please enter last name");
		String lastName = sc.nextLine();

		System.out.println("please enter Mobile Number");
		long mobileNumber = sc.nextLong();

		System.out.println("Please enter Gender");
		char gender = sc.next().charAt(0);

		System.out.println("Please enter Email Id");
		sc.nextLine();
		String emailId = sc.nextLine();

		System.out.println("plesae enter password");
		String password = sc.nextLine();

		User user1 = new User(firstName, lastName, mobileNumber, gender, emailId, password);
		wellcomeObject.setUserObject(user1);
		System.out.println("Your Details Are Saved In Our System");
		System.out.println("Now Kindly SignIn");

		wellcomeObject.homeScreenMethod();

		Map<String, User> map = new HashMap<>();
		map.put(user1.getEmailId(), user1);

		//wellcomeObject.homeScreenMethod();
		return user1;
	
	}
	
	


	public User() {
	}

	public User(String firstName, String lastName, long mobileNumber, char gender, String emailId, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
		
		
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + ", emailId=" + emailId + ", password=" + password + ", accountStatus="
				+ accountStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountStatus, emailId, firstName, gender, lastName, mobileNumber, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accountStatus, other.accountStatus) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(firstName, other.firstName) && gender == other.gender
				&& Objects.equals(lastName, other.lastName) && mobileNumber == other.mobileNumber
				&& Objects.equals(password, other.password);
	}


	public WELLCOME_TO_ABC_TRAVELS getWellcomeObject() {
		return wellcomeObject;
	}


	public void setWellcomeObject(WELLCOME_TO_ABC_TRAVELS wellcomeObject) {
		this.wellcomeObject = wellcomeObject;
	}


	public login getLoginObject() {
		return loginObject;
	}


	public void setLoginObject(login loginObject) {
		this.loginObject = loginObject;
	}

	
	

}

