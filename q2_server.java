import java.util.*;
import java.net.*;
import java.io.*;

public class q2_server
{
    public static void main(String argv[]) throws Exception
    {
        int cport=222;
        int sport=5000;
        byte buf[]=new byte[1024];
        DatagramSocket serversocket=new DatagramSocket(sport);
        DatagramPacket dp=new DatagramPacket(buf,buf.length);
        InetAddress ia=InetAddress.getLocalHost();
        System.out.println("Server Up and Running");
        serversocket.receive(dp);
        String str=new String(dp.getData(),0,dp.getLength());
        System.out.println("Client Said: "+str);
        System.out.println("Sending it back to Client");
        buf=str.getBytes();
        serversocket.send(new DatagramPacket(buf,str.length(),ia,cport));
    }
}
