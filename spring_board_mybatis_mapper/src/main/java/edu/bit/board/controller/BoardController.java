package edu.bit.board.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageMaker;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;


@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model,HttpSession session) {
		System.out.println("list()");
		
		
		/*
		 * UserVO member = (UserVO) session.getAttribute("member");
		 * 
		 * //첫번째 방법 if(member == null) { System.out.println("멤버세션값 없음"); return
		 * "redirect:/"; }
		 */
	
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
		boardService.Delete(boardVO); 
	
		return "redirect:list";
		
	}
	
	@RequestMapping("/list2")
	//디폴트생성자로 ioc컨테이너가 알아서 객체를 생성해서 가져옴
	public String list2(Criteria criteria,Model model) {
		System.out.println("list2()");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		System.out.println(criteria.getPerPageNum());
		System.out.println(criteria.getPage());
		
		int totalCount = boardService.selectCountBoard();
		System.out.println("전체 게시물 수를 구함:" + totalCount);
		
		//전체값 세팅
		pageMaker.setTotalCount(totalCount);
		//가장최신순의 게시판10개를가져옴
		//10개의 게시판중 중간에 하나가 삭제될때 비어있는 공간까지 10개를 가져오는 쿼리가 어려움
		//mysql에서는 리미트에서 10까지 가져올수있는데 지원을안함 11버전까지 그래서 sql쿼리문이 어려움
		List<BoardVO> boardList = boardService.selectBoardListPage(criteria);
		
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageMaker",pageMaker);
		
		return "list2";
		
	}	
}
