package T6;

import java.io.UnsupportedEncodingException;

public class Counter {

	private String username;
	private int count;
	public String getUsername() {
		return username;
	}
	//��ҳ���ύ����ʱ�õ���get��ʽ�ύ�����ģ�������ø÷����������봦��
	public void setUsername(String username) {
		
		try {
			//��iso-8859-1���ַ�����ת����utf-8�ı���
			String str = new String(username.getBytes("iso-8859-1"),"utf-8");
			username = str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.username = username;
	}
	public int getCount() {
		count++;
		return count;
	}
//	public void setCount(int count) {
//		this.count = count;
//	}
}
