package com.azalea.common;

public class Sort {
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

	// 在最小堆中加入新的数据nNum
	private static <T extends Comparable<T>> void MinHeapAddNumber(T[] a,
			int n, T obj) {
		a[n] = obj;
		MinHeapFixup(a, n);
	}

	// 在最小堆中删除数
	private static <T extends Comparable<T>> void MinHeapDeleteNumber(T a[],
			int n) {
		T obj = a[0];
		a[0] = a[n - 1];
		a[n - 1] = obj;
		MinHeapFixdown(a, 0, n - 1);
	}

	private static <T extends Comparable<T>> void MinHeapFixdown(T a[], int i,int n) {
		int j;
		T temp;
		temp = a[i];
		j = 2 * i + 1;
		while (j < n) {
			if (j + 1 < n && (a[j + 1].compareTo(a[j]) < 0)) // 在左右孩子中找最小的
				j++;

			if (a[j].compareTo(temp) >= 0)
				break;

			a[i] = a[j]; // 把较小的子结点往上移动,替换它的父结点
			i = j;
			j = 2 * i + 1;
		}
		a[i] = temp;
	}

	// 建立最小堆
	private static <T extends Comparable<T>> void MakeMinHeap(T a[], int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			MinHeapFixdown(a, i, n);
	}

	public static <T extends Comparable<T>> void heapSort(T a[]) {

		int n = a.length;
		for (int i = n - 1; i >= 1; i--) {
			T obj = a[0];
			a[0] = a[i - 1];
			a[i - 1] = obj;
			MinHeapFixdown(a, 0, i);
		}
	}
	
	public static <T extends Comparable<T>> void heapSortInline(T a[]) {
		
		
	}

	private static <T extends Comparable<T>> void MinHeapFixup(T[] arrObjs,
			int index) {
		if (arrObjs != null) {
			int j;
			T tmp;
			tmp = arrObjs[index];

			// j为父亲节点的下标
			j = (index - 1) / 2; // 父结点
			while (j >= 0 && index != 0) {

				// 比较父亲节点和子节点
				if (arrObjs[j].compareTo(tmp) <= 0)
					break;
				// 把较大的子结点往下移动,替换它的子结点
				arrObjs[index] = arrObjs[j];
				// index记住这个父亲
				index = j;
				// j移动到爷爷
				j = (index - 1) / 2;
			}
			arrObjs[index] = tmp;
		}
	}

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
