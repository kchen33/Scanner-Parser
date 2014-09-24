import java.text.*;
import java.io.*;
import java.util.*;

public class MyScanner {

	private static File file;
	private static BufferedReader b;
	private static FileOutputStream f;
	private static ArrayList<String> l;
	private static int count;
	
	public MyScanner(String filename) throws IOException{
		file = new File(filename);
		b = new BufferedReader(new FileReader(file));
		f=new FileOutputStream("newtest.c",true);
		l = new ArrayList<String>();
		Scan();
		count = 0;
	}
	
	public static void write_file(String filename) throws IOException{
		FileOutputStream wf = new FileOutputStream(filename, true);
		String temp = "";
		while((temp = next_token()) != null){
			wf.write(temp.getBytes());
		}
		
	}
	
	public static String next_token(){
		if(count < l.size()){
		String k = l.get(count);
		count++;
		return k;
		}
		else{
		return null;	
		}	
	}
	
	public static void Scan() throws IOException{
		Tokenizer token = new Tokenizer();
		String temp = null;
		while((temp = b.readLine())!=null){
			int size = temp.length();
			for(int i = 0; i < size; i++){
				
				
				char cur = temp.charAt(i);
				if(cur == ' '){
					String white = " ";
					l.add(white);
				}else if(token.check_symbol(cur)){
					if(cur == '/'){
						if((i+1<size) && (temp.charAt(i+1)=='/')){
							for(int j = i; j<size; j++){
								String com1 = temp.charAt(j)+"";
								l.add(com1);
							}
							i = size;
						}else{
							String slash = "/";
							l.add(slash);
						}
					}else{
						String symbol = cur+"";
						l.add(symbol);
					}
				}else if(token.check_digit(cur)){
					String num = "";
					while(i<size && (token.check_digit(temp.charAt(i)) || token.check_letter(temp.charAt(i)))){
						num = num + temp.charAt(i);
						i++;
					}
					i = i-1;
					if(token.check_number(num)){
						l.add(num);
					}else{
						System.out.println("Wrong token type for "+num );
						System.exit(1);
					}
				}else if(cur == '"'){
					String str = temp.charAt(i)+"";
					i = i+1;
					while((temp.charAt(i)) != '"'){
						str = str+temp.charAt(i);
						i++;
					}
					str = str+temp.charAt(i);
					l.add(str);
				}else if(token.check_letter(cur)){
					String iden = "";
					while(i<size && (token.check_digit(temp.charAt(i)) || token.check_letter(temp.charAt(i)))){
						iden = iden + temp.charAt(i);
						i++;
					}
					i = i-1;
					if(token.check_reservedword(iden)){
						l.add(iden);
					}else if(token.check_identifier(iden)){
						iden = iden+"_cs254";
						l.add(iden);
					}else{
						System.out.println("Wrong token type for "+iden);
						System.exit(1);
					}
				}else if(cur == '#'){
					String com2 = "";
					for(int j = i; j<size; j++){
						com2 = com2+temp.charAt(j);
					}
					i = size;
					l.add(com2);
				}else{
					System.out.println("Wrong token type for "+cur);
					System.exit(1);
				}
				
			}
			String next = "\r";
			l.add(next);
		}
		
		b.close();
		f.close();
	}
		
	
	
}
