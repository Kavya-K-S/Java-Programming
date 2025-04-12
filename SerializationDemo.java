package test1.java;
import java.io.*;
public class SerializationDemo {
		public static void main(String[] args) {
			String emp="Hello world";
			try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C:/Users/Kavya KS/eclipse-workspace/test.txt"))){
				out.writeObject(emp);
				System.out.println("Employee Serialization Successfull");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			try {
				
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream("C:/Users/Kavya KS/eclipse-workspace/test.txt"));
				String data=(String) ois.readObject();
				System.out.println(data);
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
}



