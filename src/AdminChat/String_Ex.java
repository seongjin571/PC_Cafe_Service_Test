package AdminChat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class String_Ex {
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		String a;
		String return_str;
		string_checker ck = new string_checker();
		a=in.next();
		return_str=ck.check(a);
		System.out.println(return_str);
	}
}
class string_checker{
	
	private static ArrayList<String> filter=new ArrayList<String>();
	static {
		filter.add("시발");
		filter.add("미친");
	}
	public String check(String input) {
		Iterator<String> it=filter.iterator();
		while(it.hasNext()) {
			String str=it.next();
			if(input.contains(str)) {
				input=input.replace(str, "*");		
			}
		}	
		return input;	
	}
}
