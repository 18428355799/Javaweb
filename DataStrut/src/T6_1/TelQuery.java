package T6_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class TelQuery {

	Vector tel = new Vector();
	public Vector getAddr(String name){
		String[] str=null;
		String msg=null;
		Vector v1=new Vector();
		Vector v2=new Vector();
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(this.getClass().getResource("addr.p").openStream()));
			while((msg=br.readLine())!=null){//���϶�ȡһ�м�¼��ֱ����Ϊֹ
				str=msg.split("@_@");//������绰��"@_@"���ָ���
				v1.add(str[0]);
				v2.add(str[1]);
			}
			this.query(v1,v2,name);//���в���
		}catch(IOException ioe){
			System.out.println(ioe);
		}
		return tel;
	}
	private void query(Vector v1,Vector v2,String name){
		tel.removeAllElements();
		for(int i=0;i<v1.size();i++){
			if(v1.get(i).equals(name)){
				tel.add(v2.get(i));//�ҵ��ĵ绰����Vector�У��������ص�����
			}
		}
	}
}
