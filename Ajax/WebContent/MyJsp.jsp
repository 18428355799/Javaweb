<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		//创建XMLHttpRequest对象
		function createXMLHttpRequest(){
			var xmlhttp;
			try{
				xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");	
				}catch(e){
					try{
						xmlhttp = new XMLHttpRequest();
					}catch(e){
						alert("创建XMLHttpRequest对象失败");
					}
				}
			}
			alert("ok");
			alert(xmlhttp);
		}
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <input type="button" value="测试Ajax" onclick="createXMLHttpRequest();"/>
  </body>
</html>
