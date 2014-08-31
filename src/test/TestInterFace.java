package test;

import java.io.File;
import java.io.IOException;

public class TestInterFace {
	int x = 10;

	public static void main(String[] args) throws IOException {
		TestInterFace t = new TestInterFace();
		System.out.println(t.x + Var.x);

		System.out.println(Var.y);
		File[] files = File.listRoots();
		for(File file:files){
			System.out.println(file.getCanonicalPath());
		}
		
		double b = 90;
		System.out.println(b);
	}
}
