package com.azalea.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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

	public static void print(Object ob) {
		System.out.print(ob);
	}

	
	public static <T extends Comparable> void treePrePrint(
			final BinNode<T> rootNode) {

		Stack<BinNode<T>> nodeStack = new Stack<BinNode<T>>();

		BinNode<T> tmpNode = rootNode;

		while (tmpNode != null || false == nodeStack.isEmpty()) {

			while (tmpNode != null) {
				print(tmpNode);
				nodeStack.add(tmpNode);
				tmpNode = tmpNode.getLeftNode();
			}
			tmpNode = nodeStack.pop();
			tmpNode = tmpNode.getRightNode();
		}

		println("");
	}

	public static <T extends Comparable> void treeMidPrint(
			final BinNode<T> rootNode) {
		Stack<BinNode<T>> nodeStack = new Stack<BinNode<T>>();

		BinNode<T> tmpNode = rootNode;

		while (tmpNode != null || false == nodeStack.isEmpty()) {

			while (tmpNode != null) {
				nodeStack.add(tmpNode);
				tmpNode = tmpNode.getLeftNode();
			}
			tmpNode = nodeStack.pop();
			print(tmpNode);
			tmpNode = tmpNode.getRightNode();
		}
		println("");
	}

	public static <T extends Comparable> void prettyPrint(
			final BinNode<T> rootNode) {

		print("it hasn't done");
	}

	public static <T extends Comparable> void treePostPrint(
			final BinNode<T> rootNode) {

		Stack<BinNode<T>> nodeStack = new Stack<BinNode<T>>();
		BinNode<T> preNode = null;
		nodeStack.add(rootNode);

		while (!nodeStack.isEmpty()) {

			BinNode<T> curNode = nodeStack.peek();

			if ((curNode.hasLeftNode() == false && curNode.hasRightNode() == false)
					|| (preNode != null && (preNode == curNode.getLeftNode() || preNode == curNode
							.getRightNode()))) {

				print(curNode);
				nodeStack.pop();
				preNode = curNode;

			} else {

				if (curNode.hasRightNode()) {
					nodeStack.push(curNode.getRightNode());
				}
				if (curNode.hasLeftNode()) {
					nodeStack.push(curNode.getLeftNode());
				}
			}
		}
		println("");
	}
}
