package test;

public class TestComparable {
	public static void main(String[] args) {
		Apple ap1 = new Apple(30);
		Apple ap2 = new Apple(23);

		System.out.println(ap1.compareTo(ap2));
	}
}
