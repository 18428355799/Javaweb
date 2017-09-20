package base;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//���ӳ�
public class DBPool {
	public static Connection getConnection(){
		Connection conn = null;
		try{
			//������ʼ�������Ļ���
			Context init = new InitialContext();
			//��ȡ��������
			Context context = (Context)init.lookup("java:/comp/env");
			//��ȡ���ӳصĲ�������,�������ӳɹ�������Դ
			DataSource ds = (DataSource)context.lookup("jdbc/dbsample");
			conn = ds.getConnection();
		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
