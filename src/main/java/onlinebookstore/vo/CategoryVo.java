package onlinebookstore.vo;

public class CategoryVo {

	private int id;
	private String genre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "CategoryVo [id=" + id + ", genre=" + genre + "]";
	}
	
	
}
