package kr.com.ezen;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {

	public static void main(String[] args) {

		try {
			String resource = "kr/com/ezen/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			System.out.println(sqlSessionFactory);

			SqlSession session = sqlSessionFactory.openSession(true);
			
			MapperInterface mapper = session.getMapper(MapperInterface.class);
			
			System.out.println(session);

			MemberVO vo = new MemberVO();
			
			vo.setId(1);
			vo.setName("유비");
			vo.setPhone("010-1111-1111");
			vo.setAddress("경기도 수원시");
			
		//	int result = mapper.insertMember(vo);
		//	System.out.println(result);
			
//			mapper.deleteMember(1);
//			mapper.updateMember(1);

		//	vo = mapper.selectMemberOne(1);
			List<MemberVO> list = mapper.selectMemberList();
			for(MemberVO v2 : list)
			System.out.println(v2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
