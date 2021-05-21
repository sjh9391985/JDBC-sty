package onlinebookstore.test;

import java.util.List;

import onlinebookstore.dao.CartDao;
import onlinebookstore.vo.CartVo;



public class CartDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayCartList();
	}
	
private static void displayCartList() {
		
		System.out.println("****카트목록 출력하기****");
		
		List<CartVo> list = new CartDao().findAll();
		for(CartVo vo: list) {
			String cart = String.format("책번호: "+vo.getNumber()+"고객번호: "+vo.getNum() +"수량: "+ vo.getQuantity());
			System.out.println(cart);
			
			
		}
		
	}

}
