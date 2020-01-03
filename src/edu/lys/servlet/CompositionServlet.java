package edu.lys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.lys.dao.ITypes;
import edu.lys.dao.impl.TypesImpl;
import edu.lys.entity.Composition;
import edu.lys.utils.ExchangeRequestMap;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class CompositionServlet
 */
@WebServlet("/compositionServlet")
public class CompositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ITypes typesImpl = new TypesImpl();   	   
	private static Logger logger = Logger.getLogger(Log4JTestServlet.class);
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int mid = Integer.parseInt(request.getParameter("marqueId"));
		List<Composition> list = typesImpl.searchCompositionByMarqueId(mid);
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.write(jsonArray.toString());
		out.flush();
		out.close();
		Map map = ExchangeRequestMap.getParameterMap(request);
		
		logger.info("请求入参:"+map.toString()+"\n");
	}

}
