import java.io.*;
import java.net.*;
import java.util.*;
class char_client
{
public static void main(String[] args) throws Exception
{
 try
{
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
Socket clsct=new Socket("localhost",5000);
DataInputStream din=new DataInputStream(clsct.getInputStream());
DataOutputStream dout=new DataOutputStream(clsct.getOutputStream());
System.out.println("Enter Sentence: ");
String str1=in.readLine();
dout.writeUTF(str1);
String str=din.readUTF();
System.out.println("The Char Count is: "+str);
if(str1.equalsIgnoreCase("exit")) clsct.close();
}
catch(Exception e)
{
System.out.println("ended");
}
}
}

