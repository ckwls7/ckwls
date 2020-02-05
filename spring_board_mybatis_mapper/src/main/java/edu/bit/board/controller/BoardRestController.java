package edu.bit.board.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

//@Controller + @ResponseBody : RestController ->모든함수,모든객체 들을 제이슨으로 바꿔버림
@RestController
@RequestMapping("/rest/*")
public class BoardRestController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list")//레스트리스트로 치고들어오는것은
	public List<BoardVO> list(Model model) {
		
		System.out.println("list()");
		
		/* model.addAttribute("list",boardService.selectBoardList()); */	
		
		return boardService.selectBoardList();
		
	}
	
}
