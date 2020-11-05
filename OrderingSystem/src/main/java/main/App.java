package main;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import dao.FoodDAO;
import dao.PhoneNoDAO;
import dao.AddressDAO;
import dao.UserDAO;
import entities.Food;

import entities.Address;
import entities.User;

@Path("/sampleservice")
public class App {

	public static Scanner input = new Scanner(System.in);
	public static String again, name, name1, name2, email, num, address, order, phoneNo, delete;
	public static int quantity = 1, loop1 = 0;
	public static double total = 0, pay;

	static UserDAO uDAO = new UserDAO();
	static AddressDAO aDAO = new AddressDAO();
	static FoodDAO fDAO = new FoodDAO();
	static PhoneNoDAO pDAO = new PhoneNoDAO();

	static {
	}

	@GET
	@Path("/AddToOrder")
	@Produces("text/plain")
	public static void menu() {

		List<Food> Foods = new ArrayList<Food>();

		System.out.println("Welcome to Fiachra's Takewawy");

		System.out.println("Choose a Menu Option");
		System.out.println("1. Burger - 13.49");
		System.out.println("2. Pasta - 16.79");
		System.out.println("3. Salad - 13.49");
		System.out.println("4. Salmon - 18.99");
		System.out.println("5. Chicken - 16.99");
		System.out.println("6. Nachos - 13.99");
		System.out.println("7. Soup - 6.99");
		System.out.println("8. Fajitas - 18.49");
		System.out.println("9. Ribs - 23.99");
		System.out.println("10. Calamari - 9.99");

		// **CREATE**//

		System.out.println("Add all the items you would like to the menu");
		order = input.nextLine();
		Food Food = new Food(order);
		Foods.add(Food);
		fDAO.persist(Food);

		System.out.println("What is your number ?");
		phoneNo = input.nextLine();

		System.out.println("What is your email ?");
		email = input.nextLine();

		System.out.println("What is your address ?");
		address = input.nextLine();
		Address Address = new Address(address, Foods);
		aDAO.persist(Address);

		System.out.println("What is your name ?");
		name = input.nextLine();
		User User = new User(name, phoneNo, email, Address);
		uDAO.persist(User);

		// **UPDATE**//
		System.out.println("Would you like to chage any of your information? Y or N");
		String change = input.nextLine();
		if (change.equalsIgnoreCase("Y")) {
			System.out.println("Which info would you like to change ? Name, number, address, email or your order ?");
			String change1 = input.nextLine();
			if (change1.equalsIgnoreCase("name")) {
				System.out.println("What would you like to update your name to?");
				String update = input.nextLine();
				User.setUsername(update);
				uDAO.merge(User);
			}
			if (change1.equalsIgnoreCase("number")) {
				System.out.println("What would you like to update your number to?");
				String update = input.nextLine();
				User.setnumber(update);
				uDAO.merge(User);
			}
			if (change1.equalsIgnoreCase("address")) {
				System.out.println("What would you like to update your address to?");
				String update = input.nextLine();
				Address.setDescription(update);
				uDAO.merge(User);
			}
			if (change1.equalsIgnoreCase("email")) {
				System.out.println("What would you like to update your email to?");
				String update = input.nextLine();
				User.setemail(update);
				uDAO.merge(User);
			}
			if (change1.equalsIgnoreCase("order")) {
				System.out.println("What would you like to update your  to?");
				String update = input.nextLine();
				//Address.setFoods(update);
				uDAO.merge(User);

			}
		}

	}

	@GET
	@Path("/DeliveryInfo")
	@Produces("text/plain")
	public static void Delivery() {

		// **READ**//
		System.out.println("Which users information would you like to access ?");
		name1 = input.nextLine();
		System.out.println(
				name1 + "'s order is " + uDAO.getUserByUsername(name1).getAddress().getFoods().get(0).getContent());
		System.out.println(name1 + "'s number is " + uDAO.getUserByUsername(name1).getnumber());
		System.out.println(name1 + "'s address is " + uDAO.getUserByUsername(name1).getAddress().getDescription());

		System.out.println("Do you want to delete any info ?");
		delete = input.nextLine();

	}

	@GET
	@Path("MarketingInfo")
	@Produces("text/plain")
	public static void Marketing() {

		System.out.println("Hello marketing team! Which users information would you like to access ?");
		name2 = input.nextLine();

		System.out.println(name2 + "'s email is " + uDAO.getUserByUsername(name2).getemail());

	}
}