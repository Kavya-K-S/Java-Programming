import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) throws IOException {
		DatagramSocket s=new DatagramSocket(7000);
		byte[] buffer=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buffer,buffer.length);
		while(true) {
			s.receive(dp);
			System.out.println("Client :"+new String(dp.getData()));
			s.send(dp);
		}
	}
	
}


