package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBDemo {
	public static void main(String[] args) {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //����
		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t6";
		String username="sa";
		String password="123456";
		try{
			//ע��һ������
			Class.forName(driver);
			//�������ݿ�
			Connection conn = DriverManager.getConnection(url,username,password);
			//����Statement����,SQL����ִ�л������൱�ڲ�ѯ�������Ĺ���;
			Statement stmt = conn.createStatement();
			//����ִ�н��
			//�ڵ�ǰ���ݱ������һ������
			stmt.execute("insert into account values(6,'С��','1234')");
			//ɾ��һ����¼
			String sq1 = "delete account where id = 6";
			String sql = null;
			//ResultSet������ִ�еĽ��
			//ͨ����������ִ��sql��䣬��������
			//����ֵ���Ǹ��³ɹ��ļ�¼��
			int cnt = stmt.executeUpdate(sql);
			System.out.println("cnt="+cnt);
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
