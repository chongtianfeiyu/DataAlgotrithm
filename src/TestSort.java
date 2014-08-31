import java.awt.print.Printable;

import com.azalea.common.ArrayGennerator;
import com.azalea.common.SmrtPrint;
import com.azalea.common.Sort;

public class TestSort {
	public static void main(String[] args) {
		int[] arr = ArrayGennerator.getIntArray(7);
		Integer[] arrIntegers = new Integer[arr.length];

		for (int i = 0; i < arr.length; ++i) {
			arrIntegers[i] = arr[i];
		}

		Integer[] sameArr = arrIntegers.clone();

//		Sort.insertSort(arrIntegers);
//		for (int intobj : sameArr) {
//			SmrtPrint.print(intobj + " ");
//		}

		SmrtPrint.println("");
		for (int intobj : arrIntegers)
			SmrtPrint.print(intobj + " ");
		SmrtPrint.println("");

		arrIntegers = sameArr.clone();
		Sort.heapSort(arrIntegers);

		for (int intobj : arrIntegers)
			SmrtPrint.print(intobj + " ");
		SmrtPrint.println("");

	}
}
