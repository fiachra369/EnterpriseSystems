package com.javacodegeeks.resteasy;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.FoodDAO;
import dao.ProfileDAO;
import dao.UserDAO;
import dao.UserDAO;
import entities.Food;
import entities.Profile;
import entities.User;


 
@Path("/sampleservice")
public class SampleService {
     
    
    private static ArrayList<String> order = new ArrayList<String>();
    public static Scanner input = new Scanner(System.in);
    public static String again, name, email;
    public static int choose,quantity=1, number;
    public static double total=0,pay;
    
    static UserDAO uDAO = new UserDAO();
	static ProfileDAO pDAO = new ProfileDAO();
	static FoodDAO fDAO = new FoodDAO();
	
    
  
    static {
    	
    	//Add Foods
    			Food c1 = new Food("Jane was here");
    			Food c2 = new Food("Jane loves NEtflix");
    			Food c3 = new Food("Jane hates cats");
    			fDAO.persist(c1);
    			fDAO.persist(c2);
    			fDAO.persist(c3);
    			
    			List<Food> Foods = new ArrayList<Food>();
    			Foods.add(c1);
    			Foods.add(c2);
    			Foods.add(c3);
    			//Add Profile
    			Profile profile = new Profile("Jane's profile", Foods);
    			pDAO.persist(profile);
    			
    			//Add User
    			User User = new User("janedoe","secret", profile );
    			uDAO.persist(User);
    			
    	
    	
    }
    
   
    
    @GET
    @Path("/CreateUser")
    @Produces("text/plain")
    public static void Test() {
		//View all Users (here I've accessed all objects through the User)
		ArrayList<User> Users = (ArrayList<User>) uDAO.getAllUsers();
		for(User s : Users) {
			System.out.println("User object username is "+s.getUsername());
			System.out.println("User's Profile says "+ s.getProfile().getDescription());
			//Note I've made an Eagar Fetch on the Foods List in Profile to enable this
			System.out.println("User's profile's first Food is "+s.getProfile().getFoods().get(0).getContent());
		}
		
		
		//Get User by username, print their password
		System.out.println(uDAO.getUserByUsername("janedoe24").getPassword());
    	
		
	}
    
    
    
    
     
 
    @GET
    @Path("/AddToOrder")
    @Produces("text/plain")
    public static void menu(){
    	
    	System.out.println("Welcome To Fiachras Takeaway ");
    	
    	System.out.println("What is your name ?");
    	name = input.next();
    	
    	System.out.println("What is your email ?");
    	email = input.next();
    	
    	System.out.println("What is your number ?");
    	number = input.nextInt();
    	
    	System.out.println("\t\t\t\t+===================================+");
        System.out.println("\t\t\t\t               MENU          ");
        System.out.println("\t\t\t\t   1. Chicken & Rice             €15.00");
        System.out.println("\t\t\t\t   2. Noodles & Beef             €20.00");
        System.out.println("\t\t\t\t   3. Pasta Bolognese            €5.00");
        System.out.println("\t\t\t\t   4. CANCEL                         ");
        System.out.println("\t\t\t\t+====================================+");
        
    	
    	    
    	    System.out.print("Press the number of the item you want to buy? :");
    	    choose = input.nextInt();
    	    //conditions
    	    if(choose==1){
    	        System.out.println("You choose Chiken & Rice");
    	        
    	        System.out.print("How many Tapsilog you want to Buy? :");
    	        quantity =input.nextInt();
    	        total = total +(quantity*15);
    	        
    	        System.out.println("You want to buy again? ");
    	        System.out.println("Press Y for Yes and N for N : ");
    	        again = input.next();
    	        if(again.equalsIgnoreCase("Y")){
    	            menu();//call the method you to create 
    	        }else{
    	            System.out.println("Enter a payment ");
    	            pay = input.nextDouble();
    	            if(pay <=total){
    	              System.out.println("Not enough payment");
    	            }else{
    	            System.out.println("Total price is " + total);
    	            total = pay-total;
    	            System.out.println("The change is " + total);
    	            order.add("Chicken & Rice");
    	            }
    	        }
    	    }else if(choose==2){
    	        System.out.println("You choose Noodles & Beef");
    	        
    	        System.out.print("How many Tocilog you want to Buy? :");
    	        quantity =input.nextInt();
    	        total = total +(quantity*20);
    	        
    	        System.out.println("You want to buy again? ");
    	        System.out.println("Press Y for Yes and N for N : ");
    	        again = input.next();
    	        if(again.equalsIgnoreCase("Y")){
    	            menu();//call the method you to create 
    	        }else{
    	            System.out.println("Enter a payment ");
    	            pay = input.nextDouble();
    	            if(pay <=total){
    	              System.out.println("Not enough payment");
    	            }else{
    	            System.out.println("Total price is " + total);
    	            total = pay-total;
    	            System.out.println("The change is " + total);
    	            order.add("Noodles & Beef");
    	            }
    	        }
    	      }else if(choose==3){
    	        System.out.println("You choose Pasta Bolognese");
    	  
    	        System.out.print("How many Longsilog you want to Buy? :");
    	        quantity =input.nextInt();
    	        total = total +(quantity*5);
    	        
    	        System.out.println("You want to buy again? ");
    	        System.out.println("Press Y for Yes and N for N : ");
    	        again = input.next();
    	        if(again.equalsIgnoreCase("Y")){
    	            menu();//call the method you to create 
    	        }else{
    	            System.out.println("Enter a payment ");
    	            pay = input.nextDouble();
    	            if(pay <=total){
    	              System.out.println("Not enough payment");
    	            }else{
    	            System.out.println("Total price is " + total);
    	            total = pay-total;
    	            System.out.println("The change is " + total);
    	            order.add("Bolognese");
    	            }
    	        }
    	    }else if(choose==4){
    	        System.exit(0);//close program
    	    }else{
    	        System.out.println("Choose 1 to 4 only!");
    	        menu();
    	    }
    	    System.out.println(order);
    	    }
    
    
     
}