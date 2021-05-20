package hr;
import java.util.List;
import java.util.Scanner;

public class HRMain2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Salary[min max]> ");
		
		int minSalary = sc.nextInt();
		int maxSalary = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.findBySalary(minSalary, maxSalary);
		
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
		sc.close();
	}

}