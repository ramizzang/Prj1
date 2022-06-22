package notice.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;

public class LogoutProcController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LogoutProcController pass");
		
		request.getSession().invalidate(); //로그아웃 할거라 세션 비워주기
		response.sendRedirect("../customer/notice.do");
	}

}
