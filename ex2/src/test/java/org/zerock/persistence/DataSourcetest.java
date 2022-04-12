package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourcetest {
	
	@Autowired
	private DataSource da;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	@Test
  public void testConnection() throws Exception {
      try (Connection con = da.getConnection();
    		  SqlSession session = sqlSessionFactory.openSession();
    		  ) {
          System.out.println(con);
  		System.out.println("session=" + session);

      } catch (Exception e) {
          e.printStackTrace();
      }
  }
	}




