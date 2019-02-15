//Client

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class pay_client
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
			System.out.println("Enter No. of Working Days: ");
			String inp=sc.nextLine();
			dos.writeUTF(inp);
			String ans=dis.readUTF();
			System.out.println(ans);
		}
		catch (Exception e)
		{
			System.out.println("Error"+e.getMessage());
		}

	}
}
