package org.zerock.persistence;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JDBCTests {

	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
//	 @Test
//	    public void testFactory(){
//	        System.out.println("\n >>>>>>>>>> sqlFactory 출력 : "+sqlSessionFactory);
//	    }

	    @Test
	    public void testSession() throws Exception{

	        try(SqlSession session = sqlSessionFactory.openSession()){

	            System.out.println(" >>>>>>>>>> session 출력 : "+session+"\n");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
