<%@ page contentType="text/html;charset=GBK" %>
<%
	request.setCharacterEncoding("GBK");
	String pName = request.getParameter("Name");
	String pLove = request.getParameter("Love");
	// �õ����е�cookie
	Cookie cookies[] = request.getCookies();
	// �������һ���ύ�����ģ������cookie��ֵ
	if(pName != null) {
		Cookie c = new Cookie("Name",pName);
		c.setMaxAge(30);
		  // cookie ����Ч��Ϊ 30 ��
		response.addCookie(c);
	}
	else if(cookies != null) { 
	   // ����Ѿ�������cookie �� ��õ�����ֵ�������浽����pName��
	   for(int i=0; i<cookies.length; i++) {
		  if(cookies[i].getName().equals("Name")){
			   pName = cookies[i].getValue();
		  }
	   }
	}
	if(pLove != null){
		Cookie c = new Cookie("Love", pLove);
		c.setMaxAge(30);       // cookie ����Ч��Ϊ 30 ��
		response.addCookie(c);
	}else if(cookies != null){  // ����Ѿ�������cookie �� ��õ�����ֵ�������浽����pLove��
		for(int i=0; i<cookies.length; i++) {
		   if(cookies[i].getName().equals("Love")){
				pLove = cookies[i].getValue();
		   }
		}
	}
%>
<html>
<head>
    <title>����cookie</title>
</head>
<body bgcolor="#FFFFFF">
    <h2 align="center"> ���� cookies��������ݼ�¼�������</h2>
<form action="Cookies.jsp" method="post">
    <p>������
	   <input type="text" size="20" name="Name" value="<% if(pName != null) out.println(pName); %>">
	</p>
    <p>��Ȥ��
	   <input type="text" size="20" name="Love" value="<% if(pLove != null) out.println(pLove); %>">
	</p>
	<p><input type="submit" value="�� ��"> </p>
</form>
</body>
</html>
