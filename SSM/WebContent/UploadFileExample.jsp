<%@ page contentType="text/html; charset=gb2312" language="java"  errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String serverName = request.getServerName(); 
String realPath = request.getRealPath(serverName); 
//out.println("request.getRealPath(serverName)="+realPath+"<br>"); 
out.println("OK<br>");
realPath = realPath.substring(0,realPath.lastIndexOf("\\"));
//out.println(realPath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�ϴ��ļ�ʾ��</title>
    
 <meta http-equiv="pragma" content="no-cache">
 <meta http-equiv="cache-control" content="no-cache">
 <meta http-equiv="expires" content="0">    
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 <meta http-equiv="description" content="This is my page">
 <!--
 <link rel="stylesheet" type="text/css" href="styles.css">
 -->

  </head>
  
  <body>
    �ϴ��ļ�����Ӧ��ʾ��
     <form action="AcceptUploadFile.jsp" method="post" enctype="multipart/form-data"><br>
     ��ѡ��Ҫ�ϴ����ļ�:<input type="file" name="file" size=50>
                       <input type="submit" value="�ύ">
     </form>
  </body>
</html>4