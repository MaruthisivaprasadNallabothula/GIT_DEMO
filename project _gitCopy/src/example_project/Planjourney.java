package example_project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Planjourney {

	private WELLCOME_TO_ABC_TRAVELS wellcomeObject;
	private Available_Travels availableTravelsObject;
	private User userObject;

	public void planJorney() {
		if (wellcomeObject.getUserObject().getEmailId() != null) {
			if (availableTravelsObject.getBusBooked() == null) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter your source");
				String source = sc.next();
				System.out.println("Please enter your destination");
				String destination = sc.next();
				System.out.println("Please enter Date in YYYY-MM-DD format");
				String userDate = sc.next();
				LocalDate date = LocalDate.parse(userDate, DateTimeFormatter.ISO_LOCAL_DATE);
				// userObject.setEmailId(wellcomeObject.getUserObject().getEmailId());

				availableTravelsObject.checkBuses(sc, source, destination, date);
			}

			else {
				System.out.println(availableTravelsObject.getBusBooked() + "from " + availableTravelsObject.getSource()
						+ " to " + availableTravelsObject.getDestination());
				Scanner scannerObject = new Scanner(System.in);
				System.out.println("Do you want to edit source (or) destination");
				System.out.println("Press 1 to edit");
				System.out.println("Press 2 to exit");
				int edit = scannerObject.nextInt();
				if (edit == 1) {
					availableTravelsObject.setBusBooked(null);
					availableTravelsObject.setEditBusTravel("You have successfully Changed your Bus Booking");
					wellcomeObject.getPlanjourneyObject().planJorney();
				}
				if (edit == 2) {
					wellcomeObject.homeScreenMethod();
				}
			}
		}

		else {
			System.out.println("Your Data Is Not There");
			System.out.println("Please SignUp First By Entering 1");
			wellcomeObject.homeScreenMethod();
		}
	}

	public Available_Travels getAvailableTravelsObject() {
		return availableTravelsObject;
	}

	public void setAvailableTravelsObject(Available_Travels availableTravelsObject) {
		this.availableTravelsObject = availableTravelsObject;
	}

	public WELLCOME_TO_ABC_TRAVELS getWellcomeObject() {
		return wellcomeObject;
	}

	public void setWellcomeObject(WELLCOME_TO_ABC_TRAVELS wellcomeObject) {
		this.wellcomeObject = wellcomeObject;
	}

	public User getUserObject() {
		return userObject;
	}

	public void setUserObject(User userObject) {
		this.userObject = userObject;
	}

}
