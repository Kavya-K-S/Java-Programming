import java.io.*;
import java.net.*;
public class srvrskt {
public static void main(String[] args) {
	try {
		DatagramSocket ss=new DatagramSocket(7000);
		byte[] buffer=new byte[1024];
		DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
		ss.receive(packet);
		System.out.println("Message from client:"+new String(packet.getData()));
		ss.send(packet);
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}

