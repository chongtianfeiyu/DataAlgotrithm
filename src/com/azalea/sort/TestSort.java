package com.azalea.sort;

import com.azalea.common.ArrayGennerator;
import com.azalea.common.SmrtPrint;
import com.azalea.common.Sort;

public class TestSort {
	public static void main(String[] args) {
		int[] arr =  ArrayGennerator.getIntArray(30);
		Integer[] arrIntegers = new Integer[arr.length];

		for (int i = 0; i < arr.length; ++i) {
			arrIntegers[i] = arr[i];
		}

		Integer[] sameArr = arrIntegers.clone();

		for (int intobj : arrIntegers)
			SmrtPrint.print(intobj + " ");
		SmrtPrint.println("");

		// final int n = arrIntegers.length;
		// for (int i = n / 2 - 1; i >= 0; --i) {
		// Sort.MinHeapFixdown(arrIntegers, i, n);
		// }

		// for(int i = n-1;i>=0;--i){
		// Integer tmp = arrIntegers
		// }

		// Sort.insertSort(arrIntegers);
		// for (int intobj : sameArr) {
		// SmrtPrint.print(intobj + " ");
		// }
		// SmrtPrint.println("");

		// arrIntegers = sameArr.clone();
		Sort.quicKSort(arrIntegers);

		for (int intobj : arrIntegers)
			SmrtPrint.print(intobj + " ");
		SmrtPrint.println("");

	}
}
