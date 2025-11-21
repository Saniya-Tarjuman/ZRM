package demo;

public class LowerCase {

	public static void main(String[] args) {
		String s = "Saniya Tarjuman";
		int caps = 0,small = 0;
		for(int i = 0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch>='A' && ch<='Z') {
				caps++;
			}else {
				small++;
			}
		}
		System.out.println("Uppercase: "+caps);

	}

}
