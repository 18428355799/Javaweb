package T2.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class UrlServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        //��������URL
        String url = request.getHeader("referer");
        //�ھ�����һ���������ȡ�������URL
        if(url.indexOf("?")!=-1){
            url=url.substring(0,url.indexOf("?"));
        }
        //����ύ�Ĳ���
        String test = request.getParameter("test");
        //��URL���б��벢��URL������д
        String url1 = response.encodeURL(url+"?test="+ test);
        //��sendRedirect����ʹ�õ�ָ��URL���б���
        String url2=response.encodeRedirectURL(url1);
        //���¶���
        response.sendRedirect(url2);
        out.close();
    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }

    //Clean up resources
    public void destroy() {
    	
    }
}
