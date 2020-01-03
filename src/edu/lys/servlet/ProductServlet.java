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

import edu.lys.dao.IProduct;
import edu.lys.dao.impl.ProductImpl;
import edu.lys.entity.AppraiseVO;
import edu.lys.entity.CommodityVO;
import edu.lys.entity.Customer;
import edu.lys.entity.Page;
import edu.lys.entity.ProductVO;
import edu.lys.utils.ExchangeRequestMap;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IProduct productImpl = new ProductImpl();
	private static Logger logger = Logger.getLogger(Log4JTestServlet.class);
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if("productList".equals(method)) {
			productList(request,response);
		}else if("searchCommodityInfo".equals(method)) {
			searchCommodityInfo(request,response);
		}
		Map map = ExchangeRequestMap.getParameterMap(request);
		
		logger.info("请求入参:"+map.toString()+"\n");
	}

	
	//前台浏览所有商品
		public void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub		
			Page<ProductVO> page = new Page<ProductVO>();
			page.setEntity(new ProductVO());
			String title  = request.getParameter("title");
			String comId  = request.getParameter("comId");
			
			String AccSale  = request.getParameter("AccSale");
			String AccTime  = request.getParameter("AccTime");
			String AccAppraise  = request.getParameter("AccAppraise");
			String AccPrice  = request.getParameter("AccPrice");
			
			
			int num =-1;
	    	if(comId !=null && !"".equals(comId)) {
	    		num = Integer.parseInt(comId);
	    	}
	    	page.getEntity().setCommodityTitle(title);
	    	page.getEntity().setCompositionId(num);
	    	
	    	page.getEntity().setAccSale(AccSale);
	    	page.getEntity().setAccTime(AccTime);
	    	page.getEntity().setAccAppraise(AccAppraise);
	    	page.getEntity().setAccPrice(AccPrice);
	    	
	    	page.setPageSize(8);
	    	//计算当前页
	    	String currentPage = request.getParameter("currentPage");
	    	int cp = 1;
	    	if(currentPage != null && !"".equals(currentPage)){
	    		cp = Integer.parseInt(currentPage);
	    	}
	    	page.setCurrentPage(cp);
	    	
			List<ProductVO> list = productImpl.searchAllProduct(page);
			int totalCount = productImpl.searchCount(page);
			page.setTotalCount(totalCount);
			page.setList(list);
			request.setAttribute("page",page);
			request.getRequestDispatcher("/forward/content/productdetails.jsp").forward(request, response);						
		}
		
		//查看商品详情
				public void searchCommodityInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					// TODO Auto-generated method stub					
				CommodityVO commodity = new CommodityVO();
				String cId = request.getParameter("cId");
				int num = -1;
				if(cId !=null && !"".equals(cId)) {
		    		num = Integer.parseInt(cId);
		    	}
				commodity = productImpl.searchCommodityInfo(num);
					request.setAttribute("commodity",commodity);
					
					
					Page<AppraiseVO> page = new Page<AppraiseVO>();																						    				    	
			    	page.setPageSize(5);
			    	//计算当前页
			    	String currentPage = request.getParameter("currentPage");
			    	int cp = 1;
			    	if(currentPage != null && !"".equals(currentPage)){
			    		cp = Integer.parseInt(currentPage);
			    	}
			    	page.setCurrentPage(cp);
			    	
					List<AppraiseVO> list = productImpl.searchAllAppraise(page, num);
					int totalCount = productImpl.searchAppraiseCount(page, num);
					page.setTotalCount(totalCount);
					page.setList(list);
					request.setAttribute("page",page);
					request.getRequestDispatcher("/forward/detail/detailmessage.jsp").forward(request, response);						
				}

}
