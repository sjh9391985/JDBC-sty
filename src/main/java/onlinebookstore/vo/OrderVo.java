package onlinebookstore.vo;

public class OrderVo {
	private int number;
	private int ordernumber;
	private int price; 
	private String address;
	private int num;
	private int quantity;
	private String title;
	private int number2;
	
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "OrderVo [number=" + number + ", ordernumber=" + ordernumber + ", price=" + price + ", address="
				+ address + ", num=" + num + ", quantity=" + quantity + ", title=" + title + ", number2=" + number2
				+ "]";
	}
	
	
	
	
}
