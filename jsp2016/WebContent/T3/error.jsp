<%@ page contentType="text/html;charset=GB2312" isErrorPage="true"%>
<%@ page import="java.io.PrintWriter"%>
<%
	/*
		���õ�ǰҳ��Ϊ������ҳ��
		��Ҫ����pageָ���isErrorPage���ԣ�ֵ����Ϊtrue(isErrorPage="true");
		������isErrorPage="true"��ҳ��Ͳ�������errorPage���ԣ���2�������ǻ����
		ֻ��������isErrorPage="true"��ҳ�����ʹ��exception����
	
	*/
%>


<html>
  <head>
    
    <title>error.jsp</title>
    <script type="text/javascript">
    	
    </script>
	
  </head>
  
  <body>
   <h2>errorpage�ķ�������</h2>
   
   <p> ErrorPage.jsp ���������<I><%=exception %> </I></p><br>
   <pre>
  �������£�<% exception.printStackTrace(new PrintWriter(out)); %>
   </pre>
  </body>
</html>
