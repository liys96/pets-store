package edu.lys.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import edu.lys.dao.ICart;
import edu.lys.dao.ICustomer;
import edu.lys.dao.impl.CartImpl;
import edu.lys.dao.impl.CustomerImpl;
import edu.lys.entity.Customer;
import edu.lys.entity.Page;
import edu.lys.utils.ExchangeRequestMap;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends Upload {
	private static final long serialVersionUID = 1L;
	ICustomer customerImpl = new CustomerImpl();
	private static Logger logger = Logger.getLogger(Log4JTestServlet.class);
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if ("customerRegister".equals(method)) {
			customerRegister(request, response);
		} else if ("customerLogin".equals(method)) {
			customerLogin(request, response);
		} else if ("customerLogout".equals(method)) {
			customerLogout(request, response);
		} else if ("customerList".equals(method)) {
			customerList(request, response);
		} else if ("searchCustomerById".equals(method)) {
			searchCustomerById(request, response);
		} else if ("updateState".equals(method)) {
			updateState(request, response);
		}
		Map map = ExchangeRequestMap.getParameterMap(request);
		
		logger.info("请求入参:"+map.toString()+"\n");
	}

	// 客户注册
	public void customerRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取页面表单传过来的所有数据
		Map<String, String> map = upload(request, response);
		String customerName = map.get("customerName");
		String customerHeadPic = map.get("headPic");
		String customerSex = map.get("customerSex");
		String phoneNumber = map.get("phoneNumber");
		String customerAccount = map.get("customerAccount");
		String loginPassword = map.get("loginPassword");
		String payPassword = map.get("payPassword");
		String receivedAddress = map.get("receivedAddress");
		// 注册验证，资料不能有空
		if ("".equals(customerName) || "".equals(customerHeadPic) || "".equals(customerSex) || "".equals(phoneNumber)
				|| "".equals(customerAccount) || "".equals(loginPassword) || "".equals(payPassword)
				|| "".equals(receivedAddress)) {
			String result = "isNull";
			request.setAttribute("result", result);
			request.getRequestDispatcher("/forward/reg.jsp").forward(request, response);
		} else {
			// 先判断该账号是否存在
			boolean flag = customerImpl.checkAccountExists(customerAccount);
			if (!flag) {
				String result = "fail";
				request.setAttribute("result", result);
				request.getRequestDispatcher("/forward/reg.jsp").forward(request, response);
			} else {
				Customer customer = new Customer();
				customer.setCustomerName(customerName);
				customer.setCustomerHeadPic(customerHeadPic);
				customer.setCustomerSex(customerSex);
				customer.setPhoneNumber(phoneNumber);
				customer.setLoginPassword(loginPassword);
				customer.setPayPassword(payPassword);
				customer.setReceivedAddress(receivedAddress);
				customer.setCustomerAccount(customerAccount);
				customerImpl.customerRegister(customer);
				String result = "success";
				request.setAttribute("result", result);
				request.getRequestDispatcher("/forward/reg.jsp").forward(request, response);
			}
		}

	}

	// 客户登录
	public void customerLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ICart cartImpl = new CartImpl();
		String customerAccount = request.getParameter("customerAccount");
		String loginPassword = request.getParameter("loginPassword");
		Customer customer = new Customer();
		customer.setCustomerAccount(customerAccount);
		customer.setLoginPassword(loginPassword);
		String flag = customerImpl.customerLogin(customer);
		if ("".equals(customerAccount) || "".equals(loginPassword)) {
			String result = "isNull";
			request.setAttribute("result", result);
			request.getRequestDispatcher("/forward/login.jsp").forward(request, response);
		} else {
			if ("1".equals(flag)) { // 1 登录成功 2 密码或用户名错误 0 用户被注销
				String result = "success";
				request.setAttribute("result", result);
				Customer customer1 = customerImpl.searchCustomerNameByAccount(customerAccount);
				int arr[] = cartImpl.searchCartAmount(customer1.getCustomerId());
				request.getSession().setAttribute("arr", arr);
				HttpSession ses = request.getSession();
				ses.setMaxInactiveInterval(-1);
				ses.setAttribute("customer", customer1);
				request.getRequestDispatcher("/forward/login.jsp").forward(request, response);
			} else if ("2".equals(flag)) {
				String result = "fail";
				request.setAttribute("result", result);
				request.getRequestDispatcher("/forward/login.jsp").forward(request, response);
			} else if ("0".equals(flag)) {
				String result = "isRgst";
				request.setAttribute("result", result);
				request.getRequestDispatcher("/forward/login.jsp").forward(request, response);
			}
		}

	}

	// 客户注销
	public void customerLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("customer");
		request.getSession().removeAttribute("arr");
		request.setAttribute("login", "login");
		request.getRequestDispatcher("/forward/index.jsp").forward(request, response);
	}

	// 后台页面浏览所有客户
	public void customerList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page<Customer> page = new Page<Customer>();
		page.setEntity(new Customer());
		String customerName = request.getParameter("customerName");
		String customerAccount = request.getParameter("customerAccount");
		String customerState = request.getParameter("customerState");
		int num = -1;
		if (customerState != null && !"".equals(customerState)) {
			num = Integer.parseInt(customerState);
		}
		page.getEntity().setCustomerName(customerName);
		page.getEntity().setCustomerAccount(customerAccount);
		page.getEntity().setState(num);
		page.setPageSize(4);
		// 计算当前页
		String currentPage = request.getParameter("currentPage");
		int cp = 1;
		if (currentPage != null && !"".equals(currentPage)) {
			cp = Integer.parseInt(currentPage);
		}
		page.setCurrentPage(cp);

		List<Customer> list = customerImpl.searchAllCustomer(page);
		int totalCount = customerImpl.searchCount(page);
		page.setTotalCount(totalCount);
		page.setList(list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/back/customer/customerList.jsp").forward(request, response);
	}

	// 查看客户详情
	public void searchCustomerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("customerId");
		int num = -1;
		if (customerId != null && !"".equals(customerId)) {
			num = Integer.parseInt(customerId);
		}
		Customer customer = customerImpl.searchCustomerById(num);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/back/customer/customerView.jsp").forward(request, response);
	}

	// 修改客户状态
	public void updateState(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("custId");
		String customerState = request.getParameter("custState");
		int num = -1;
		int num1 = -1;
		if (customerState != null && !"".equals(customerState)) {
			num = Integer.parseInt(customerState);
		}
		if (customerId != null && !"".equals(customerId)) {
			num1 = Integer.parseInt(customerId);
		}
		if (num == 0) {
			customerImpl.recoverCustomerById(num1);
		} else if (num == 1) {
			customerImpl.cancelCustomerById(num1);
		}
		customerList(request, response);
	}

}
