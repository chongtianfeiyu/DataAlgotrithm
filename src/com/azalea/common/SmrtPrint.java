package com.azalea.common;

public class SmrtPrint {

	public static void arrPrintln(int[] arr) {

		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ,");
		}
		System.out.println();

	}

	public static void println(Object ob) {
		System.out.println(ob);
	}
	
//	public static <T> void treePrePrint(BinNode<T> rootNode){
//		
//		
//		
//	}
}
