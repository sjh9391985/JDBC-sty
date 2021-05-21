package onlinebookstore.test;

public class OnlineBookMall {

	public static void main(String[] args) {

		MemberDaoTest mt = new MemberDaoTest();
		mt.main(args);
		System.out.println("--------------------------------------------------------------------");
		
		CategoryDaoTest category = new CategoryDaoTest();
		category.main(args);
		System.out.println("--------------------------------------------------------------------");		
		
		BookDaoTest book = new BookDaoTest();
		book.main(args);
		System.out.println("--------------------------------------------------------------------");		
		
		CartDaoTest cart = new CartDaoTest();
		cart.main(args);
		System.out.println("--------------------------------------------------------------------");		
		
		OrderDaoTest ordert = new OrderDaoTest();
		ordert.main(args);
		
		
		
		
	}

}
