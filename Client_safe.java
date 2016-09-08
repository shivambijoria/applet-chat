

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Scanner;
import java.net.*;
import java.io.*;


/*
<applet code="Client_safe" width=730 height=400>
</applet>
*/


public class Client_safe extends Applet implements ItemListener, AdjustmentListener, MouseMotionListener, ActionListener
{	
TextArea text;
TextArea text1;
String val;
String a;
Button send;
Button recieve;
 PrintWriter out;
 BufferedInputStream bruf;
   DataInputStream in;
     InputStream inFromServer;
   OutputStream outToServer;
   public void init()
   {	
		
 text = new TextArea("write",10,30);
add (text);
 text1 = new TextArea("read",10,100);
add (text1);
send = new Button("send");
add(send);
send.addActionListener(this);
recieve = new Button("recieve");
add(recieve);
recieve.addActionListener(this);
   }
   public void actionPerformed(ActionEvent ae)
{

String str= ae.getActionCommand();
Read r;

if(str.equals("send"))
{a=text.getText();
Write w=new Write(out,a);}


if(str.equals("recieve"))
r=new Read(bruf);

}


public void itemStateChanged(ItemEvent e)
{}
public void adjustmentValueChanged(AdjustmentEvent ae)
{}
public void mouseMoved(MouseEvent me)
{



}
public void mouseDragged(MouseEvent me)
{}


public void start()
{

      String serverName = "SHIVAM-PC";
      int port = 4000;
      try
      {int l=0;
	  String s="gsfsh";
	  
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);
		 Socket givename = new Socket(serverName,4001);
		 OutputStream givenamestream;
		 givenamestream = givename.getOutputStream();
		 try (ObjectOutputStream objOStrm = new ObjectOutputStream(givenamestream))
{

objOStrm.writeObject("I AM IAN");
}
catch(Exception e)
{
e.printStackTrace();
}
         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());
         outToServer = client.getOutputStream();
          out =
                       new PrintWriter(outToServer);

         out.write("Hello from "
                      + client.getLocalSocketAddress());
					  out.flush();
          inFromServer = client.getInputStream();
         in =
                        new DataInputStream(inFromServer);
						
        
		  bruf = new BufferedInputStream(in);
		// while(bruf.read()!=0)
          //{System.out.print("" + (char) bruf.read());
		  //}
		  //System.out.print("\nover");
		  //FileWriter f0 = new FileWriter("C:/Users/SHIVAM/Desktop/study/java/File1.txt");
		  //f0.write(s);
		  
		 // Read a=new Read(bruf);
		 //client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
}




class Read extends Thread
{
BufferedInputStream a;

Read(BufferedInputStream b)
{
this.a=b;
start();

}


public void run(){

{
try{

{

int aa=1;
int chread;
String o="";

int counter=0;
while(aa==1)
          {
int av=a.available();
if(av!=0)
{
aa=1;
		  
chread =a.read();
if(chread!=-1)
{char jo=(char) chread;
//p.append(jo);

//aa++;
o += ""+jo; 

text1.setText(o);
}
//System.out.println("reading  "+counter);

}
if(av==0)
{

//System.out.println("in av==0 "+counter);
Thread.sleep(500);
}


//System.out.println("check3 "+counter);

counter++;
		  }
	System.out.println("Outside while loop but in read");	  
}
try{
start();
}
catch(Exception e)
{System.out.println("2");
e.printStackTrace();
}

}
catch(Exception e)
{System.out.println("An Exception has occured");
e.printStackTrace();}
}



}
public void parampa(){


}

}














class Write extends Thread
{
PrintWriter a;
String sg;
Write(PrintWriter b,String srg)
{
try{

{
this.a=b;
this.sg=srg;

      

a.write(sg);
a.flush();

	
}
try{
start();
}
catch(Exception e)
{System.out.println("2");
e.printStackTrace();
}
}
catch(Exception e)
{System.out.println("An Exception has occured");}
}

public void run(){}
}

}
//end of client_interface class