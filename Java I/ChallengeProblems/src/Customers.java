
public class Customers {
	
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String colorOfBMW;
	
	public Customers (String firstName, String lastName, int age, String address, String colorOfBMW){
	
		this.firstName  = firstName;
		this.lastName   = lastName;
		this.age        = age;
		this.address    = address;
		this.colorOfBMW = colorOfBMW;
		
	}

	public void setFirstName(String fn) {
		this.firstName = fn;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String ln) {
		this.lastName = ln;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setColorOfBMW (String color) {
		this.colorOfBMW = color;
	}
	
	public String getColorOfBMW() {
		return this.colorOfBMW;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			throw new IllegalArgumentException();
		}
		
		if(obj instanceof Customers) {
			Customers other = (Customers)obj;
			return lastName == other.getLastName() && firstName == other.getFirstName() && age == other.getAge() 
					&& address == other.getAddress() && colorOfBMW == other.getColorOfBMW();
		}else {
			return false;
		}
	}
		
	
	public String toString() {
		return ("Name: " + firstName + " " + lastName + " , Age: " + age + " , Address: "
				+ address + " , BMW color: " + colorOfBMW + "\n"); 
				
	}
	
	

}
