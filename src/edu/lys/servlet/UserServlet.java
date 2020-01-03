package edu.lys.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.lys.dao.IUser;
import edu.lys.dao.impl.UserImpl;
import edu.lys.entity.Page;
import edu.lys.entity.User;
import edu.lys.utils.ExchangeRequestMap;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUser userImpl = new UserImpl();
	private static Logger logger = Logger.getLogger(Log4JTestServlet.class);

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if ("userList".equals(method)) {
			userList(request, response);
		} else if ("addUser".equals(method)) {
			addUser(request, response);
		} else if ("updateState".equals(method)) {
			updateState(request, response);
		} else if ("deleteUser".equals(method)) {
			deleteUser(request, response);
		} else if ("searchUserById".equals(method)) {
			searchUserById(request, response);
		} else if ("updateUser".equals(method)) {
			updateUser(request, response);
		} else if ("userLogin".equals(method)) {
			userLogin(request, response);
		}else if ("userLogout".equals(method)) {
			userLogout(request, response);
		}
		Map map = ExchangeRequestMap.getParameterMap(request);
		
		logger.info("请求入参:"+map.toString()+"\n");
		
	}

	// 浏览所有用户
	public void userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page<User> page = new Page<User>();
		page.setEntity(new User());
		String userName = request.getParameter("userName");
		String userAccount = request.getParameter("userAccount");
		String userState = request.getParameter("userState");
		int num = -1;
		if (userState != null && !"".equals(userState)) {
			num = Integer.parseInt(userState);
		}
		page.getEntity().setUserName(userName);
		page.getEntity().setUserAccount(userAccount);
		page.getEntity().setState(num);
		page.setPageSize(4);
		// 计算当前页
		String currentPage = request.getParameter("currentPage");
		int cp = 1;
		if (currentPage != null && !"".equals(currentPage)) {
			cp = Integer.parseInt(currentPage);
		}
		page.setCurrentPage(cp);
		List<User> list = userImpl.searchAllUser(page);
		int totalCount = userImpl.searchCount(page);
		page.setTotalCount(totalCount);
		page.setList(list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/back/customer/userList.jsp").forward(request, response);
	}

	// 添加用户
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String userAccount = request.getParameter("userAccount");
		String userPassword = request.getParameter("userPassword");
		User user = new User();
		user.setUserName(userName);
		user.setUserAccount(userAccount);
		user.setUserPassword(userPassword);
		boolean flag = userImpl.addUser(user);
		if (flag) {
			request.setAttribute("success", "success");
			request.getRequestDispatcher("/back/customer/userAdd.jsp").forward(request, response);
		} else {
			request.setAttribute("fail", "fail");
			request.getRequestDispatcher("/back/customer/userAdd.jsp").forward(request, response);
		}

	}

	// 修改用户状态
	public void updateState(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String userState = request.getParameter("userState");
		int num = -1;
		int num1 = -1;
		if (userState != null && !"".equals(userState)) {
			num = Integer.parseInt(userState);
		}
		if (userId != null && !"".equals(userId)) {
			num1 = Integer.parseInt(userId);
		}
		if (num == 0) {
			boolean flag = userImpl.recoverUserById(num1);
			if(flag) {
				userList(request, response);
			}
		} else if (num == 1) {
			boolean flag = userImpl.cancelUserById(num1);
			if(flag) {
				userList(request, response);
			}
		}
		/*request.setAttribute("success", "success");
		request.getRequestDispatcher("/back/customer/userList.jsp").forward(request, response);*/
	}

	// 删除用户
	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		int num = -1;
		if (userId != null && !"".equals(userId)) {
			num = Integer.parseInt(userId);
		}
		boolean flag = userImpl.deleteUser(num);
		if(flag) {
			userList(request, response);
		}
		
	}

	// 查看用户用户
	public void searchUserById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		int num = -1;
		if (userId != null && !"".equals(userId)) {
			num = Integer.parseInt(userId);
		}
		User user = userImpl.searchUserById(num);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/back/customer/userUpdate.jsp").forward(request, response);

	}

	// 修改用户信息
	public void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userState = request.getParameter("state");
		int num = -1;
		int num1 = -1;
		if (userId != null && !"".equals(userId)) {
			num = Integer.parseInt(userId);
		}
		if (userState != null && !"".equals(userState)) {
			num1 = Integer.parseInt(userState);
		}
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setState(num1);
		user.setUserId(num);
		boolean flag = userImpl.updateUserInfo(user);
		if (flag) {
			request.setAttribute("success", "success");
			request.getRequestDispatcher("/back/customer/userUpdate.jsp").forward(request, response);
		}

	}

	// 用户登录
	public void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userAccount = request.getParameter("userAccount");		
		String userPassword = request.getParameter("userPassword");
		User user = new User();
		user.setUserAccount(userAccount);
		user.setUserPassword(userPassword);
		String flag = userImpl.userLogin(user);
		if ("1".equals(flag)) {
			String name = userImpl.searchUserNameByAccount(userAccount);
			request.setAttribute("result", "success");
			request.getSession().setAttribute("userName",name );
			request.getRequestDispatcher("/back/login.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			request.setAttribute("result", "2");
			request.getRequestDispatcher("/back/login.jsp").forward(request, response);
		}else if("0".equals(flag)) {
			request.setAttribute("result", "0");
			request.getRequestDispatcher("/back/login.jsp").forward(request, response);
		}

	}
	
	//用户注销
		public void userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub		
			request.getSession().removeAttribute("userName");
			response.sendRedirect("back/login.jsp");					
		}

}
