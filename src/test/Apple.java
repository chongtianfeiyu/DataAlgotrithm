package test;

public class Apple implements Comparable<Apple> {

	public int weigth;

	public Apple(int weigth) {
		super();
		this.weigth = weigth;
	}

	@Override
	public int compareTo(Apple apple) {
		// TODO Auto-generated method stub
		if (this.weigth > apple.weigth) {
			return 1;
		}
		if (this.weigth < apple.weigth) {
			return -1;
		}
		return 0;
	}

}
