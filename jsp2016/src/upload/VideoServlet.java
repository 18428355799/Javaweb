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

public class VideoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // �����ļ���·����������tomcat���浱ǰ��Ŀ�µ���·�� 
        String filePath = getServletContext().getRealPath("/") + "video";  
        System.out.println(filePath);//�������ϴ��ļ�������·��  
        File uploadPath = new File(filePath);  
        // ����ļ����Ƿ���� ������ ����һ��  
        if (!uploadPath.exists()) {  
        	//�����ļ���
            uploadPath.mkdir();  
        }  
        // �ļ�������� 1G 
        int fileMaxSize = 1024 * 1024 * 1024;  
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
        MultipartRequest mulit =null;
        try{
        	mulit = new MultipartRequest(request, filePath,  
                fileMaxSize, "UTF-8", rfrp);//ȡ���ϴ��ļ�  
        }catch(Exception e){
        	request.setAttribute("msg", "�ϴ��ļ��Ĵ�С���ܳ���1G");
        	getServletContext().getRequestDispatcher("/T13/video.jsp").forward(request, response);
        	return;
        }
        //��ȡ��ͨ�ؼ���ֵ������ʹ��request����
        String section = mulit.getParameter("section");  
        System.out.println(section);  
        Enumeration filesname = mulit.getFileNames();//ȡ���ϴ��������ļ�(�൱�ڱ�ʶ)   
        while (filesname.hasMoreElements()) {  
        	//�ؼ�����
            String name = (String) filesname.nextElement();//��ʶ  
            System.out.println(name);  
            fileName = mulit.getFilesystemName(name); //ȡ���ļ���  
            String contentType = mulit.getContentType(name);//���߱�ʶȡ�õ��ļ�����  
            if (fileName != null) {  
                fileCount++;  
            }  
//            System.out.println("�ļ�����" + fileName);  
//            System.out.println("�ļ����ͣ� " + contentType);   
            //��ҳ����ʾ�ϴ��ɹ���ͼƬ
//            out.println("<img src='upload/"+fileName+"' />");
        }  
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        out.println("���ڿ�����.............");
        System.out.println("���ϴ�" + fileCount + "���ļ���");   
        out.close();
	}

}
