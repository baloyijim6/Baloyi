package module16;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;




//parent class
public class Baloyi {
	
	
	static Scanner Christ = new Scanner (System.in);
	static String name,surname,ID,gender,age,phone, username, password,email;
	static int  reg_no;
	static LocalDateTime currentTime = LocalDateTime.now();     
    
	static String str = "2016-04-11 09:20";
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public static void admin()
	{
		System.out.println("===========ADMINISTRATION CENTER========="); 
		System.out.println(currentTime);
		System.out.println("=========================================================");

		 System.out.println("=== ADMIN Options : =============");
		System.out.println("1 for Log In--------- " + "\n2 If you Forgot Log In details" + "\n3 to Exit---------" ) ;
		
		String options ;
		 System.out.println("Enter here :_____");
		options = Christ.next();
		
		//switch
		switch(options)
		{
		case "1" :
			Login();
			break;
		case "2" :
			ForgotPassword();
			break;
		case "3":
			System.out.println("Thank You for using our System,Come again");
			System.exit(0);
			break;
		default : 
			System.out.println("Wrong main menu option chosen!!");
			Starter();
		
		}
		//end of switch statement
		
	}
	//end of admin method
	
	public static void Login()
	{
		System.out.println("========================User DETAILS Check====================================");
		System.out.println("please provide us with your username:");
		username = Christ.next();
		System.out.println("please provide us with your email Address:");
		email = Christ.next();
		
		System.out.println("Successfully Checked... " + "\nPlease Enter your password :");
		password = Christ.next();
		
		//start of if statement to validate username and email
		String pword = "";
		
		//String builder
		StringBuilder builder = new StringBuilder(pword);
		
		//manipu``````````lating Strings
		pword = username.substring(0, 3) + email.substring(0, 3);
		
		if (password.matches(pword) )
		{
			System.out.println("====================Successfully Logged IN==============");
			
			Starter();
		}
		//end of if statement
		else
		{
			System.out.println("====================Wrong Login Details provided!!!==============");
			  
		}
		//end of else statement
	}
	//end of method
	
	//start of method
	public static void ForgotPassword()
	{
		System.out.println("PASSWORD RECOVERY=============================");
		System.out.println("Please Note :" + "\nYour password is the first 3 letters of your username combined with first 3 of your email. " + 
		"\nExample : _____" +"\nUsername : username" + "\nEmail : email@gmail.com" + "\nPassword : useema" );
		System.out.println("==============================================================================");
		
		
		Login();
	}
	
	//end of method
	
	//method
	public static void Starter()
	{
		Cashiers cash = new Cashiers();
		
		
		System.out.println("===========WELCOME TO ONLINE CASHIER REGISTRATION========="); 
		System.out.println(currentTime);
		System.out.println("=========================================================");
		
		 System.out.println("=== MAIN MENU =============");
		 System.out.println("1 for Display Registered Cashiers " +  "\n2 for Register Cashier " +  "\n3 for Delete Cashiers " +  "\n4 to Log Out " );
		 String main; 
		 
		 System.out.println("Enter :____");
		 main = Christ.next(); 
		 
		 //switch
		 switch(main)
		 {
		 case "1":
			 Cashiers.displayCashier();
			 break;
		 case "2":
			 
			 Cashiers.addCashier();
			 break;
		
		case "3":
			
			break;
		
		case "4":
			//LocalDateTime date = currentTime.withDayOfMonth(11).withYear(2016);
		      //System.out.println("Date: " + date);
		      LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		      System.out.println("Date: " + dateTime);
		      
			System.out.println("Thank You for using our System,Come again");
			System.exit(0);
			break;
		default :
			System.out.println("Wrong main menu option chosen!!");
			Starter();
		 }
		 //end of switch
			
	}
	//end of method
	
	
//main method
public static void main(String args [])
{
	
	admin();
	
}
//end of main method
	
	

}
//end of parent class

//child class
class Cashiers extends Baloyi {
	
	static ArrayList<Comparable> cashierDetails = new ArrayList<Comparable>();
	
	//new method
	static void addCashier()
	{
		System.out.println("please enter cashier's name :");
		name = Christ.next();
		
		System.out.println("please enter cashier's surname :");
		surname = Christ.next();
		
		System.out.println("please enter cashier's gender :");
		gender = Christ.next();
		
		System.out.println("please enter cashier's ID number :");
		ID = Christ.next();
		
		System.out.println("please enter cashier's age :");
		age = Christ.next();
		
		System.out.println("please enter cashier's phone no :");
		phone = Christ.next();
		
		
		//arrayList
		cashierDetails.add(name);
		cashierDetails.add(surname);
		cashierDetails.add(gender);
		cashierDetails.add(ID);
		cashierDetails.add(age);
		cashierDetails.add(phone);
		
		System.out.println("Cashier Details :" + cashierDetails   );
		
		System.out.println("=========================================");
		String op ;
		System.out.println("1 to edit saved details "  + "\n2 to go back to MAIN MENU");
		
		System.out.println("Enter :...");
		op = Christ.next();
		
		//switch
		switch(op)
		{
		case "1":
			editCashier();
			break;
		case "2":
			Starter();
			break;
		default :
			System.out.println("Wrong option chosen!!");
			System.exit(0);
		}
		//end of switch
		
	}
	//end of method
	
	//new method
	static void editCashier()
	{
		
		//try-cathc
		try
		{
			
			
		String other ;
		System.out.println("please tell us what you want to edit :");
		System.out.println("Enter :...");
		other = Christ.next();
			//if-statement
			if (other.matches("name"))
			{
			cashierDetails.remove(name);
			System.out.println("enter your new name :");
			name = Christ.next();
			cashierDetails.add(0,name);
			System.out.println("detail successfully modified");
			
			System.out.println("Cashier Details :" + cashierDetails   );
			
			}
			//end of if-statement
		
			//else if-statement
			else if  (other.matches("phone"))
			{
			cashierDetails.remove(phone);
			System.out.println("enter your new phone number :");
			phone = Christ.next();
			cashierDetails.add(4,phone);
			System.out.println("detail successfully modified");
			
			System.out.println("Cashier Details :" + cashierDetails   );
			
			}
			//end of else if
			//else if
			else if (other.matches("surname"))
			{
			cashierDetails.remove(surname);
			System.out.println("enter your new surname :");
			surname = Christ.next();
			cashierDetails.add(1,surname);
			System.out.println("detail successfully modified");
			
			System.out.println("Cashier Details :" + cashierDetails   );
			
			}
			// end of else if
		
			//else if
			else if (other.matches("age"))
			{
			cashierDetails.remove(age);
			System.out.println("enter your new age :");
			age = Christ.next();
			cashierDetails.add(3,age);
			System.out.println("detail successfully modified");
			
			System.out.println("Cashier Details :" + cashierDetails   );
			
			}
			//end of else if
			//else statement
			else
			{
				System.out.println("wrong detail entered!!");
				System.exit(0);
			}
			//end of else
		}
		//end of try
		
		catch( Exception e)
		{
			System.out.println("Invalid option!!");
			System.exit(0);
		}
		//end of catch
				
	}
	//end of method
	//displayCashier method
	static void displayCashier()
	{
		
		System.out.println("Cashier Details :" + cashierDetails   );
		
	}
	//end of method
	
		
}
//end of child class