package com.azalea.maxSub;


import com.azalea.common.ArrayGennerator;
import com.azalea.common.SmrtPrint;

public class TestMaxSub {

	public static int maxSubSum(int[] arr) {
		int maxSum = 0, theSum = 0;
		maxSum = arr[0];
		int indexFlag = 0;
		for (int j = 0; j < arr.length; ++j) {
			theSum += arr[j];
			if (theSum > maxSum) {
				maxSum = theSum;
				indexFlag = j;
			}
			if (theSum < 0) {
				theSum = 0;
			}
		}
		System.out.println("index :" + indexFlag);
		return maxSum;
	}

	public static void main(String[] args) {
		int[] array = ArrayGennerator.getIntArray(30, -90, -9);

		SmrtPrint.arrPrintln(array);

		System.out.println("Max sum :" + maxSubSum(array));
	}
}
