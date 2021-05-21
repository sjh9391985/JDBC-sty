package onlinebookstore.test;

import java.util.List;

import onlinebookstore.dao.CategoryDao;
import onlinebookstore.dao.MemberDao;
import onlinebookstore.vo.CategoryVo;
import onlinebookstore.vo.MemberVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayCategory();
	}
	
private static void displayCategory() {
		
		System.out.println("****카테고리 정보 출력****");
		
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			String infos = String.format("번호: "+ vo.getId() +", 장르: "+ vo.getGenre());
			System.out.println(infos);
			
		}
		
	}

}
