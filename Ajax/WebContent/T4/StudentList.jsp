<%@ page language="java" pageEncoding="gb2312"%>
<%@page import="com.ht.dwr.StudentVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>ѧ���б�</title>
<script language="javascript" src="dwr/interface/JDate.js"></script>
<script language="javascript" src="dwr/interface/StudentDAO.js"></script>
<script language="javascript" src='dwr/engine.js'></script>
<script language="javascript" src='dwr/util.js'></script>
  </head>
<script language="javascript">
	var popUpWin;
	function popUpWindow(URLStr, left, top, width, height)
	{
	  if(popUpWin)
	  {
	    if(!popUpWin.closed) popUpWin.close();
	  }
	  popUpWin = open(URLStr, 'popUpWin', 'toolbar=no,location=no,directories=no,status=no,menub ar=no,scrollbar=no,resizable=no,copyhistory=yes,width='+width+',height='+height+',left='+left+', top='+top+',screenX='+left+',screenY='+top+'');
	}
	
	
	function doTest() {
	    //JDate.toString(load);
		StudentDAO.findAllStudent(load)
	}

	function load(data) {	
		//data�õ�����һ���û����飬�����ŵ���һ���û�����(StudentVo)
		var tab = document.getElementById("tab");
		for(i = 0;i<data.length;i++){
			var row = tab.insertRow();
			
			var cell = row.insertCell();
			cell.innerHTML=data[i].id;
			
			var cell = row.insertCell();
			cell.innerHTML = data[i].stuName;
			
			var cell = row.insertCell();
			cell.innerHTML = data[i].stuNo;
			
			var cell = row.insertCell();
			cell.innerHTML = data[i].teamId;
			
			var cell = row.insertCell();
			cell.innerHTML = "<a href=\"javascript:popUpWindow('editStudent.jsp?studentId="+data[i].id+"',200,200,400,200);\" >�޸�</a>";
			
			var cell = row.insertCell();
			cell.innerHTML = "<a href=\"javascript:deleteStu('"+data[i].id+"')\" >ɾ��</a>";
		}
	}
	
	//���table��tr
	function clearTab(){
		var t = tab.rows.length;
		for(i = 1;i<t;i++){	
			tab.deleteRow(tab.rows[1].rowIndex);
		}
		return true;
	}
	
	//ɾ��ѧ��
	function deleteStu(studentId){
		StudentDAO.delStudent(studentId,function(result){
			if(result){
				alert("ɾ���ɹ�������");
				 document.location.reload();
			}
			else{
				alert("ɾ��ʧ��");
			}
		});
	}

</script>
  <%
    	StudentVo student = (StudentVo)request.getAttribute("student");
  %>
  <body onload="doTest();">
  <h1 align="center">ѧ���б�</h1>
  <hr/>
  <a href="javascript:popUpWindow('addStudent.jsp',200,200,400,200);">���ѧ��</a>
    <form action="" method="post" >
      <table border="0" id="tab">
        <tr>
          <td>���</td>
          <td>ѧ������</td>
          <td>ѧ��ѧ��</td>
          <td>ѧ���༶</td>
          <td colspan="2">����</td>
        </tr>
      </table>
     </form>
  </body>
</html>
