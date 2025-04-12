import java.io.*;
import java.net.*;
public class Clientskt {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		DatagramSocket s=new DatagramSocket();
		byte[] buffer=new byte[1024];
		InetAddress ip=InetAddress.getByName("LocalHost");
		String msg="Hello Server";
		buffer=msg.getBytes();
		DatagramPacket dp=new DatagramPacket(buffer,buffer.length,ip,7000);
		s.send(dp);
		s.receive(dp);
		System.out.println("Server :"+ new String(dp.getData()));
	
	}
}

