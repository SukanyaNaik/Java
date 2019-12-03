package simpleInheritance;

public class SimpleInheritance {

	public static void main(String[] args)
	{
		Shape s = new Shape();
		s.display();
		
		ShapeCircle sc = new ShapeCircle();
		sc.display();
		
		ShapeTriangle st = new ShapeTriangle();
		st.display();
		
		s.test();
		sc.test();
		st.test();
	}
}
