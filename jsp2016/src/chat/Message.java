package chat;

import java.util.Date;
public class Message {
	private int id;             //����id  
    private String message;     //������Ϣ  
    private String author;      //��������  
    private Date postTime;      //����ʱ��  
      
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getMessage() {  
        return message;  
    }  
    public void setMessage(String message) {  
        this.message = message;  
    }  
    public String getAuthor() {  
        return author;  
    }  
    public void setAuthor(String author) {  
        this.author = author;  
    }  
    public Date getPostTime() {  
        return postTime;  
    }  
    public void setPostTime(Date postTime) {  
        this.postTime = postTime;  
    }  
}
