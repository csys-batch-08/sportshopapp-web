package SihgnUp;

public class UserReg {
	private String user_name;
	private String address;
	private String first_name;
	private String last_name;
	private String email;
	private long phone;
	private String password;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		}
	public UserReg() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public UserReg(String user_name, String address, String first_name, String last_name, String email, long phone,
			String password) {
		super();
		this.user_name = user_name;
		this.address = address;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserReg [user_name=" + user_name + ", address=" + address + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", phone=" + phone + ", password=" + password + "]";
	}
	
}
