import java.lang.StringBuilder;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Reverse_Server {
	public static void main (String[] args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(4444);
			Socket s=ss.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			String inp=dis.readUTF();
			StringBuilder ans=new StringBuilder();
			ans.append(inp);
			ans.reverse();
			dos.writeUTF(ans.toString());
		}
		catch(Exception e)
		{
			System.out.println("ERRORRRRR");
		}
	}
}
