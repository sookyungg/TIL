public class Animal {
	private String species;
	private String name;
	private int age;

	public void speak() {
		System.out.println("동물이 소리를 냅니다.");
	}

	public void drink() {
		System.out.println("동물이 물을 마십니다.");
	}

	public static void main(String[] args) {
		// Animal 클래스의 객체 생성
		Animal animal = new Animal();

	}
}

