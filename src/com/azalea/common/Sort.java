package com.azalea.common;

public class Sort {
	
	/**
	 * 希尔排序
	 * @param arrObjs
	 */
	public static <T extends Comparable<T>> void shellSort(T[] arrObjs) {

		int j = 0;
		if (arrObjs != null) {
			int arrLength = arrObjs.length;
			for (int gap = arrLength / 2; gap > 0; gap /= 2) {
				for (int i = gap; i < arrLength; ++i) {
					T tmpObj = arrObjs[i];
					for (j = i; j >= gap
							&& tmpObj.compareTo(arrObjs[j - gap]) < 0; j -= gap) {
						arrObjs[j] = arrObjs[j - gap];
					}
					arrObjs[j] = tmpObj;
				}
			}
		}
	}

	/**
	 * 快速排序算法
	 * 
	 * @param arrObjs
	 */
	public static <T extends Comparable<T>> void quicKSort(T[] arrObjs) {
		quickSort(arrObjs, 0, arrObjs.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T[] arrObjs,
			int low, int hight) {

		if (low < hight) {
			int pivot = partition(arrObjs, low, hight);
			quickSort(arrObjs, low, pivot - 1);
			quickSort(arrObjs, pivot + 1, hight);
		}

	}
	
	/**
	 * 快速排序核心,分割算法
	 * @param arrObjs
	 * @param l
	 * @param h
	 * @return
	 */
	private static <T extends Comparable<T>> int partition(T[] arrObjs,
			final int l, final int h) {

		int left = l;
		int right = h;
		T flagObj = arrObjs[l];

		while (left < right) {

			while ((left < right) && (arrObjs[right].compareTo(flagObj) > 0)) {
				--right;
			}

			if (left < right) {
				arrObjs[left] = arrObjs[right];
				++left;
			}

			while ((left < right) && (arrObjs[left].compareTo(flagObj) <= 0)) {
				++left;
			}

			if (left < right) {
				arrObjs[right] = arrObjs[left];
				--right;
			}
		}

		arrObjs[left] = flagObj;
		return left;
	}

	/**
	 * 重新调整小顶堆
	 * @param a
	 * @param parrentIndex
	 * @param length
	 */
	private static <T extends Comparable<T>> void MinHeapFixdown(T a[],
			int parrentIndex, int length) {
		int sonIndex;
		T temp;
		temp = a[parrentIndex];
		sonIndex = 2 * parrentIndex + 1;
		while (sonIndex < length) {

			// 在左右孩子中找最小的
			if (sonIndex + 1 < length
					&& (a[sonIndex + 1].compareTo(a[sonIndex]) < 0))
				sonIndex++;

			if (a[sonIndex].compareTo(temp) >= 0)
				break;
			// 把较小的子结点往上移动,替换它的父结点
			a[parrentIndex] = a[sonIndex];
			parrentIndex = sonIndex;
			sonIndex = 2 * parrentIndex + 1;
		}
		a[parrentIndex] = temp;
	}

	/**
	 * 建立小顶堆
	 * @param a
	 */
	public static <T extends Comparable<T>> void MakeMinHeap(T a[]) {
		int n = a.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			MinHeapFixdown(a, i, n);
	}
	
	/**
	 * 堆排序
	 * @param a
	 */
	public static <T extends Comparable<T>> void heapSort(T a[]) {

		MakeMinHeap(a);

		int n = a.length;

		for (int i = n - 1; i >= 1; i--) {
			T obj = a[0];
			a[0] = a[i];
			a[i] = obj;
			MinHeapFixdown(a, 0, i);
		}
	}
	
	/**
	 * 插入排序
	 * @param arrObjs
	 */
	public static <T extends Comparable<T>> void insertSort(T[] arrObjs) {

		int j = 0;

		for (int i = 1; i < arrObjs.length; ++i) {
			T curObj = arrObjs[i];
			for (j = i; j > 0 && (curObj.compareTo(arrObjs[j - 1]) < 0); --j) {
				arrObjs[j] = arrObjs[j - 1];
			}

			arrObjs[j] = curObj;
		}
	}
}
