package Fuxi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args) {
		try{
			//������������
			ServerSocket serverSocket = new ServerSocket(8888,5);
			System.out.println("�����������ɹ���"+serverSocket.toString());
			//�ȴ�����
			Socket clientSocket = serverSocket.accept();
			System.out.println("�ȴ�����");
			//��������
			InputStream is = clientSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//�������
			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			//��������
			System.out.println("�������˽��տͻ������ݣ�"+br.readLine());
			//��������
			String str = "��ӭ���ӱ�������";
			ps.println(str);
			//�ر�socketͨ��
			clientSocket.close();
			serverSocket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
 