package T16;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
	//客户端程序
	public static void main(String[] args) {
		try{
			//创建客户端Socket;
			Socket socket = new Socket("127.0.0.1",8888);
			System.out.println("连接服务器成功....");
			//绑定输出流
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			//绑定输入流
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//发送数据
			String str = "我是客户端，请求连接...";
			ps.println(str);
			//接收数据
			System.out.println("客户端接收服务器数据:"+br.readLine());
			//关闭数据
			socket.close();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
