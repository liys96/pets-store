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

import edu.lys.dao.IInventory;
import edu.lys.dao.impl.InventoryImpl;
import edu.lys.entity.Commodity;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.InventoryVO;
import edu.lys.entity.Page;
import edu.lys.utils.ExchangeRequestMap;

/**
 * Servlet implementation class InventoryServlet
 */
@WebServlet("/inventoryServlet")
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   IInventory inventoryImpl = new InventoryImpl();
   private static Logger logger = Logger.getLogger(Log4JTestServlet.class);
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if("inventoryList".equals(method)) {
			inventoryList(request,response);
		}else if("searchCommodity".equals(method)) {
			searchCommodity(request,response);
		}else if("addInventory".equals(method)) {
			addInventory(request,response);
		}
		Map map = ExchangeRequestMap.getParameterMap(request);
		
		logger.info("请求入参:"+map.toString()+"\n");
	}

	
	//库存浏览
	public void inventoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		Page<InventoryVO> page = new Page<InventoryVO>();
		page.setEntity(new InventoryVO());
		String commodityTitle  = request.getParameter("title");
		String typesId  = request.getParameter("typesId");
		int num =-1;
    	if(typesId !=null && !"".equals(typesId)) {
    		num = Integer.parseInt(typesId);
    	}
    	page.getEntity().setCommodityTitle(commodityTitle);
    	page.getEntity().setTypesId(num);
    	page.setPageSize(4);
    	//计算当前页
    	String currentPage = request.getParameter("currentPage");
    	int cp = 1;
    	if(currentPage != null && !"".equals(currentPage)){
    		cp = Integer.parseInt(currentPage);
    	}
    	page.setCurrentPage(cp);
    	
		List<InventoryVO> list = inventoryImpl.searchAllInventory(page);
		int totalCount = inventoryImpl.searchCount(page);
		page.setTotalCount(totalCount);
		page.setList(list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("/back/product/inventoryList.jsp").forward(request, response);											
	}
	
	//查找所有商品
	public void searchCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		List<Commodity> list = inventoryImpl.searchAllCommodity();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/back/product/inventoryAdd.jsp").forward(request, response);											
	}
	//添加库存
	public void addInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		InventoryVO inventoryVO  = new InventoryVO();
		String commodityId = request.getParameter("commodityId");
		int num1 = -1;
    	if(commodityId !=null && !"".equals(commodityId)) {
    		num1 = Integer.parseInt(commodityId);
    	}
    	inventoryVO.setCommodityId(num1);
    	inventoryVO.setInventoryAmount(Integer.parseInt(request.getParameter("amount")));
		boolean flag = inventoryImpl.addInventory(inventoryVO);
		if(flag) {
			request.setAttribute("result", "success");
			request.getRequestDispatcher("/back/product/inventoryAdd.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "fail");
			request.getRequestDispatcher("/back/product/inventoryAdd.jsp").forward(request, response);
		}
													
	}
		
		
}
