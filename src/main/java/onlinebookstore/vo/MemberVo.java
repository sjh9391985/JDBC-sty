package onlinebookstore.vo;

public class MemberVo {
	
	private int num;
	private String name;
	private String email;
	private int password;
	private int phonenumber;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "MemberVo [num=" + num + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phonenumber=" + phonenumber + "]";
	}
	
	
}
