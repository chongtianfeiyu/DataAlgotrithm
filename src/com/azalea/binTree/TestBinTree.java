package com.azalea.binTree;

import com.azalea.common.BinNode;
import com.azalea.common.BinSearchTree;
import com.azalea.common.BinTreeGennerater;
import com.azalea.common.SmrtPrint;

public class TestBinTree {

	public static void main(String[] args) {

		BinTreeGennerater gen = new BinTreeGennerater();
		// 前序遍历:
		char[] arrObjects = "947463658cduwefsoi".toCharArray();
		System.out.println(arrObjects.length);
		Character[] arrChars = new Character[arrObjects.length];
		for (int i = 0; i < arrObjects.length; ++i) {
			arrChars[i] = arrObjects[i];
		}
		BinSearchTree<Character> binTree = new BinSearchTree<Character>(
				arrChars);

		// SmrtPrint.treePrePrint(binTree.getTree());
		// SmrtPrint.treeMidPrint(binTree.getTree());
		// SmrtPrint.treePostPrint(binTree.getTree());

		System.out.println(binTree.remove('e'));
		SmrtPrint.treeMidPrint(binTree.getTree());
	}
}
