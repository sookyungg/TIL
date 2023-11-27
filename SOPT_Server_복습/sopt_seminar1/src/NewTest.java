public class NewTest {
	public static void main(String[] arg) {
		String dogOne = new String("dog");
		String dogTwo = new String("dog");

		System.out.println(System.identityHashCode(dogOne));
		System.out.println(System.identityHashCode(dogTwo));

		String testOne = "Test";
		String testTwo = "Test";

		System.out.println(System.identityHashCode(testOne));
		System.out.println(System.identityHashCode(testTwo));
	}
}
