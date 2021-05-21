package onlinebookstore.vo;

public class CartVo {

	private int number;
	private int num;
	private int quantity;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	@Override
	public String toString() {
		return "CartVo [number=" + number + ", num=" + num + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}
