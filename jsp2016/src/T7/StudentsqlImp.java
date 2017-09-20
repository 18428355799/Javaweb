package T7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsqlImp implements Studentsql{

	//�������ݿ�
	Connection con = SQLCon.openDB();
	//��ѯ���е�ѧԱ��Ϣ
	public List<StudentBean> list() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select studentname,studentcount from vote order by studentcount desc");
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setStudentinf(rs.getString("studentname"));
				bean.setStudentcount(rs.getInt("studentcount"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//����ѧ��Ʊ��
	public void addcount(StudentBean bean) {
		try {
			Statement st = con.createStatement();
			for(int j=0;j<bean.getStudentname().length;j++){
				String sql = "update vote set studentcount=(select studentcount from vote where studentname='"+bean.getStudentname(j)+"')+1 where studentname='"+bean.getStudentname(j)+"'";
				st.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//��ѯѧ���б�
	public List<StudentBean> studentlist() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from vote");
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setStudentinf(rs.getString("studentname"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//����ѧԱ
	public void addstudent(String studentname) {
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into vote values('"+studentname+"',0)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
