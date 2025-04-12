import java.io.*;
import java.net.*;
public class clientskt {
	public static void main(String[] args) {
		try {
			DatagramSocket s=new DatagramSocket();
			String msg="Hello Server. This is client";
			byte[] buffer=msg.getBytes();
			InetAddress add=InetAddress.getByName("localhost");
			DatagramPacket packet=new DatagramPacket(buffer,buffer.length,add,7000);
			s.send(packet);
			s.receive(packet);
			System.out.println("Recieved from server :"+new String(packet.getData()));
			s.close();
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
