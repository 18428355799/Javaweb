<%@ page language="java" pageEncoding="GB2312" errorPage="error.jsp"%>
<%@ page import="java.util.Date" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
  
    <title>page��ָ��ʹ��</title>
 
  </head>
  
  <body>
    <h1><br></h1><h1>pageָ���ʹ��</h1>
    <hr/>
    	��ǰʱ���ǣ�<%=new Date().toLocaleString() %>
    	<%=20/0 %>
  </body>
</html>
