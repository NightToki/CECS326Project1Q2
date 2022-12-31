import java.net.*;
import java.util.Scanner;
import java.io.*;
public class EchoClient {
	public static void main(String args[]) throws UnknownHostException, IOException {
		//A loop that will continuously run the client until specific close word is used
		while(true) {
			
			String echo,temp;
			// Buffered reader to get an input from the client/user
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//Created a socket on the local host with the port of the server
			//which i have set to 1412
			Socket s = new Socket("127.0.0.1",1412);
			//This Bufferedreader gets the input stream from the server
			BufferedReader br1= new BufferedReader(new InputStreamReader(s.getInputStream()));
			//Get the String from the user and put it in a variable
			System.out.println("Enter a String to get Echoed: ");
			echo = br.readLine();
			//Allows passage to the server
			PrintStream p= new PrintStream(s.getOutputStream());
			//Pass the String to the server
			p.println(echo);
			//Gets the input from the server and prints it
			temp= br1.readLine();
			System.out.println(temp);
			// If the user says goodbye then the client has closed
			//out and the server will close
			 if(temp.contains("goodbye") ||temp.contains("Goodbye")) {
				 s.close();
				 System.out.println("The server has closed");
				 break;
			 }
		}
		   
	   }
}
