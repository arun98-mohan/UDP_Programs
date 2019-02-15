import java.io.*;
import java.net.*;
import java.util.*;
class char_count
{
	static final int MAX_CHAR=256;
	static String getCharCount(String str)
	{
		String ans="{";
		int count[]=new int[MAX_CHAR];
		int len=str.length();
		for(int i=0;i<len;i++)
			count[str.charAt(i)]++;
		char ch[]=new char[str.length()];		
		for(int i=0;i<len;i++)
		{
			ch[i]=str.charAt(i);
			int find=0;
			for(int j=0;j<=i;j++)
			{
				if(str.charAt(i)==ch[j])
					find++;
			}
			if(find==1)
				ans+=str.charAt(i)+":"+count[str.charAt(i)]+" ";
		}
		ans+="}";
		return ans;
	}
	public static void main(String[] args) throws Exception
	{
		try 
		{
			ServerSocket obj=new ServerSocket(5000);
			Socket obj1=obj.accept();
			while(true)
			{
				DataInputStream din=new DataInputStream(obj1.getInputStream());
				DataOutputStream dout=new DataOutputStream(obj1.getOutputStream());
				String str=din.readUTF();
				if(str.equalsIgnoreCase("exit")) break;
				System.out.println(str);
				String result=getCharCount(str);
				dout.writeUTF(result);
			}
			obj.close();
		}
		catch(Exception e)
		{
			System.out.println("ended");
		}
	}
}

