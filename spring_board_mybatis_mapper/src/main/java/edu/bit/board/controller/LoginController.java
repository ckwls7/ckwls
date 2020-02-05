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
	
	//�α���
	@RequestMapping(value="/login",method=RequestMethod.POST)//�α����� ������POST
	public String login(HttpServletRequest req, RedirectAttributes rttr) {
		
		System.out.println("login ȣ��");
		//���� ó����� ������httpservlet�ȿ��ִ�
		//���� ���̵� �޾ƿ��¹��(���Ǿ��̵�� ��Ű)
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");//����ȿ��� id�� �޾ƿ�
		String pw = req.getParameter("pw");
		
	    UserVO login = loginService.loginUser(id,pw);
		
		if(login == null) {
			//RedirectAttributes
			//���ΰ�ħ�ϸ� ���󰡴� ������
			rttr.addFlashAttribute("msg",false);//boolean������ε�
		}else {//�α���ó���� ����ó��
			//���ǿ� �����Ѵ�
			//30�е��� ����������� ��밡��
			session.setAttribute("member", login);//�α��εǸ� ����ó�� �κ�	
		}
		return "redirect:/";
	}
	
	
	//�α׾ƿ�
	@RequestMapping(value="/logout")//�α����� ������POST
	public String logout(HttpSession session) {
			
		System.out.println("login ȣ��");
		//���������
		session.invalidate();	
			
		return "redirect:/";
	}	
}
