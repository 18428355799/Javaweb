package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
	
	 private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	    private String url="jdbc:sqlserver://localhost:1433;DataBaseName=t7";  
	    private String name="sa";  
	    private String password="123456";  
	    //����һ����¼
	    public int save(Message message){  
	        int line=0;             //�����¼������  
	        Connection con=null;  
	        PreparedStatement pstat=null;  
	        try{  
	            con=getConn();  
	            pstat=con.prepareStatement("insert into TBL_MESSAGE(message,author,postTime) values(?,?,getdate())");  
	            pstat.setString(1,message.getMessage());  
	            pstat.setString(2,message.getAuthor());  
	            line=pstat.executeUpdate();  
	              
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }finally{  
	            closeAll(null,pstat,con);  
	        }  
	        return line;  
	    }  
	      
	    /** 
	     * ��ҳ��ʾ��Ϣ 
	     * @param pageSize ÿҳ��ʾ����Ϣ���� 
	     * @param pageNum  ��λ����һҳ 
	     * @return 
	     */  
	    public List<Message> listByPage(int pageSize,int pageNum){  
	        Connection con=null;  
	        PreparedStatement pstat=null;  
	        ResultSet res=null;  
	        List<Message> list=new ArrayList<Message>();  
	        try{  
	            con=getConn();  
	            pstat=con.prepareStatement("select top "+pageSize+" * from TBL_MESSAGE where id not in (select top "+pageSize*(pageNum-1)+" id from TBL_MESSAGE order by postTime) order by postTime");  
	            res=pstat.executeQuery();  
	            while(res.next()){  
	                Message message=new Message();  
	                message.setId(res.getInt(1));  
	                message.setMessage(res.getString(2));  
	                message.setAuthor(res.getString(3));  
	                message.setPostTime(res.getDate(4));  
	                list.add(message);  
	            }  
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }finally{  
	            closeAll(res,pstat,con);  
	        }  
	        return list;  
	    }  
	      
	    /** 
	     * ��ü�¼�������� 
	     * @return  ���ز�ѯ�������м�¼�������� 
	     */  
	    public int getAllUserCount(){  
	        Connection con=null;  
	        PreparedStatement pstat=null;  
	        ResultSet res=null;  
	        int ret = 0;  
	        try{  
	            con=getConn();  
	            pstat=con.prepareStatement("select count(*) from TBL_MESSAGE");  
	            res=pstat.executeQuery();  
	            if(res.next()){  
	                ret=res.getInt(1);  
	            }  
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }finally{  
	            closeAll(res,pstat,con);  
	        }  
	        return ret;  
	    }  
	   
	    /** 
	     * �������ݿ� 
	     */  
	    public Connection getConn(){  
	        Connection con=null;  
	        try{  
	            Class.forName(driver);  
	            con=DriverManager.getConnection(url,name,password);  
	        }catch(ClassNotFoundException e){  
	            e.printStackTrace();  
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }  
	        return con;  
	    }  
	      
	      
	      
	    /** 
	     * �ر����ݿ����ӣ�������������˳��ģ��ȹر�ResultSet���ӣ����Źر�Statement���ӣ����ر�Connection���� 
	     * ���һ�Ҫ�׳��쳣�����ݿ�����ʹ������Ժ���Ҫ�ر����ӵģ������������ݿ�ġ�ͨ�����ͻ�������ӣ������ݿ������ 
	     * ����Ҳ�����޵ģ���Լ��200���������Ҫ��ʹ�������ݿ�����ӹرյ��� 
	     * @param res 
	     * @param stat 
	     * @param conn 
	     */  
	    public void closeAll(ResultSet res,PreparedStatement pstat,Connection con){  
	        try{  
	            if(res!=null){  
	                res.close();  
	                res=null;  
	            }  
	            if(pstat!=null){  
	                pstat.close();  
	                pstat=null;  
	            }  
	            if(con!=null){  
	                con.close();  
	            }  
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }  
	      
	    }  
	      
}
