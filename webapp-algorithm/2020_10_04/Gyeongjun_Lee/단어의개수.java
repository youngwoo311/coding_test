package etc;

import java.util.Scanner;
import java.util.StringTokenizer;

//문자열
public class 단어의개수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input);
		
		System.out.println(st.countTokens());
		
	}
}
