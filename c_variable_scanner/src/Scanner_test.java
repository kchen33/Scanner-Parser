import java.util.*;
import java.io.*;

public class Scanner_test {

	public static void main(String[] args) throws IOException{

		System.out.println("Please enter a filename: ");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		
		MyScanner s = new MyScanner(name);
		s.write_file("newtest.c");

	}
}