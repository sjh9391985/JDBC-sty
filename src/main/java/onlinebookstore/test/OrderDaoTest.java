package onlinebookstore.test;

import java.util.List;

import onlinebookstore.dao.OrderDao;
import onlinebookstore.vo.OrderVo;


public class OrderDaoTest {

	public static void main(String[] args) {
		displayOrderList();
		displayOrderList1();
	}

	private static void displayOrderList() {

		System.out.println("****주문목록 출력하기****");

		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			String order = String.format("번호: "+vo.getNumber() + ", 주문번호: "+vo.getOrdernumber()+", 결제금액: "+vo.getPrice()+ ", 배송지: "+vo.getAddress());
			System.out.println(order);
			System.out.println("--------------------------------------------------------------------");		
			
		
		}

	}
	
	private static void displayOrderList1() {

		System.out.println("****주문도서 출력하기****");

		List<OrderVo> list = new OrderDao().findAll1();
		for (OrderVo vo : list) {
			String order = String.format("책번호: "+ vo.getNumber2()+", 주문번호: "+vo.getNumber()+", 수량: "+vo.getQuantity()+", 제목: "+vo.getTitle());
			System.out.println(order);
		}

	}
}
