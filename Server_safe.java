import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Scanner;
import java.net.*;
import java.io.*;

/*
<applet code="Server_safe" width=730 height=400>
</applet>
*/


public class Server_safe extends Applet implements ItemListener, AdjustmentListener, MouseMotionListener, ActionListener, Runnable {
TextArea text;
TextArea text1;
String val;
String ak;
Button submit;
Button recieve;
Button send;
ServerSocket s14 ;
Socket s24;
ServerSocket waitforname;
Socket name;
InputStream nameinputstream;
InputStream i14;
OutputStream o14;
DataInputStream di14;
DataOutputStream do14 ;
Thread t1;

StringBuffer p=new StringBuffer(1000);
PrintWriter out;
public void init(){
this.t1=new Thread(this,"demo Thread");
 text = new TextArea("write",10,30);
add(text);
 text1 = new TextArea("read",10,100);
add(text1);
submit = new Button("submit");
add(submit);
submit.addActionListener(this);
recieve = new Button("recieve");
add(recieve);
recieve.addActionListener(this);
send = new Button("send");
add(send);
send.addActionListener(this);

System.out.println("initialized all items");
}

public void start()
{


}



public void actionPerformed(ActionEvent ae)
{

String str= ae.getActionCommand();
if(str.equals("send"))
{
ak=text.getText();
Write w=new Write(out,ak);
w.parampa();
}

if(str.equals("submit"))
{
try
      {
	  s14 = new ServerSocket(4000);
 s24 = new Socket();
waitforname = new ServerSocket(4001);
 name = new Socket();

 System.out.println("Waiting for client on port " +
            s14.getLocalPort() + "...");
s24 = s14.accept();
name = waitforname.accept(); 
 
 
nameinputstream=name.getInputStream() ;        
	try(ObjectInputStream objIStrm = new ObjectInputStream(nameinputstream))
{

String name;
name = (String)objIStrm.readObject();
System.out.println("Recently connected to "+name);
}
catch(Exception e)
{
System.out.println("Exception during deserialization of name:"+e);
e.printStackTrace();
}	 
      		
i14=s24.getInputStream() ;
di14 = new DataInputStream(i14);
o14=s24.getOutputStream(); ;
do14 = new DataOutputStream(o14);
out =
                       new PrintWriter(o14);
					   out.write("Hello from "
                      + s24.getLocalSocketAddress());
					  out.flush();

System.out.println("this socket is connected to "+s24.getInetAddress());

 BufferedInputStream bruf = new BufferedInputStream(di14);
 
			 
		 // Write w=new Write(o14,);
System.out.println("streams established");

Read a=new Read(di14);
//text1.setText(a);

System.out.println("outside of read and in recieve");
a.parampa();

}
catch(IOException e)
{e.printStackTrace();
}
}
if(str.equals("recieve"))
{
}
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
public void run(){}






class Read extends Thread
{
DataInputStream a;

Read(DataInputStream b)
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
p.append(jo);

//aa++;
o += ""+jo; 

text1.setText(o);
}
System.out.println("reading  "+counter);

}
if(av==0)
{

System.out.println("in av==0 "+counter);
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
Thread tw;
PrintWriter a;
String sg;
Write(PrintWriter b,String srg)
{
try{

{
tw=currentThread();
this.a=b;
this.sg=srg;

      

a.write(sg);
a.flush();
System.out.println("in write");
	
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

public void parampa()
{
System.out.println("the state from utside is"+tw.getState());
}
}

}
//end of class Server_interface






