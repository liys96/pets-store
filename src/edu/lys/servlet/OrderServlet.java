package edu.lys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.lys.dao.IOrder;
import edu.lys.dao.impl.OrderImpl;
import edu.lys.entity.Appraise;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.Customer;
import edu.lys.entity.OrderVO;
import edu.lys.entity.OrdercommodityVO;
import edu.lys.entity.Page;
import edu.lys.utils.ExchangeRequestMap;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IOrder orderImpl = new OrderImpl();
    private static Logger logger = Logger.getLogger(Log4JTestServlet.class);
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if("orderList".equals(method)) {
			orderList(request,response);
		}else if("orderView".equals(method)) {
			orderView(request,response);
		}else if("sendOrbackOrder".equals(method)) {
			sendOrbackOrder(request,response);
		}else if("myOrder".equals(method)) {
			myOrder(request,response);
		}else if("myOrderView".equals(method)) {
			myOrderView(request,response);
		}else if("operateOrder".equals(method)) {
			operateOrder(request,response);
		}else if("orderAppriase".equals(method)) {
			orderAppriase(request,response);
		}else if("addAppriase".equals(method)) {
			addAppriase(request,response);
		}else if("finishAppriase".equals(method)) {
			finishAppriase(request,response);
		}
		Map map = ExchangeRequestMap.getParameterMap(request);
		
		logger.info("请求入参:"+map.toString()+"\n");
	}
	
		//所有订单浏览
			public void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub	
				Page<OrderVO> page = new Page<OrderVO>();
				page.setEntity(new OrderVO());
				String serialNumber  = request.getParameter("serialNumber");
				String state  = request.getParameter("state");
				int num =-1;
		    	if(state !=null && !"".equals(state)) {
		    		num = Integer.parseInt(state);
		    	}
		    	page.getEntity().setSerialNumber(serialNumber);
		    	page.getEntity().setOrderState(num);
		    	page.setPageSize(4);
		    	//计算当前页
		    	String currentPage = request.getParameter("currentPage");
		    	int cp = 1;
		    	if(currentPage != null && !"".equals(currentPage)){
		    		cp = Integer.parseInt(currentPage);
		    	}
		    	page.setCurrentPage(cp);
		    	
				List<OrderVO> list = orderImpl.searchAllOrder(page);
				int totalCount = orderImpl.searchCount(page);
				page.setTotalCount(totalCount);
				page.setList(list);
				request.setAttribute("page",page);
				request.getRequestDispatcher("/back/order/orderList.jsp").forward(request, response);											
			}
			
			//查看订单详情
			public void orderView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub	
				List<OrdercommodityVO> list = new ArrayList<OrdercommodityVO>();
				String cu = request.getParameter("currentPage");
				String orderId = request.getParameter("orderId");
				int num = -1;
		    	if(orderId != null && !"".equals(orderId)){
		    		num = Integer.parseInt(orderId);
		    	}
		    	OrderVO order = orderImpl.searchOrderInfo(num);
		    	 list = orderImpl.searchOrderCommodity(num);
		    	 request.setAttribute("order", order);
		    	 request.setAttribute("cu", cu);
		    	 request.setAttribute("list", list);
				request.getRequestDispatcher("/back/order/orderView.jsp").forward(request, response);											
			}	
			
			//发货退货
			public void sendOrbackOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub	
				String oState = request.getParameter("oState");
				String oId	= request.getParameter("oId");
				int state = Integer.parseInt(oState);
				int id = Integer.parseInt(oId);
				//发货
				if(state ==0) {
					boolean flag = false;
					List<OrdercommodityVO> list = orderImpl.searchOrderCommodity(id);
					for(OrdercommodityVO c:list) {
						int inventoryAmount = orderImpl.searchInventryAmount(c.getCommodityId());
						if(inventoryAmount<c.getOrderCommodityAmount()) {
							request.setAttribute("sendResult", "fail");
							orderList(request, response);
						}else {
							int in1 = inventoryAmount-c.getOrderCommodityAmount();
							flag = orderImpl.changeInventryAmount(in1, c.getCommodityId());
						}
					}
					if(flag) {
						orderImpl.sendOrder(id);
						request.setAttribute("sendResult", "success");
						orderList(request, response);
					}					
				//退货
				}else if(state ==4){
					boolean flag = false;
					List<OrdercommodityVO> list = orderImpl.searchOrderCommodity(id);
					for(OrdercommodityVO c:list) {
						int inventoryAmount = orderImpl.searchInventryAmount(c.getCommodityId());
						 flag = orderImpl.changeInventryAmount(inventoryAmount+c.getOrderCommodityAmount(), c.getCommodityId());						
					}
					if(flag) {
						orderImpl.backOrder(id);
						request.setAttribute("backResult", "success");
						orderList(request, response);
					}
				}
			}
			
			
			//前台我的订单
			public void myOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub	
				Customer c = (Customer) request.getSession().getAttribute("customer");	
				Page<OrderVO> page = new Page<OrderVO>();
				page.setEntity(new OrderVO());
				String serialNumber  = request.getParameter("serialNumber");
				String startTime  = request.getParameter("startTimeStr");
				String endTime  = request.getParameter("endTimeStr");
				String state  = request.getParameter("state");
				int num =-1;
		    	if(state !=null && !"".equals(state)) {
		    		num = Integer.parseInt(state);
		    	}
		    	page.getEntity().setSerialNumber(serialNumber);
		    	page.setStartTimeStr(startTime);
		    	page.setEndTimeStr(endTime);
		    	page.getEntity().setOrderState(num);
		    	page.setPageSize(6);
		    	//计算当前页
		    	String currentPage = request.getParameter("currentPage");
		    	int cp = 1;
		    	if(currentPage != null && !"".equals(currentPage)){
		    		cp = Integer.parseInt(currentPage);
		    	}
		    	page.setCurrentPage(cp);
		    	
				List<OrderVO> list = orderImpl.searchcOrder(c.getCustomerId(), page);
				int totalCount = orderImpl.searchcOrderCount(c.getCustomerId(),page);
				page.setTotalCount(totalCount);
				page.setList(list);
				request.setAttribute("page",page);
				request.getRequestDispatcher("/forward/order/myorder.jsp").forward(request, response);
			}
			
			
			//查看订单详情
			public void myOrderView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub	
				List<OrdercommodityVO> list = new ArrayList<OrdercommodityVO>();
				String orderId = request.getParameter("orderId");
				int num = -1;
		    	if(orderId != null && !"".equals(orderId)){
		    		num = Integer.parseInt(orderId);
		    	}
		    	OrderVO order = orderImpl.searchOrderInfo(num);
		    	 list = orderImpl.searchOrderCommodity(num);
		    	 request.setAttribute("order", order);
		    	 request.setAttribute("list", list);
				request.getRequestDispatcher("/forward/order/orderview.jsp").forward(request, response);											
			}
			
			//评价成功查看评价详情
			public void myOrderViewAfter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub	
				List<OrdercommodityVO> list = new ArrayList<OrdercommodityVO>();
				String orderId = (String) request.getAttribute("orderId");
				int num = -1;
		    	if(orderId != null && !"".equals(orderId)){
		    		num = Integer.parseInt(orderId);
		    	}		    	
		    	 list = orderImpl.searchOrderCommodity(num);
		    	 request.setAttribute("orderId",orderId);
		    	 request.setAttribute("list", list);
				request.getRequestDispatcher("/forward/order/orderAppraise.jsp").forward(request, response);											
			}
			
			//订单评价
			public void orderAppriase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub	
				List<OrdercommodityVO> list = new ArrayList<OrdercommodityVO>();
				String orderId = request.getParameter("orderId");
				int num = -1;
		    	if(orderId != null && !"".equals(orderId)){
		    		num = Integer.parseInt(orderId);
		    	}		    	
		    	 list = orderImpl.searchOrderCommodity(num);
		    	 request.setAttribute("list", list);
				request.getRequestDispatcher("/forward/order/orderAppraise.jsp").forward(request, response);											
			}
			//添加评价
			public void addAppriase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub					
				String comId = request.getParameter("comId");
				String orId = request.getParameter("orId");
				String content = request.getParameter("content");
				Customer c = (Customer) request.getSession().getAttribute("customer");
				Appraise app = new Appraise(); 
				app.setAppraiseContent(content);
				app.setCommodityId(Integer.parseInt(comId));
				app.setCustomerId(c.getCustomerId());
		    	boolean flag = orderImpl.addAppraise(app);
		    	if(flag) {
		    		request.setAttribute("appResult", "success");
		    		request.setAttribute("orderId", orId);
		    		myOrderViewAfter(request,response);
		    	}else {
		    		request.setAttribute("appResult", "fail");
		    		request.setAttribute("orderId", orId);
		    		myOrderViewAfter(request,response);
		    	}
															
			}
			//完成评价
			public void finishAppriase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub					
					String orId = request.getParameter("orId");				
		    		orderImpl.finishOrder(Integer.parseInt(orId));		 		    
		    		myOrder(request,response);									
			}
			
			//订单操作
			public void operateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub	
				int num = Integer.parseInt(request.getParameter("oState"));
				int id = Integer.parseInt(request.getParameter("oId"));
				if(num ==0) {
					//取消
					orderImpl.cancelOrder(id);
					myOrder(request,response);
				}else if(num ==1) {
					//收货
					orderImpl.receiveOrder(id);
					myOrder(request,response);
				}else if(num ==2) {
					//退货
					orderImpl.returnOrder(id);
					myOrder(request,response);
				}
				
			}

}
