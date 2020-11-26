
public class StringRotation {

	public static void main(String[] args) {
		
		String str = shiftString("abcde",0,1);
		System.out.println(str);
	}
	
	public static String shiftString(String s, int leftShift, int rightShift){
		s = leftrotate(s, leftShift % s.length());
		s = rightrotate(s, rightShift % s.length());
		return s;
	}
	static String leftrotate(String str, int d)
	{
		String ans = str.substring(d) + str.substring(0, d);
		return ans;
	}
	static String rightrotate(String str, int d)
	{
		return leftrotate(str, str.length() - d);
	}

}
