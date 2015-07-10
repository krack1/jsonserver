package jsonserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverjson{
	
	public Serverjson(String ip, int port) {
		
		ServerSocket server = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("socket create");
			System.out.println("wait for client");
			Socket tcpSocket = server.accept();
			if(tcpSocket!=null) {
				System.out.println("access client");
			}
			
			in = tcpSocket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			
			while (true) {
				String str = br.readLine();
				if(str==null){
					break;
				}
				System.out.println(str);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try {
				br.close();
				isr.close();
				in.close();
				server.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		while(true) {
		Serverjson server = new Serverjson("127.0.0.1", 5559);
		}
	}
}


	