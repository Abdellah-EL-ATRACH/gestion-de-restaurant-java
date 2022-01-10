package models;

public class Client {
	private String name;
	private String  email;
	private String tel;
	private String password;
	public Client() {
		super();
	}
	public Client(String n,String e, String t,String p) {
		super();
		this.name=n;
		this.email=e;
		this.tel=t;
		this.password=p;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
