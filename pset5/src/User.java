public class User {
	private int pin;
	private String fname;
	private String lname;
	private int dob;
	private String street;
	private String city;
	private String state;
	private String postal;
	private String phone;
	
	public User(int pin, String lname, String fname, int dob, String street, String city, String state, String postal, String phone) {
		this.lname = lname;
		this.pin = pin;
		this.dob = dob;
		this.fname = fname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postal = postal;
		this.phone = phone;
	}
	public int getPin () {
		return pin;
	}
	public String getFname () {
		return fname;
	}
	public String getLname () {
		return lname;
	}
	public int getDob () {
		return dob;
	}
	public String getStreet () {
		return street;
	}
	public String getCity () {
		return city;
	}
	public String getState () {
		return state;
	}
	public String getPostal () {
		return postal;
	}
	public String getPhone () {
		return phone;
	}
	public void setPin (int pin) {
		this.pin = pin;
	}
	public void setStreet (String street) {
		this.street = street;
	}
	public void setCity (String city) {
		this.city = city;
	}
	public void setState (String state) {
		this.state = state;
	}
	public void setPostal (String postal) {
		this.postal = postal;
	}
	public void setPhone (String phone) {
		this.phone = phone;
	}
}