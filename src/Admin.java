public class Admin {
        private int id;                 
        private String password;        
        private String question;        
        private String answer;          
        private String name;            
        private String address;         
        
        public Admin() {
        	
        }
        
		public Admin(int id, String password, String question, String answer, String name, String address) {
			this.id = id;
			this.password = password;
			this.question = question;
			this.answer = answer;
			this.name = name;
			this.address = address;
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
		@Override
		 public String toString() {
            return  "\nId: " + id +
                    "\nPassword:" + password +
                    "\nSecurity question: " + question +
                    "\nAnswer: " + answer +
                    "\nName: " + name +
                    "\nAddress: " + address;
        }
 }
 