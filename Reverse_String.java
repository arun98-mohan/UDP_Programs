//Client

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Reverse_String
{
	public static void main (String[] args)
	{
		try
		{
			InetAddress ip=InetAddress.getLocalHost();
			int port = 4444;
			Scanner sc=new Scanner(System.in);
			Socket S=new Socket(ip,port);
			DataInputStream dis=new DataInputStream (S.getInputStream());
DataOutputStream dos=new DataOutputStream(S.getOutputStream());
			String inp=sc.nextLine();
			dos.writeUTF(inp);
			String a=dis.readUTF();
			System.out.println(a);
		}
		catch  (Exception e)
		{
			System.out.println("Error"+e.getMessage());
		}
	}
}
