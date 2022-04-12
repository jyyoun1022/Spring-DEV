package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration	//Servlet의 Servlet의 ServletContext를 이용하기 위해서 사용
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardControllerTests {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext ctx;
	
	@Before
	public void setup() {
		this.mockMvc =MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	@Test
	public void testList() throws Exception {
		
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	@Test
	public void testRegister()throws Exception {
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title","목 테스트 새 글" )
				.param("content", "목테스트 내용")
				.param("writer", "USER98")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
		
		
	}
	@Test
	public void testGet() throws Exception{
		
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "10"))
				.andReturn()
				.getModelAndView().getModelMap());
	}
	@Test
	public void testModify()throws Exception {
		
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "1")
				.param("title", "수정된 테스트 새글 제목")
				.param("content", "수정된 테스트 새글 내용")
				.param("writer", "User98"))
		.andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	@Test
	public void testRemove()throws Exception {
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "1")
				).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	@Test
	public void testListPaging()throws Exception {
		
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "3")
				.param("size", "10"))
				.andReturn().getModelAndView().getModelMap());
		
	}
	
	

}
