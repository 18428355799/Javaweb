package T6_1;

import java.io.*;
import java.util.*;

public class Find {
	
	Vector v =new Vector();
	int i=0;
	
	public void find(){
		String msg=null;
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("emp.txt")));
			while((msg=br.readLine())!=null){
				
				if(!msg.equals("")){
					String [] str=msg.split("@_@");
					v.add(str);
				}
			}
			this.sort();
		} catch (Exception e) {
//			System.out.println(e);
		}
	}
	
	//ʹ��ð������
	public void sort(){
		Object temp=null;
		for(int i=0;i<v.size()-1;i++){
			for(int j=i+1;j<=v.size()-1;j++){
				String []str1=(String [])v.get(i);
				String [] str2=(String [])v.get(j);
				
				int n1=Integer.parseInt(str1[0]);
				int n2=Integer.parseInt(str2[0]);
				
				if(n1>n2){
					temp=v.get(i);
					v.set(i,v.get(j));
					v.set(j,temp);
				}
				
			}
		}
	}
	//���������ҹ���
	public String  bSearch(String salary){
		String strd="��ѯ������"; 
		Iterator iterator=v.iterator();
		while(iterator.hasNext()){
			if(i==7){
				break;
			}
			String str[]=(String [])v.get(i);
			String strs=str[4];
			if(Integer.parseInt(salary)<Integer.parseInt(strs) ){
				System.out.println("������"+str[1]+" �绰:"+str[2]+" ��ְʱ�䣺"+str[3]+" ���ʣ�"+str[4]);
				i++;
				bSearch(salary);
				return strd;
			}else{
				i++;
				bSearch(salary);
				return strd;
			}
		}
		return strd;
	}
	
	public static void main(String[] args) {
		Find find=new Find();
		find.find();
		System.out.println("��ѯԱ���������빤�ʴ��ڶ��٣�");
		Scanner input=new Scanner(System.in);
		String dd=input.next();
		System.out.println(find.bSearch(dd));
	}
}
