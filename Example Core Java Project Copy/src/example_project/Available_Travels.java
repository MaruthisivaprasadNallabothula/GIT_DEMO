package example_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Available_Travels {
	private int busNo;
	private String source;
	private String destination;
	private boolean busFound;
	private double GST;
	private boolean weekend;
	// Just to check wheather the user is booking bus for second time
	private String busBooked;
	// Just to edit source of destination
	private String editBusTravel;

	private WELLCOME_TO_ABC_TRAVELS wellcomeObject;
	private Planjourney planjourneyObject;
	private User userObject;
	// TODO Task's map.put(LocalDate.now().plusDays(2), allTravels);

	/*
	 * In this method has scannerObject, User's source, User's destination, and
	 * User's date. Here in this methos we have created the three bus objects with
	 * busNo, available source, and available destination. All three objects are
	 * added into an ArrayList. We have also taken a Map collection to store the
	 * data i.e key = Today's Date and value = entire all three bus objects This
	 * method also check's User's source, destination, and date with available
	 * source, destination, and date
	 */
	public void checkBuses(Scanner sc, String source, String destination, LocalDate date) {
		/* Here Buses Objects Are Created With busNo, source, destination */
		Available_Travels A1Travels = new Available_Travels(101, "Anantapur", "Bengaluru");
		Available_Travels B1Travels = new Available_Travels(102, "Anantapur", "Hyderabad");
		Available_Travels c1Travels = new Available_Travels(103, "Anantapur", "Chennai");

		/* Here All Buses Objects Are Added Into An ArrayList */
		ArrayList<Available_Travels> allTravels = new ArrayList<>();
		allTravels.add(A1Travels);
		allTravels.add(B1Travels);
		allTravels.add(c1Travels);

		/*
		 * Here HashMap IS Created and key=Today's Date and Value = entire three buses
		 * object's
		 */
		Map<LocalDate, ArrayList<Available_Travels>> map = new HashMap<>();
		map.put(LocalDate.now(), allTravels);

		/*
		 * In This Method i.e map.values will return all 3 buses objects and
		 * temp.get(indexPosition) will return each bus object. From each bus object we
		 * have extracted source and compared with User entered source and in the same
		 * way we have compared destinations
		 */
		Collection<ArrayList<Available_Travels>> values = map.values();
		for (ArrayList<Available_Travels> temp : values) {
			/* Outer if block validates User's source and available source */
			if (source.equals(temp.get(0).getSource()) || source.equals(temp.get(1).getSource())
					|| source.equals(temp.get(2).getSource())) {
				/*
				 * First inner if block validates User's source and available source and this
				 * block also contains a method to validate User's date and available bus date
				 */
				if (destination.equals(temp.get(0).getDestination()) || destination.equals(temp.get(1).getDestination())
						|| destination.equals(temp.get(2).getDestination())) {
					/* This Method validates the User' date and available date */
					methodchecksUsersdateandbusavialabledate(date, map);
					/*
					 * Second inner if block check's the bus availablity, if getisBusFound() method
					 * return true further operations are performed like checking weekend (or) not
					 * and Generating bus ticket
					 */
					if (wellcomeObject.getAvailableTravelsObject().getisBusFound()) {
						System.out.println("Buses are available from " + source + " to " + destination + " on " + date);
						/* This is a method to check weekend (or) not */
						CheckUsersDataweekendOrnot(date, sc, source, destination);
					}
					/*
					 * Second inner if block's related else statement and only executed if Second
					 * inner if block's conditions fails
					 */
					else {
						System.out.println(
								"No Buses are available from " + source + " to " + destination + " on that " + date);
						wellcomeObject.homeScreenMethod();
					}

				}
				/*
				 * First inner if block's related else statement and only executed if First
				 * inner if block's conditions fails
				 */
				else {
					System.out.println("No Buses are available from " + source + " to " + destination + " on " + date);
					wellcomeObject.homeScreenMethod();
				}

			}
			/*
			 * Outer if block's related else statement and only executed if Outer if block's
			 * conditions fails
			 */
			else {
				System.out.println("No Buses are available from " + source + " to " + destination + " on that " + date);
				wellcomeObject.homeScreenMethod();
			}
		}
	}

	/*
	 * This method has scannerObject, User's source, User's destination, and User's
	 * date. Here it sets the GST as 0.15 if it is weekend and based an no of
	 * passengers it will generate the Ticket price
	 */
	private void TicketPriceCaluculationifitisweekend(Scanner sc, String source, String destination, LocalDate date) {
		System.out.println("Please enter the no of passengers!!(weekend Based)");
		int noOfPassengers1 = sc.nextInt();
		wellcomeObject.getAvailableTravelsObject().setGST(0.15);
		int perPersonTicketPrice1 = 500;
		double totalTicketPrice1 = (noOfPassengers1 * perPersonTicketPrice1);
		totalTicketPrice1 = totalTicketPrice1
				+ (totalTicketPrice1 * wellcomeObject.getAvailableTravelsObject().getGST());
		if (wellcomeObject.getAvailableTravelsObject().getEditBusTravel() != null) {
			System.out.println(wellcomeObject.getAvailableTravelsObject().getEditBusTravel());
			System.out.println("Your Bus Booking is changed from " + source + " To " + destination + " on " + date
					+ " with " + wellcomeObject.getAvailableTravelsObject().getGST() + "% GST");
			System.out.println("");
			System.out.println("Your total ticket price is " + totalTicketPrice1);
		} else {
			System.out.println("Your Bus Booking is conformed from " + source + " To " + destination + " on " + date
					+ " with " + wellcomeObject.getAvailableTravelsObject().getGST() + "% GST");
			System.out.println("Your total ticket price is " + totalTicketPrice1);
			wellcomeObject.getAvailableTravelsObject().setBusBooked("You have already booked your Bus");
			wellcomeObject.getAvailableTravelsObject().setSource(source);
			wellcomeObject.getAvailableTravelsObject().setDestination(destination);
			wellcomeObject.homeScreenMethod();
		}
	}

	/*
	 * This method has scannerObject, User's source, User's destination, and User's
	 * date. Here it sets the GST as 0.1 if it is not weekend and based an no of
	 * passengers it will generate the Ticket price
	 */
	private void TicketPriceCaluculationifitisnotweekend(Scanner sc, String source, String destination,
			LocalDate date) {
		System.out.println("Please enter the no of passengers!!(not weekend Based)");
		int noOfPassengers = sc.nextInt();
		wellcomeObject.getAvailableTravelsObject().setGST(0.1);
		int perPersonTicketPrice = 500;
		double totalTicketPrice = (noOfPassengers * perPersonTicketPrice);
		totalTicketPrice = totalTicketPrice + (totalTicketPrice * wellcomeObject.getAvailableTravelsObject().getGST());
		if (wellcomeObject.getAvailableTravelsObject().getEditBusTravel() != null) {
			System.out.println(wellcomeObject.getAvailableTravelsObject().getEditBusTravel());
			System.out.println("Your Bus Booking is changed from " + source + " To " + destination + " on " + date
					+ " with " + wellcomeObject.getAvailableTravelsObject().getGST() + "% GST");
			System.out.println("");
			System.out.println("Your total ticket price is " + totalTicketPrice);
		} else {
			System.out.println("Your Bus Booking is conformed from " + source + " To " + destination + " on " + date
					+ " with " + wellcomeObject.getAvailableTravelsObject().getGST() + "% GST");
			System.out.println("");
			System.out.println("Your total ticket price is " + totalTicketPrice);
		}
		wellcomeObject.getAvailableTravelsObject().setBusBooked("You have already booked your Bus");
		wellcomeObject.getAvailableTravelsObject().setSource(source);
		wellcomeObject.getAvailableTravelsObject().setDestination(destination);
		wellcomeObject.homeScreenMethod();
	}

	/*
	 * This method has User's date, scanner object, User's source, and User's
	 * destination. Here it check's wheather the user booking the ticket in week
	 * days (or) weekend days and it also has a method internally to calculate and
	 * generate Bus Ticket and price
	 */
	private void CheckUsersDataweekendOrnot(LocalDate date, Scanner sc, String source, String destination) {
		/*
		 * Here getDayOfWeek() method returns weather it is
		 * Sunday(or)Monday(or)Tuesday(or)etc. and getValue() method returns integer
		 * between 1 to 7 based an day.(1=Monday,....7=Sunday)
		 */
		if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
			System.out.println("It's Weekend");
			/* Calculating The Ticket Price if it is weekend Based On No of Passengers */
			TicketPriceCaluculationifitisweekend(sc, source, destination, date);
		} else {
			System.out.println("It's Not An Weekend");
			/*
			 * Calculating The Ticket Price if it is not weekend Based On No of Passengers
			 */
			TicketPriceCaluculationifitisnotweekend(sc, source, destination, date);
		}
	}

	/*
	 * This method has User's date and map Object with contains Today's date as key
	 * and Value as entire three bus objects. Here this method validates the User's
	 * date and bus available date.
	 */
	private void methodchecksUsersdateandbusavialabledate(LocalDate date,
			Map<LocalDate, ArrayList<Available_Travels>> map) {
		/*
		 * Here map.keySet() method returns keys of map object so here we maintained
		 * Today's date as key hence Today date will be returned
		 */
		Set<LocalDate> keySet = map.keySet();
		/* keySet reference variable contails Today's Date */
		for (LocalDate temp : keySet) {
			/* temp.getDayOfMonth() method return current day of that month */
			int dayOfMonth = temp.getDayOfMonth();
			int usersDate = date.getDayOfMonth();
			if (dayOfMonth == usersDate) {
				System.out.println("Your Buses Are Available on " + date);
				wellcomeObject.getAvailableTravelsObject().setBusFound(true);
				break;
			} else {
				System.out.println("No Buses Available for that "+date);
				wellcomeObject.getAvailableTravelsObject().setBusFound(false);
				break;
			}
		}

	}

	public Available_Travels() {
	}

	public Available_Travels(int busNo, String source, String destination) {
		this.busNo = busNo;
		this.source = source;
		this.destination = destination;
	}

	@Override
	public int hashCode() {
		return Objects.hash(GST, busFound, busNo, destination, source, weekend);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Available_Travels other = (Available_Travels) obj;
		return Double.doubleToLongBits(GST) == Double.doubleToLongBits(other.GST) && busFound == other.busFound
				&& busNo == other.busNo && Objects.equals(destination, other.destination)
				&& Objects.equals(source, other.source) && weekend == other.weekend;
	}

	@Override
	public String toString() {
		return "Available_Travels [busNo=" + busNo + ", source=" + source + ", destination=" + destination
				+ ", busFound=" + busFound + ", GST=" + GST + ", weekend=" + weekend + "]";
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public boolean getisWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	public double getGST() {
		return GST;
	}

	public void setGST(double gST) {
		GST = gST;
	}

	public boolean getisBusFound() {
		return busFound;
	}

	public boolean setBusFound(boolean busFound) {
		return this.busFound = busFound;
	}

	public WELLCOME_TO_ABC_TRAVELS getWellcomeObject() {
		return wellcomeObject;
	}

	void setWellcomeObject(WELLCOME_TO_ABC_TRAVELS wellcomeObject) {
		this.wellcomeObject = wellcomeObject;
	}

	public Planjourney getPlanjourneyObject() {
		return planjourneyObject;
	}

	public void setPlanjourneyObject(Planjourney planjourneyObject) {
		this.planjourneyObject = planjourneyObject;
	}

	public User getUserObject() {
		return userObject;
	}

	public void setUserObject(User userObject) {
		this.userObject = userObject;
	}

	public String getBusBooked() {
		return busBooked;
	}

	public void setBusBooked(String busBooked) {
		this.busBooked = busBooked;
	}

	public String getEditBusTravel() {
		return editBusTravel;
	}

	public void setEditBusTravel(String editBusTravel) {
		this.editBusTravel = editBusTravel;
	}

}
