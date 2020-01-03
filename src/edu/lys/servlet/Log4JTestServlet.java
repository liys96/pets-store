package edu.lys.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Log4JTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(Log4JTestServlet.class);

    public Log4JTestServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 记录debug级别的信息
        logger.debug("这是 debug 消息。");
        // 记录info级别的信息
        logger.info("这是 info 消息。");
        // 记录error级别的信息
        logger.error("这是 error 消息。");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}