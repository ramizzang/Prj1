package notice.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.MemberDao;
import notice.vo.Member;

public class LoginProcController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginProcController pass");
		
		String uid=request.getParameter("id");
		String pwd=request.getParameter("password");
		
		MemberDao dao= new MemberDao();
		Member m=dao.getMember(uid);
		
		if(m==null) { //m에 아무것도 담기지 않으면 아이디가 없다는것
			request.setAttribute("error", "아이디 없음");
			request.getRequestDispatcher("loginform.jsp").forward(request, response);
		}if(!m.getPwd().equals(pwd)) { //입력한 비번과 db비번이 일치하지 않는다면
			request.setAttribute("error", "비밀번호 확인");
			request.getRequestDispatcher("loginform.jsp").forward(request, response);
		}else {//아이디 존재 비번일치 세션에 아이디 담아서 notice로 이동
			request.getSession().setAttribute("uid", uid);
			response.sendRedirect("../customer/notice.do");
		}
		
		request.getRequestDispatcher("loginform.jsp").forward(request, response);
	}

}
