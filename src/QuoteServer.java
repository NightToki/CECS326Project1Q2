import java.net.*;
import java.io.*;
public class QuoteServer {
	public static void main(String[] args) {
	    try{
	      ServerSocket sock = new ServerSocket(6017);
	      /*now listen for connections */
	      while(true){
	        Socket client = sock.accept();

	        PrintWriter pout = new PrintWriter(client.getOutputStream(),true);

	        /*write the quote of the day to the socket*/
	        String qotd = "";
	        String day = new java.util.Date().toString();
	        if(day.contains("Sun")) {
	        	qotd ="Osmanthus wine tastes the same as always, but where are those who share the memory";
	        }
	        else if(day.contains("Mon")) {
	        	qotd = "The best defense is a good offense";
	        	
	        }
	        else if(day.contains("Tue")) {
	        	qotd ="I forgor	";
	        }
	        else if(day.contains("Wed")) {
	        	qotd ="Give life to those who are good, judge those who are evil";
	        	
	        }
	        else if(day.contains("Thu")) {
	        	qotd ="If you wish upon a star you might get a better grade";
	        }
	        else if(day.contains("Fri")) {
	        	qotd = "I am the bone of my sword\nSteel is my body and fire is my blood\nI have created over a thousand blades\nUnknown to death\nNor known to life\nHave withstood pain to create many weapons\nYet those hands shall never hold anything\nSo, as I pray, Unlimited Blade Works";
	        	
	        }
	        else if(day.contains("Sat")) {
	        	qotd = "This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair. This chair... is an eyesore";
	        	
	        }
	        pout.println(qotd);
	        
	        /*close the socket and resume*/
	        /*listening for connections*/
	        client.close();
	      }
	    }
	    catch(IOException ioe){
	      System.err.println(ioe);
	    }
	  }
}
