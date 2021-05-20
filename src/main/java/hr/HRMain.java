package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("이름>>");
		String name = sc.nextLine();
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.findByName(name);
		for(EmployeeVo vo: list) {
			System.out.println(vo);
		}
		
		
	}
}
