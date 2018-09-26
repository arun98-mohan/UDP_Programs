import java.util.*;
import java.io.*;
import java.net.*;

public class q2_client
{
public static void main(String argv[]) throws Exception
    {
        int cport=222;
        int sport=5000;
        byte buf[]=new byte[1024];
        DatagramSocket clientsocket=new DatagramSocket(cport);
        DatagramPacket dp=new DatagramPacket(buf,buf.length);
        InetAddress ia=InetAddress.getLocalHost();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Client Up and Running"+"\nEnter A Message: ");
        String str3=new String(br.readLine());
        buf=str3.getBytes();
        System.out.println("Sending Data to Server");
        clientsocket.send(new DatagramPacket(buf,str3.length(),ia,sport));
        System.out.println("Receiving Acknowledgement from Server");
        clientsocket.receive(dp);
        String str2=new String(dp.getData(),0,dp.getLength());
        System.out.println("Server Said: "+str2);
        System.out.println("Client Exiting");
    }
}
