public class TestBody{
	public static void main(String [] args){
		Body b1 = new Body(50.0, 20.0, 5.0, 4.0, 2.0, "hello");
		System.out.println(b1.xxPos);

		Body b2 = new Body(20.0, 25.0, 2.0, 10.0, 1.0, "hi");
		System.out.println(b1.calcDistance(b2));
	}
}