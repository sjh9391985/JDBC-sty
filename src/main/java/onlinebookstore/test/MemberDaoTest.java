package onlinebookstore.test;

import java.util.List;

import onlinebookstore.dao.MemberDao;
import onlinebookstore.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {

		displayMember();

	}

	private static void displayMember() {
		
		System.out.println("****회원 정보 출력****");
		
		List<MemberVo> list = new MemberDao().findAll();
		for(MemberVo vo : list) {
			String infos = String.format("번호: "+vo.getNum()+ ",이름: "+vo.getName()+", 이메일: "+vo.getEmail()+", 비밀번호: "+ vo.getPassword() +", 전화번호: "+vo.getPhonenumber());
			System.out.println(infos);
			
		}
		
	}

}
