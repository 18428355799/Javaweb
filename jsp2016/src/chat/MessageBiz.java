package chat;
import java.util.*;  
public class MessageBiz {  
    //����һ����Ϣ
    public void saveMessage(Message message){  
        MessageDao messageDao=new MessageDao();  
        messageDao.save(message);  
    }  
    //����ҳ������ѯ����
    public List<Message> listByPage(int pageSize,int pageNum){  
        MessageDao messageDao=new MessageDao();  
        return messageDao.listByPage(pageSize,pageNum);  
    }  
      
   //���ز�ѯ���ļ�¼��������
    public int getAllUserCount(){  
        MessageDao messageDao=new MessageDao();  
        return messageDao.getAllUserCount();  
    }  
}
