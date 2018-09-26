import java.io.*;
import java.net.*;
import java.util.*;

public class q3_client
{
    public static DatagramSocket clientsocket;
    public static BufferedReader br;
    public static DatagramPacket dp;
    public static InetAddress ia;
    public static byte buf[]=new byte[1024];
    static void send_packet() throws Exception
    {
        String str1=new String(br.readLine());
        if(str1.equals("exit"))
        {
            return;
        }
        buf=str1.getBytes();
        clientsocket.send(new DatagramPacket(buf,str1.length(),ia,5001));
        //Wait for Acknowledgement from Server for 6 seconds, if not send the packet again..
        clientsocket.setSoTimeout(6000);
        try
        {
            clientsocket.receive(dp);
        }
        catch(SocketTimeoutException s)
        {
            System.out.println("Ack Not Received from Server, hence sending again, enter message");
            send_packet();
        }
    }
    public static void main(String argv[]) throws Exception
    {
        clientsocket=new DatagramSocket(222);
        ia=InetAddress.getLocalHost();
        br=new BufferedReader(new InputStreamReader(System.in));
        dp=new DatagramPacket(buf,buf.length);
        System.out.println("Client Up and Running");
        while(true)
        {
        System.out.println("Enter Message to be Sent to Server");
        send_packet();
        }
    }
}
