import java.io.*;
import java.net.*;
import java.util.*;

public class q1_server {

public static byte buf[]=new byte[1024];
public static int cport=222, sport=5000;

public static void main(String argv[]) throws Exception {
DatagramPacket dp=new DatagramPacket(buf,buf.length);
DatagramSocket serversocket=new DatagramSocket(sport);
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
InetAddress ia=InetAddress.getLocalHost();
System.out.println("Server Running");
while(true)
{
    serversocket.receive(dp);
    String str2=new String(dp.getData(),0,dp.getLength());
    System.out.println("Client: "+str2);
}
}
}
 
