package Fuxi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
	public static void main(String[] args) {
		try {
			//�����ͻ���
			Socket socket = new Socket("127.0.0.1",8888);
			System.out.println("���ӷ������ɹ�");
			//�������
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			//��������
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//��������
			String str = "���ǿͻ��ˣ���������";
			ps.println(str);
			//��������
			System.out.println("�ͻ������ӷ���ˣ�"+br.readLine());
			//�ر�����
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
