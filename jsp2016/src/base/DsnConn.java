package base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * jdbc-odbc�ŵķ�ʽ�������ݿ�
 * �˽���δ���DSN�Ĳ���
 * 1.��ʼ�˵�-�������-ϵͳ�Ͱ�ȫ-������-odbc����Դ
 * 2.����ϵͳ���û�������Դ-��������Դ���ƣ���Java������ʹ�õ����ƣ�
 * */
public class DsnConn {
	private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver"; //����
	private static String url = "jdbc:odbc:Edu";
	private static String username="sa";
	private static String password="123456";
	private static Connection conn=null;
	//��̬���飬�������ݿ�
	static{
		try {
			//ע������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("���ݿ����ӳɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//�������ݿ�
	public static Connection openDB(){
		try {
			//�ж�����״̬
			if(conn.isClosed()){
				conn = DriverManager.getConnection(url,username,password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
