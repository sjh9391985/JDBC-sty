package onlinebookstore.test;

import java.util.List;

import onlinebookstore.dao.BookDao;
import onlinebookstore.vo.BookVo;

// 주문 도서 리스트
public class BookDaoTest {
	public static void main(String[] args) {
		displayBookList();
	}

	private static void displayBookList() {
		
		System.out.println("****도서목록 출력하기****");
		
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo: list) {
			String books = String.format("번호: "+vo.getNumber()+", 카테고리번호: "+vo.getId() + ", 제목: "+vo.getTitle()+", 가격: "+vo.getPrice());
			System.out.println(books);
		}
		
	}

}
