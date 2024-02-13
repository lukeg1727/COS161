
public class ClearPassword {

	private String userName;
	private String password;
	
	public ClearPassword(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	
	public String toString() {
		return ("<" + userName + "," + password + ">");
	}
	public Boolean verify(String password) {
		
	}
}
