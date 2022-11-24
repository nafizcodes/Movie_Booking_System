import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerDriver c = new CustomerDriver();
		AdminDriver a = new AdminDriver();
		
		boolean notexit = true;
		int input = 0 ;
		String choice;

		System.out.print("\n\n");
		System.out.println("Welcome to Movie Booking System ");
		System.out.println("\n*****Choose the User Type*****\nIf you are a Customer, Press(c)\nIf you are Admin, Press(a) \n Option: ");
		choice = sc.nextLine();
		
		while(notexit) {
			
			if(choice.equals( "c")) {
			System.out.println("--------------------------Welcome to Customer's Portal-----------------------------------");
			System.out.println("\n\n1.Create Account. \n2.Login  \n3.Exit \nChoose Option: ");
			
		    int input_int = sc.nextInt();
		
		    switch(input_int){
		      case 1:
		      c.create();
		      
		      break;
		      
		      case 2:
		      c.login();
		      
		      System.exit(0);
		      break;
		      
		      
		      case 3:
		      System.out.println("Terminating from the program!");
		      notexit = false;
		      break;
		
		      default:
		      break;
		}
		
	}
			
			 
			 if (choice.equals("a")) {
					System.out.println("--------------------------Welcome to Admin's Portal-----------------------------------");
					System.out.println("\n\n1.Create Account. \n2.Login  \n3.Exit \nChoose Option: ");
				    int input_int = sc.nextInt();
				//
		    switch(input_int){
		      case 1:
		      a.create();
		      break;
		
		      case 2:
		      a.login();
		    
		      System.exit(0);
		      
		      break;
		
		      case 3:
		      System.out.println("Terminating from the program!");
		      notexit = false;
		      break;
		
		      default:
		      break;
		      
		}
		 }
}
		System.exit(0);
}
	
}



