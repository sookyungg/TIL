public class GenericTest {
	public static void main(String[] args) {
		//GenericClass<Integer, String> genericClass = new GenericClass<Integer, String>();
		GenericMethod genericMethod = new GenericMethod();

		String hello = genericMethod.genericMethod("Hello");
		System.out.println(hello); // Hello
	}
}