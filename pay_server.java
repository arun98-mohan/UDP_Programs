import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class pay_server
{
 public static void main(String[] args)
{
try
{
ServerSocket ss=new ServerSocket(4444);
Socket s=ss.accept();
DataInputStream dis=new DataInputStream(s.getInputStream());
DataOutputStream dos=new DataOutputStream(s.getOutputStream());
String inp=dis.readUTF();
StringTokenizer St=new StringTokenizer(inp);
int days=Integer.parseInt(St.nextToken());
int result=days*3000;
dos.writeUTF(Integer.toString(result));
}
catch(Exception e)
{
System.out.println("Error");
}
}
}
