import java.util.*;
import java.io.*;
import java.net.*;
public class q1_client {
    public static byte buf[] = new byte[1024];
    public static int cport = 222, sport = 5000;
    public static void main(String argv[]) throws Exception {
        DatagramSocket clientsocket=new DatagramSocket(cport);
        DatagramPacket dp=new DatagramPacket(buf,buf.length);
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        InetAddress ia=InetAddress.getLocalHost();
        String start_client="Client Started";
        String end_client="Client Ended";
        System.out.println("Client has started Running");
        buf=start_client.getBytes();
        clientsocket.send(new DatagramPacket(buf,start_client.length(),ia,sport));
        System.out.println("Enter Something // exit to exit the client");
        while(true)
        {
            String str1=new String(br.readLine());
            if(str1.equals("exit"))
            {
                buf=end_client.getBytes();
                clientsocket.send(new DatagramPacket(buf,end_client.length(),ia,sport));
                break;
            }
            else
            {
                System.out.println("Client Does Nothing");
            }
        }
    }
}
