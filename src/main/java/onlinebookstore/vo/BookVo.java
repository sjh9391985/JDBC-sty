package onlinebookstore.vo;

public class BookVo {
	
	private int number;
	private int id;
	private String title;
	private int price;
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVo [number=" + number + ", id=" + id + ", title=" + title + ", price=" + price + "]";
	}
	
	
}
