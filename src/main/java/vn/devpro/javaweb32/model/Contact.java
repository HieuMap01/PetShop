package vn.devpro.javaweb32.model;

public class Contact {
	private String name;
	private String email;
	private String address;
	private String mobile;
	private String message;
	
	public Contact() {
		super();
		
	}

	public Contact(String name, String email, String address, String mobile, String message) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.message = message;
	}
	


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
