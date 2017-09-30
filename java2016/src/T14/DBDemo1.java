package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo1 {
	/**
	 *���Ӳ�ͨ���ݿ�ʱ�ļ�鲽�裺
	 *	1.��û�а�װ;
	 *	2.������û��������
	 *	3.��ȫ�������Ƿ�Ϊ���ģʽ��
	 *	4.�������ַ���д���ˣ� 
	 *	5.url����
	 * 
	 * 
	 * */
	
	/**
	 * ���ݿ�����Ĳ��裺
	 * 1.��������
	 * 2.����Connection����
	 * 	1.URL�������ַ���
	 * 	2.USERNAME:��¼���û�����;
	 * 	3.PASSWORD:��¼����
	 * */
	public static void main(String[] args) {
		/**
		 * 	JDBC-ODBC���������ݿ�
		 * 	1.���������-��DSN����һ������Դ��
		 * 	2.ѡ����Ҫ���ӵ����ݿ⣨Ĭ����master���ݿ⣩
		 * 	3.url��ʹ�õ�������Դ�����ƣ��������ݿ������
		 * */
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:Test"; //TestDB�ǿ�����������õ�����Դ�����ƣ��������ݿ������
		String username = "sa";
		String password = "123456";
		try {
			//1.��������(JDBC-ODBC�ŵ����ӷ�ʽ)
			Class.forName(driver);
			Connection conn =DriverManager.getConnection(url,username,password);
			if(!conn.isClosed()){
				System.out.println("���ݿ����ӳɹ���");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
