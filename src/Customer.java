public class Customer {
        private int id;                 // Customer id number
        private String password;        // Customer password
        private String question;        // Customer security question
        private String answer;          // Customer security question answer
        private String name;            // Customer name
        private String address;         // Customer address
        private long cardNumber;        // Customer credit card number
        
        public Customer(){
            
        }
    
        public Customer(int id, String password, String question, String answer, String name, String address, long cardNumber) {
            this.id = id;
            this.password = password;
            this.question = question;
            this.answer = answer;
            this.name = name;
            this.address = address;
            this.cardNumber = cardNumber;
        }
    
        public Customer(int id, String password, String question, String answer) {
            this.id = id;
            this.password = password;
            this.question = question;
            this.answer = answer;
        }
    
        public Customer(int id, String password) {
            this.id = id;
            this.password = password;
        }
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
    
        public String getQuestion() {
            return question;
        }
    
        public void setQuestion(String question) {
            this.question = question;
        }
    
        public String getAnswer() {
            return answer;
        }
    
        public void setAnswer(String answer) {
            this.answer = answer;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getAddress() {
            return address;
        }
    
        public void setAddress(String address) {
            this.address = address;
        }
    
        public long getCardNumber() {
            return cardNumber;
        }
    
        public void setCardNumber(long cardNumber) {
            this.cardNumber = cardNumber;
        }
    
        @Override
        public String toString() {
            return  "\nId: " + id +
                    "\nPassword:" + password +
                    "\nSecurity question: " + question +
                    "\nAnswer: " + answer +
                    "\nName: " + name +
                    "\nAddress: " + address +
                    "\nCredit CardNumber: " + cardNumber;
        }
 }