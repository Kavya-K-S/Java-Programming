import java.io.*;
public class ReadWrite {
	
	public static void main(String[] args) throws IOException {
		//Write File
	    FileWriter fous=new FileWriter("C:\\Users\\Kavya KS\\eclipse-workspace\\test1.java\\src\\test1\\java\\sample.txt");
		String st="Hello everyone";
		fous.write(st);
		fous.close();
		//Read file
		FileInputStream fis=new FileInputStream("C:\\Users\\Kavya KS\\eclipse-workspace\\test1.java\\src\\test1\\java\\sample.txt");
		int s;
		do {
			s=fis.read();
			if(s!=1) {
				System.out.print((char)s);
			}
		}while(s!=-1);
		fis.close();
		
	}
}

