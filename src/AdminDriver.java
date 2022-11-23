import java.util.*;

public class AdminDriver {

    private static final Map<Integer, Admin> admins = new HashMap<>();       // User storage - <User ID - User Object>
    Admin admin = null;
    int number;
     
    ArrayList<String> securityQuestions = new ArrayList<>() { {             
        add("1) In what city were you born?");
        add("2) What is the name of your favorite pet?");
        add("3) What is the name of your first school?");
      
    }
};

    Scanner sc = new Scanner(System.in);

    public void printitem()
    {
           System.out.println(admins);
    }

    private final Scanner scan = new Scanner(System.in);


    public void addAdmin(Admin admin) {
        admins.putIfAbsent(admin.getId(), admin);
    }

    public  Admin getAdmin(int id) {
        return admins.get(id);
    }

    public void create() {    //Create account
        int id = 0;
        String password = null;
        String name;
        String address;
        String securityQuestion;
        String answer;
        
        // ID handling
        id = enterID();

        int length = String.valueOf(id).length();

        while (!(length == 4)){
        	System.out.println("Invalid length of ID. Please try again.");
            id = enterID();
            length = String.valueOf(id).length();
        }

        while (checkID(id) || id == 0) {
        	System.out.println("ID value is already taken");
            id = enterID();
        }

        // Password handling
        while (Checker.checkPassword(password)) {
            password = enterPassword();
            if(Checker.checkPassword(password)){
            	System.out.println("Invalid Password!");
            }   
        }

        name = enterName();
        address = enterAddress();

        securityQuestion = selectSecurityQuestion();
        answer = enterSecurityQuestionAnswer();

        admin = new Admin(id, password, securityQuestion, answer, name, address);

        // Confirmation
      
        
        System.out.println("\n***************************************************************************************"
        	+admin.toString() + 
        "\n***************************************************************************************\n"+
        "\nPlease confirm the above information to Create the account" +
                            "\nTo confirm press (y/n):");            
        //char confirmation = scan.next().toLowerCase().charAt(0);
        String input_conf = sc.next();
        if (input_conf.equals("y")){
            addAdmin(admin);
            System.out.println("--------------------Account successfully created-----------------------");
            return;
        }
        //create();
    }

    public Admin login() {      //login
        int id;
        String password;
        
        System.out.println("\nLog in with credentials:");
        id = enterID();
       
        // User ID handling
        if (getAdmin(id) == null || !admins.containsKey(id)) {
        	System.out.println("ID does not exist in the system.\nTry again.");
        
            login();
        }
        password = enterPassword();

        int attempts = 1;                         // Number of attempts user has taken to log in
        // User password handling
        while (!password.equals(getAdmin(id).getPassword())) {
            if (attempts >= 3) {
            	System.out.println("Maximum attempts exceeded. Terminating program.Try again later.");
                System.exit(0);
            }
            System.out.println("Incorrect password. Attempt " + attempts + "/3");
            attempts++;
            password = enterPassword();
        }

        //Security question handling 
         
        System.out.println(getAdmin(id).getQuestion() + "\nAnswer:");
        String reply = sc.next();
        if (reply.equals(getAdmin(id).getAnswer())){
        	System.out.println("\n------------------------------------------------Login successful---------------------------------------------" +
            "\n--------------------------------------Welcome to Movie Booking System!-----------------------------------------");
            admin = getAdmin(id);
            return admin;
        }else{
        	System.out.println("Incorrect Answer, Try again later.\n Thank you.");
            System.exit(0);
        }
        return admin;
    }

    public static void logout(){
    	System.out.println("Logged out successfully!");
    }

    private String selectSecurityQuestion() {
    	
    	
    	System.out.println("Select a security question: "
    			+ "\n1) In what city were you born?" + "\n2) What is the name of your favorite pet?" 
    			+ "\n3) What is the name of your first school?");
    	int selection_int = sc.nextInt();
//
//        for (String securityQuestion : securityQuestions) {
//            System.out.println(securityQuestion);
//        }

        

        return securityQuestions.get(selection_int -1);  //for index starting at 0
    }

    private int enterID() {
    	System.out.println("\nEnter the 4 digit Id: ");
    	int input_id = sc.nextInt();
        return input_id;
    }

    private String enterPassword() {
    	System.out.println("Enter a password: \n(Password must be at least a digit, a special character( @, #, $, %, &, and *) and upper case Alphabet)");
    	String input_pass = sc.next();
    	return input_pass;
    }

    private String enterName() {
    	System.out.println("Enter your name: ");
    	String input_name = sc.next();
        return input_name;
    }

    private String enterAddress() {
    	System.out.println("Enter your address: ");
    	String input_add = sc.next();
        return input_add;
    }
           
    private String enterSecurityQuestionAnswer() {
    	System.out.println("Enter the answer: ");
    	String input_ans = sc.next();
        return input_ans;
    }

    private boolean checkID(int id) {
        return admins.containsKey(id);
    }
}