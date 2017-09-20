package upload;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileRenameUtil implements FileRenamePolicy {  
	  
    public File rename(File file) {  
        String body = "";  
        String ext = "";  
        Date date = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        //ȡ���ļ����ͺ�׺�ָ�� 
        int pot = file.getName().lastIndexOf("."); 
        //˵����׺���� 
        if (pot != -1) { 
        	//����ʱ�����ʽ����  
            //body = date.getTime() + "";
            body = sdf.format(date);
            ext = file.getName().substring(pot);//��ȡ��׺��  
        } else {  
            body = (new Date()).getTime() + "";  
            ext = "";  
        }  
        Random rand = new Random();
        int rnd = Math.abs(rand.nextInt(9000))+1000;
        String newName = body +rnd + ext;  
        file = new File(file.getParent(), newName);//���ļ�����������  
        return file;  
  
    }  
  
}  
