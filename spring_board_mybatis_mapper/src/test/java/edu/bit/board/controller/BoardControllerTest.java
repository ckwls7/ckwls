package edu.bit.board.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bit.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class) 	
@ContextConfiguration(locations={ 
	"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class BoardControllerTest {
	//스프링에서의 테스트
	@Inject
	BoardService boardService;
	@Test
	public void listTest() throws Exception{
		
	}

}