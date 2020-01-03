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

import edu.lys.dao.ICommodity;
import edu.lys.dao.impl.CommodityImpl;
import edu.lys.entity.Commodity;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.Customer;
import edu.lys.entity.Page;
import edu.lys.utils.ExchangeRequestMap;

/**
 * Servlet implementation class CommodityServlet
 */
@WebServlet("/commodityServlet")
public class CommodityServlet extends Upload {
	private static final long serialVersionUID = 1L;
    ICommodity commodityImpl = new CommodityImpl();  
    private static Logger logger = Logger.getLogger(Log4JTestServlet.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if("addCommodity".equals(method)) {
			addCommodity(request,response);
		}else if("commodityList".equals(method)){
			commodityList(request,response);
		}else if("updateCommodity".equals(method)){
			updateCommodity(request,response);
		}else if("searchCommodity".equals(method)){
			searchCommodity(request,response);
		}else if("updateState".equals(method)){
			updateState(request,response);
		}
		Map map = ExchangeRequestMap.getParameterMap(request);
		
		logger.info("请求入参:"+map.toString()+"\n");
	}
	
	//添加商品
	public void addCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		// 获取页面表单传过来的所有数据
		Map<String, String> map = upload(request,response);	
		Commodity commodity = new Commodity();	
		commodity.setCompositionId(Integer.parseInt(map.get("compositionId")));
		commodity.setCommodityTitle(map.get("title"));
		commodity.setCommodityHeadpic(map.get("headPic"));
		commodity.setCommodityPrice(Integer.parseInt(map.get("price")));
		commodity.setUnit((map.get("unit")));
		commodity.setCommodityQuantity(map.get("quantity"));
		commodity.setCommodityDescription(map.get("description"));
		commodity.setState(Integer.parseInt(map.get("state")));
		boolean flag = commodityImpl.addCommodity(commodity);
		if(flag) {
			request.setAttribute("result", "success");
			request.getRequestDispatcher("/back/product/productList.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "fail");
			request.getRequestDispatcher("/back/product/productList.jsp").forward(request, response);
		}
								
	}
	
	//商品浏览
		public void commodityList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub	
			Page<CommodityVO> page = new Page<CommodityVO>();
			page.setEntity(new CommodityVO());
			String commodityTitle  = request.getParameter("title");
			String typesId  = request.getParameter("typesId");
			String state  = request.getParameter("state");
			int num =-1;
			int num1 =-1;
	    	if(state !=null && !"".equals(state)) {
	    		num = Integer.parseInt(state);
	    	}
	    	if(typesId !=null && !"".equals(typesId)) {
	    		num1 = Integer.parseInt(typesId);
	    	}
	    	page.getEntity().setCommodityTitle(commodityTitle);
	    	page.getEntity().setTypesId(num1);
	    	page.getEntity().setState(num);
	    	page.setPageSize(4);
	    	//计算当前页
	    	String currentPage = request.getParameter("currentPage");
	    	int cp = 1;
	    	if(currentPage != null && !"".equals(currentPage)){
	    		cp = Integer.parseInt(currentPage);
	    	}
	    	page.setCurrentPage(cp);
	    	
			List<CommodityVO> list = commodityImpl.searchAllCommodity(page);
			int totalCount = commodityImpl.searchCount(page);
			page.setTotalCount(totalCount);
			page.setList(list);
			request.setAttribute("page",page);
			request.getRequestDispatcher("/back/product/productList.jsp").forward(request, response);											
		}
		//查找商品信息
		public void searchCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub	
			Commodity commodity = new Commodity();			
			int id = Integer.parseInt(request.getParameter("cId"));
			commodity = commodityImpl.searchCommodityById(id);
			request.setAttribute("commodity", commodity);
			request.getRequestDispatcher("/back/product/productUpdate.jsp").forward(request, response);				
		}
		
		
		//修改商品
		public void updateCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub	
			// 获取页面表单传过来的所有数据
			Map<String, String> map = upload(request,response);		
			Commodity commodity = new Commodity();	
			commodity.setCommodityId(Integer.parseInt(map.get("cId")));
			commodity.setCommodityTitle(map.get("title"));
			commodity.setCommodityHeadpic(map.get("headPic"));
			commodity.setCommodityPrice(Integer.parseInt(map.get("price")));
			commodity.setCommodityDescription(map.get("description"));
			commodity.setState(Integer.parseInt(map.get("state")));
			boolean flag = commodityImpl.updateCommodityById(commodity);
			if(flag) {
				request.setAttribute("result", "success");
				request.getRequestDispatcher("/back/product/productUpdate.jsp").forward(request, response);
			}else {
				request.setAttribute("result", "fail");
				request.getRequestDispatcher("/back/product/productUpdate.jsp").forward(request, response);
			}
									
		}
		
		//修改商品状态
		public void updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub	
			String cId  = request.getParameter("cId");
			String cState  = request.getParameter("cState");
			int num = -1;
			int num1 = -1;
			if(cState !=null && !"".equals(cState)) {
	    		num = Integer.parseInt(cState);
	    	}
			if(cId !=null && !"".equals(cId)) {
				num1 = Integer.parseInt(cId);
	    	}
			if(num==0) {
				commodityImpl.recoverCommodityState(num1);
			}else if(num==1) {
				commodityImpl.cancelCommodityState(num1);
			}
			commodityList(request,response);	
			
									
		}
		
}
