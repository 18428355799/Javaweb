package upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // �����ļ���·����������tomcat���浱ǰ��Ŀ�µ���·�� 
        String filePath = getServletContext().getRealPath("/") + "upload";  
        //�������ϴ��ļ�������·��  
        System.out.println(filePath);
        File uploadPath = new File(filePath);  
        // ����ļ����Ƿ���� ������ ����һ��  
        if (!uploadPath.exists()) {  
        	//�����ļ���
            uploadPath.mkdir();  
        }  
        // �ļ�������� 3M  
        int fileMaxSize = 3 * 1024 * 1024;  
        // ����ļ�����  
        @SuppressWarnings("unused")  
        String[] fileDiscription = { null, null };  
        // �ļ���  
        String fileName = null;  
        // �ϴ��ļ���  
        int fileCount = 0;  
        // ����������  
        FileRenameUtil rfrp = new FileRenameUtil();  
        // �ϴ��ļ�  
        MultipartRequest mulit = new MultipartRequest(request, filePath, fileMaxSize, "UTF-8", rfrp);//ȡ���ϴ��ļ�  
        //��ȡ��ͨ�ؼ���ֵ������ʹ��request����
        String userName = mulit.getParameter("userName");  
        System.out.println(userName);  
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        //ȡ���ϴ��������ļ�(�൱�ڱ�ʶ)
        Enumeration filesname = mulit.getFileNames();   
        while (filesname.hasMoreElements()) {  
        	//�ؼ�����
            String name = (String) filesname.nextElement();//��ʶ  
            System.out.println(name);  
            fileName = mulit.getFilesystemName(name); 
            //ȡ���ļ���  
            String contentType = mulit.getContentType(name);
            //���߱�ʶȡ�õ��ļ�����  
            if (fileName != null) {  
                fileCount++;  
            }  
            System.out.println("�ļ�����" + fileName);  
            System.out.println("�ļ����ͣ� " + contentType);   
            //��ҳ����ʾ�ϴ��ɹ���ͼƬ
            out.println("<img src='upload/"+fileName+"' />");
        }  
        System.out.println("���ϴ�" + fileCount + "���ļ���");   
        out.close();
        
	}

}
