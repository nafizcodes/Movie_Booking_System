public class Admin {
        private String email;           
        private String password;        
        private String question;        
        private String answer;          
        private String name;            
        private String address;         
        
        public Admin(){
            
        }
 
        public Admin(String email, String password, String question, String answer, String name, String address) {
            this.email = email;
            this.password = password;
            this.question = question;
            this.answer = answer;
            this.name = name;
            this.address = address;
        }
    
        public Admin(String email, String password, String question, String answer) {
            this.email = email;
            this.password = password;
            this.question = question;
            this.answer = answer;
        }
    
        public Admin(String email, String password) {
            this.email = email;
            this.password = password;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
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

        @Override
        public String toString() {
            return  "\nEmail: " + email +
                    "\nPassword:" + password +
                    "\nSecurity question: " + question +
                    "\nAnswer: " + answer +
                    "\nName: " + name +
                    "\nAddress: " + address;
        }
 }
