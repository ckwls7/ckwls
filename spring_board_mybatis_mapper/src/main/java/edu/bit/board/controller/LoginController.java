package edu.bit.board.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.vo.UserVO;


@Controller
@RequestMapping("/member")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	//로그인
	@RequestMapping(value="/login",method=RequestMethod.POST)//로그인은 무조건POST
	public String login(HttpServletRequest req, RedirectAttributes rttr) {
		
		System.out.println("login 호출");
		//세션 처리방법 세션은httpservlet안에있다
		//세션 아이디를 받아오는방법(세션아이디는 쿠키)
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");//여기안에서 id를 받아옴
		String pw = req.getParameter("pw");
		
	    UserVO login = loginService.loginUser(id,pw);
		
		if(login == null) {
			//RedirectAttributes
			//새로고침하면 날라가는 데이터
			rttr.addFlashAttribute("msg",false);//boolean방법으로들어감
		}else {//로그인처리는 세션처리
			//세션에 저장한다
			//30분동안 어느페이지든 사용가능
			session.setAttribute("member", login);//로그인되면 세션처리 부분	
		}
		return "redirect:/";
	}
	
	
	//로그아웃
	@RequestMapping(value="/logout")//로그인은 무조건POST
	public String logout(HttpSession session) {
			
		System.out.println("login 호출");
		//세션지우기
		session.invalidate();	
			
		return "redirect:/";
	}	
}
