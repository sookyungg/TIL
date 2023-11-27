/**
 * public → 이름 그대로 내부는 물론 외부 패키지의 모든 클래스에서 접근을 가능하게 합니다.
 *
 * private → 이름 그대로 해당 멤버가 선언된 클래스 내부에서만 접근할 수 있습니다.
 *
 * default → default 접근 제어자는 본인과 같은 패키지에 있는 클래스만 접근이 가능하고, 외부 패키지에서는 접근이 불가합니다.
 *
 * - 기존에 작성된 클래스를 재활용할 수 있습니다.
 * - 부모 클래스를 상속받은 자식클래스는 부모 클래스에 정의된 속성과 행위(변수와 메서드)를 다시 선언할 필요가 없습니다.
 * - 클래스 간의 계층적 관계를 구성함으로써 다형성의 문법적 토대를 마련합니다.
 * */
public class Dog extends Animal {
	private String gender;

	public void walk() {
		System.out.println("강아지가 산책을 합니다.");
	}

	// 부모 클래스의 메서드 동작을 재정의 하는 것
	// @Override
	public void bark() {
		System.out.println("월월");
	}
}