package pack2;

		import java.util.Scanner;

		public class Lab5{
			String Firstname;
			String Secondname;
			char  Gender ;
			String phone;
			enum gen{
				m,f};

			public Lab5(String Firstname, String Secondname, char Gender) {
				// TODO Auto-generated constructor stub
				this.Firstname=Firstname;
				this.Secondname=Secondname;
				this.Gender=Gender;
				
				
			}
			public String getFirstname() {
				return Firstname;
			}
			public void setFirstname(String Firstname) {
				this.Firstname=Firstname;
			}
			public String getSecondname() {
				return Secondname;
			}
			public void setSecondname(String Secondname) {
				this.Secondname=Secondname;
			}
			public char getGender() {
				return Gender;
			}
			public void setAge(char  Gender) {
				this.Gender=Gender;
			}
			public String getphone() {
				return phone;
			}
			public void setphone(String phone) {
				this.phone=phone;
			}
			public void acceptPhoneNumber() {
		        Scanner sc = new Scanner(System.in);
		        System.out.print("Enter phone number: ");
		        this.phone = sc.nextLine();
		    }

			public void display() {
				Scanner sc=new Scanner(System.in);
				System.out.println("First Name: "+getFirstname());
				System.out.println("Second Name: "+getSecondname());
				System.out.println("gender: "+getGender());
				//System.out.println("phone: "+getphone());
				
				
			}
			
			
		// TODO Auto-generated method stub

	}


