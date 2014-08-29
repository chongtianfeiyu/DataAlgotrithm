package com.azalea.maxSub;

import com.azalea.common.BinNode;
import com.azalea.common.BinTreeGennerater;
import com.azalea.common.SmrtPrint;

public class TestBinTree {

	public static void main(String[] args) {

		BinTreeGennerater gen = new BinTreeGennerater();
		// 前序遍历:
		char[] arrObjects = "abcdefg".toCharArray();
		System.out.println(arrObjects.length);
		Character[] arrChars = new Character[arrObjects.length];
		for (int i = 0; i < arrObjects.length; ++i) {
			arrChars[i] = arrObjects[i];
		}
		BinNode<Character> binTree = gen.<Character> getBinTree(arrChars);

		SmrtPrint.treePrePrint(binTree);
		SmrtPrint.treeMidPrint(binTree);
		SmrtPrint.treePostPrint(binTree);
	}
}
