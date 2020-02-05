package edu.bit.board.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.bit.board.vo.UserVO;

public class BoardInterceptor extends HandlerInterceptorAdapter{
	
	/*
	 * @Override public boolean preHandle(HttpServletRequest
	 * request,HttpServletResponse response,Object handler) throws IOException{
	 * System.out.println("preHandler 실행"); //session객체를 가져옴 HttpSession session =
	 * request.getSession(); //login처리를 담당하는 사용자 정보를 담고있는 객체를 가져옴 UserVO
	 * member=(UserVO) session.getAttribute("member");
	 * 
	 * if(member == null) { //로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
	 * response.sendRedirect(request.getContextPath()); return false;//더이상 컨트롤러 요청으로
	 * 카지않도록 false로 반환함 } //preHandler의 return은 컨트롤러 요청 uri로 거도되냐 안되냐를 허가하는 의미 //따라서
	 * return로하면 컨트롤러 uri로 가게됨 return true;//공식
	 * 
	 * }
	 * 
	 * @Override public void postHandle( HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
	 * throws Exception{ super.postHandle(request, response, handler, modelAndView);
	 * System.out.println("postHandler 실행");
	 * 
	 * }
	 */
	

}
