import java.net.*;
import java.io.*;
public class QuoteClient {
	public static void main(String args[]) throws UnknownHostException, IOException {
		String line,temp;
		//Create a socket on the local host with the port of the server
		//I set this to 6017 as insturcted
		Socket s = new Socket("127.0.0.1",6017);
		//Buffered reader gets input stream from the server
		BufferedReader bin = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//This reads the server input and prints it
		while((line=bin.readLine())!=null) {
			System.out.println(line);
		}
		//closes the server once done
		s.close();
	}
	
}
