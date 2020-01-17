package edu.bit.board.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;


@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
	
		model.addAttribute("list",boardService.selectBoardList());	
		
		return "list";
		
	}
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		
		System.out.println("write_view()");
	
		return "write_view";
		
	}

	@RequestMapping("/write")
	public String write(BoardVO boardVO,Model model) {
		
		System.out.println("write()");
		boardService.insertBoard(boardVO);
	
		return "redirect:list";
		
	}	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		
		System.out.println("content_view()");
		
		String bId = request.getParameter("bId");
		model.addAttribute("content_view",boardService.selectBoardOne(bId));
	
		return "content_view";
		
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardVO boardVO,Model model) {
		
		System.out.println("modify()");
		
		boardService.updateBoard(boardVO);
	
		return "redirect:list";
		
	}
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request,Model model) {
		
		System.out.println("reply_view()");
		
		String bId = request.getParameter("bId");
		model.addAttribute("reply_view",boardService.selectBoardOne(bId));
	
		return "reply_view";
		
	}
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO,Model model) {
		
		System.out.println("reply()");
		boardService.writeReply(boardVO); //쿼리를 두번을 날림 (쿼리문 두개가 들어감),
										  //자기자신을insert시키는것과 (자기자신을넣어주고) step을+1시켜줌
	
		return "redirect:list";
		
	}
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO,Model model) {
		
		System.out.println("delete()");
		boardService.Delete(boardVO); //쿼리를 두번을 날림 (쿼리문 두개가 들어감),
										  //자기자신을insert시키는것과 (자기자신을넣어주고) step을+1시켜줌
	
		return "redirect:list";
		
	}
	
	
		
}
