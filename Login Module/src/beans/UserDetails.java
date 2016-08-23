package beans;

public class UserDetails {
	private String username;
	private String password;
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserDetails() {
		
	}
	
	public UserDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validate() {
		
		if(username == null) {
			message = "Invalid username address";
			return false;
		}
		
		if(password == null) {
			message = "Invalid password";
			return false;
		}
		
		if(!username.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid username address";
			return false;
		}
		
		if(password.length() < 8) {
			message = "Password must be at least 8 characters.";
			return false;
		}
		else if(password.matches("\\w*\\s+\\w*")) {
			message = "Password cannot contain space.";
			return false;
		}
		
		return true;
	}



}
