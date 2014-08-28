package com.azalea.common;

import java.util.Random;

public class ArrayGennerator {
	/**
	 * get the array specified in a rang by low and high
	 * 
	 * @param lenth
	 * @param rangLow
	 * @param rangHigh
	 * @return random array
	 */
	public static int[] getIntArray(final int lenth, final int rangLow,
			final int rangHigh) {

		Random rand = new Random();
		int range = Math.abs(rangHigh - rangLow);

		int[] arr = new int[lenth];

		for (int i = 0; i < lenth; ++i) {
			arr[i] = rand.nextInt(range) + rangLow;
		}

		return arr;
	}

	/**
	 * get the array specified in a rang of integers
	 * 
	 * @param length
	 * @return random array
	 */
	public static int[] getIntArray(final int length) {

		Random rand = new Random();
		int[] arr = new int[length];

		for (int i = 0; i < length; ++i) {
			arr[i] = rand.nextInt(length);
		}

		return arr;
	}
}
