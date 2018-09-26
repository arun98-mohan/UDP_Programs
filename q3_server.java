import java.io.*;
import java.net.*;
import java.util.*;

public class q3_server
{
    public static byte buf[]=new byte[1024];
    public static int cport=222, sport=5001;
    public static void main(String argv[]) throws Exception
    {
        int f=1;
        DatagramPacket dp=new DatagramPacket(buf,buf.length);
        DatagramSocket serversocket=new DatagramSocket(sport);
        InetAddress ia=InetAddress.getLocalHost();
        System.out.println("Server Running");
        while(true)
        {
            serversocket.receive(dp);
            String str2=new String(dp.getData(),0,dp.getLength());
            String str4="Yes";
            buf=str4.getBytes();
            f++;
            if(f==3)
            {
                Thread.sleep(8000);
            }
            else
            {
            serversocket.send(new DatagramPacket(buf,str4.length(),ia,222));
            }
        }
}
}
