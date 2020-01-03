package edu.lys.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.lys.dao.ICart;
import edu.lys.dao.IOrder;
import edu.lys.dao.impl.CartImpl;
import edu.lys.dao.impl.OrderImpl;
import edu.lys.entity.Commodity;
import edu.lys.entity.Customer;
import edu.lys.entity.Order;
import edu.lys.entity.OrdercommodityVO;
import edu.lys.entity.Shopcart;
import edu.lys.entity.ShopcartVO;
import edu.lys.utils.ExchangeRequestMap;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ICart cartImpl = new CartImpl();
    IOrder orderImpl = new OrderImpl();
    private static Logger logger = Logger.getLogger(Log4JTestServlet.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if("addCart".equals(method)) {
			addCart(request,response);
		}else if("cartView".equals(method)) {
			cartView(request,response);
		}else if("deleteCart".equals(method)) {
			deleteCart(request,response);
		}else if("clearCart".equals(method)) {
			clearCart(request,response);
		}else if("checkPay".equals(method)) {
			checkPay(request,response);
		}else if("addcOrder".equals(method)) {
			addcOrder(request,response);
		}
		Map map = ExchangeRequestMap.getParameterMap(request);
		
		logger.info("请求入参:"+map.toString()+"\n");
	}

	//添加购物车
	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String cId = request.getParameter("cId");
		String cAmount = request.getParameter("cAmount");
		String cPrice = request.getParameter("cPrice");
		Shopcart cart = new Shopcart();
		cart.setCommodityId(Integer.parseInt(cId));
		cart.setCommodityAmount(Integer.parseInt(cAmount));
		int c1 = Integer.parseInt(cPrice)*Integer.parseInt(cAmount);
		cart.setCommodityMoney(c1);
		Customer c = (Customer) request.getSession().getAttribute("customer");
		cart.setCustomerId(c.getCustomerId());
		boolean flag = cartImpl.addCart(cart);
		if(flag) {
			int arr[] = cartImpl.searchCartAmount(c.getCustomerId());
			request.setAttribute("arr", arr);
			request.getSession().removeAttribute("arr");
			request.getSession().setAttribute("arr", arr);
			request.setAttribute("cartResult", "success");
			request.getRequestDispatcher("/productServlet?method=searchCommodityInfo").forward(request, response);
		}
								
	}
		
	//浏览购物车
	public void cartView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		Customer c = (Customer) request.getSession().getAttribute("customer");
		List<ShopcartVO> list = cartImpl.searchCartInfo(c.getCustomerId());
		int arr[] = cartImpl.searchCartAmount(c.getCustomerId());
		request.getSession().setAttribute("arr", arr);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/forward/cart/mycart.jsp").forward(request, response);
							
	}
	
	//删除购物车
	public void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		boolean flag = cartImpl.deleteCart(Integer.parseInt(request.getParameter("cartId")));
		if(flag) {
		cartView(request, response);								
		}
	}
		
	//清空购物车
	public void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		Customer c = (Customer) request.getSession().getAttribute("customer");
		boolean flag = cartImpl.clearCart(c.getCustomerId());
		if(flag) {
		cartView(request, response);								
		}								
	}
	
	//核对支付密码
		public void checkPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub	
			String pWord = request.getParameter("pWord");
			Customer c = (Customer) request.getSession().getAttribute("customer");			
			String realWord = cartImpl.checkPayWord(c.getCustomerId());
			if(realWord.equals(pWord)) {				
				request.setAttribute("checkResult", "success");
				cartView(request, response);
			}else {
				request.setAttribute("checkResult", "fail");
				cartView(request, response);
			}
											
										
		}
		
		//下单
		public void addcOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					// TODO Auto-generated method stub	
					Customer c = (Customer) request.getSession().getAttribute("customer");										
					List<ShopcartVO> list = cartImpl.searchCartInfo(c.getCustomerId());
					int orderId = cartImpl.selectNextOrderId();
					Order order = new Order();
					StringBuffer sb = orderImpl.serialNumber();
					int arr[ ] = cartImpl.searchCartAmount(c.getCustomerId());
					String sr = new String(sb);
					order.setSerialNumber(sr);
					order.setTotalMoney(arr[1]);
					order.setCustomerId(c.getCustomerId());
					boolean flag = cartImpl.addcOrder(orderId, order);
					if(flag) {
						for(ShopcartVO s:list) {
							OrdercommodityVO com = new OrdercommodityVO();
							com.setCommodityId(s.getCommodityId());
							com.setOrderCommodityAmount(s.getCommodityAmount());
							com.setOrderCommodityMoney(s.getCommodityMoney());
							cartImpl.addcOrderCommodity(orderId, com);																					
						}
						clearCart(request,response);

					}																				
				}
}
