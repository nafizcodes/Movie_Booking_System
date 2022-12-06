import java.util.*;
import java.io.*;
public class AdminDriver {

    private static final Map<String, Admin> admins = new HashMap<>(); // User storage - <User ID - User Object>
    Admin admin = null;
    int number;

    ArrayList<String> securityQuestions = new ArrayList<>() {
        {
            add("1) In what city were you born?");
            add("2) What is the name of your favorite pet?");
            add("3) What is the name of your first school?");

        }
    };

    Scanner sc = new Scanner(System.in);
    
    public void storeInfo() throws IOException {
	    FileWriter fw = null;
		
	    try {
	        fw = new FileWriter("src/userDetails.txt", false);
	        for(Map.Entry<String, Admin> entry : admins.entrySet()) {
	        	fw.write(entry.getKey() + ":" + entry.getValue() + "\n");
	        }
	        System.out.println("Data Successfully appended into file");
	
	    } finally {
	        try {
	            fw.close();
	        } catch (IOException io) {// can't do anything }
	        }
	
	    }
    }
    public void checkData() throws IOException {
    	BufferedReader br = null;
    	File file = new File("src/userDetails.txt");
    	br = new BufferedReader(new FileReader(file));
    	String line = null;
    	while((line = br.readLine())!= null) {
    		String[] parts = line.split(":");   	
    		String username = parts[0].trim();
    		String adminDetails = parts[1].trim();
    		String[] details = adminDetails.split(",");
    		String password = details[0].trim();
    		String securityQ = details[1].trim();
    		String securityA = details[2].trim();
    		String name = details[3].trim();
    		String address = details[4].trim();
    		admin = new Admin(username, password, securityQ, securityA, name, address);
    		admins.put(username, admin);
    	}
    	br.close();
    }
    public void printitem() {
        System.out.println(admins);
    }

    private final Scanner scan = new Scanner(System.in);

    public void addAdmin(Admin admin) {
        admins.putIfAbsent(admin.getEmail(), admin);
    }

    public Admin getAdmin(String email) {
        return admins.get(email);
    }

    public void create() { // Create account
        String email = null;
        String password = null;
        String name;
        String address;
        String securityQuestion;
        String answer;

        // ID handling
        email = enterEmail();

        while (checkEmail(email) || email == null) {
            System.out.println("Email is already taken");
            email = enterEmail();
        }

        // Password handling
        while (Checker.checkPassword(password)) {
            password = enterPassword();
            if (Checker.checkPassword(password)) {
                System.out.println("Invalid Password!");
            }
        }

        name = enterName();
        address = enterAddress();

        securityQuestion = selectSecurityQuestion();
        answer = enterSecurityQuestionAnswer();

        admin = new Admin(email, password, securityQuestion, answer, name, address);

        // Confirmation

        System.out.println("\n***************************************************************************************"
                + admin.printString() +
                "\n***************************************************************************************\n" +
                "\nPlease confirm the above information to Create the account" +
                "\nTo confirm press (y/n):");
        // char confirmation = scan.next().toLowerCase().charAt(0);
        String input_conf = sc.next();
        if (input_conf.equals("y")) {
            addAdmin(admin);
            System.out.println("--------------------Account successfully created-----------------------");
            return;
        }
        // create();
    }

    public Admin login() { // login
    	
        String email;
        String password;

        System.out.println("\nLog in with credentials:");
        email = enterEmail();

        // User ID handling
        if (getAdmin(email) == null || !admins.containsKey(email)) {
            System.out.println("Email does not exist in the system.\nTry again.");

            login();
        }
        password = enterPassword();

        int attempts = 1; // Number of attempts user has taken to log in
        // User password handling
        while (!password.equals(getAdmin(email).getPassword())) {
            if (attempts >= 3) {
                System.out.println("Maximum attempts exceeded. Terminating program.Try again later.");
                System.exit(0);
            }
            System.out.println("Incorrect password. Attempt " + attempts + "/3");
            attempts++;
            password = enterPassword();
        }

        // Security question handling

        System.out.println(getAdmin(email).getQuestion() + "\nAnswer:");
        String reply = sc.next();
        if (reply.equals(getAdmin(email).getAnswer())) {
            System.out.println(
                    "\n------------------------------------------------Login successful---------------------------------------------"
                            +
                            "\n--------------------------------------Welcome to Movie Booking System!-----------------------------------------\n\n");

            admin = getAdmin(email);
            return admin;
        } else {
            System.out.println("Incorrect Answer, Try again later.\n Thank you.");
            System.exit(0);
        }
        return admin;
    }

    public static void logout() {
        System.out.println("Logged out successfully!");
    }

    private String selectSecurityQuestion() {

        System.out.println("Select a security question: "
                + "\n1) In what city were you born?" + "\n2) What is the name of your favorite pet?"
                + "\n3) What is the name of your first school?");
        int selection_int = sc.nextInt();
        //
        // for (String securityQuestion : securityQuestions) {
        // System.out.println(securityQuestion);
        // }

        return securityQuestions.get(selection_int - 1); // for index starting at 0
    }

    private String enterEmail() {
        System.out.println("\nEnter the email address: ");
        String input_email = sc.next();
        return input_email;
    }

    private String enterPassword() {
        System.out.println(
                "Enter a password: \n(Password must be at least a digit, a special character( @, #, $, %, &, and *) and upper case Alphabet)");
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

    private boolean checkEmail(String email) {
        return admins.containsKey(email);
    }
}