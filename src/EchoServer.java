import java.net.*;
import java.io.*;
public class EchoServer {
	public static void main(String args[]) throws Exception{
		 try{
			 String echo,temp;
			 //Use the serversocket with the same port as the client 
			 ServerSocket s1 = new ServerSocket(1412);
			 System.out.println("The server has opened on port 1412");

			 //runs the server so it does not close until the user wants it to
			 while(true) {
				 //accept method accepts the incoming socket request 
				 Socket ss= s1.accept();
				 //Buffered Reader accepts the input from the client and then feeds it to a variable
				 BufferedReader br1= new BufferedReader(new InputStreamReader(ss.getInputStream()));
				 echo =br1.readLine();
				 //Replaces client with server
				 echo = echo.replace("Client", "Server");
				 echo = echo.replace("client", "server");
				 temp = echo;
				 //prints the echo response
				 PrintStream p = new PrintStream(ss.getOutputStream());
				 p.println(temp);
				 //This closes the server when needed
				 if(temp.contains("goodbye") ||temp.contains("Goodbye")) {
					 ss.close();
					 break;
				 }
			 }
		 }
		 catch(IOException ioe){
		      System.err.println(ioe);
		    }
		
		
	}

}
