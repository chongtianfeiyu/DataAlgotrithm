package com.azalea.common;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BinTreeGennerater {

	public <T extends Comparable> BinNode getBinSearchTree(T[] arrObj) {
		BinNode rootNode = null;
		for (int i = 0; i < arrObj.length; ++i) {
			if (rootNode == null) {
				rootNode = createBinNode(arrObj[i]);
			} else {
				buildBinSearchNode(rootNode, createBinNode(arrObj[i]));
			}
		}
		return rootNode;
	}

	private <T extends Comparable> void buildBinSearchNode(BinNode<T> rootNode,
			BinNode<T> node) {
		if (rootNode != null) {
			BinNode curNode = rootNode;
			while (curNode != null) {
				if (node.compareTo(curNode) > 0) {
					curNode = curNode.getRightNode();
				} else if (node.compareTo(curNode) < 0) {
					curNode = curNode.getLeftNode();
				} else {
					curNode = node;
					return;
				}
			}
			curNode = node;
		}
	}

	public <T extends Comparable> BinNode getBinTree(T[] arrObj) {

		BinNode rootBin = null;
		BinNode lstNode = null;

		Deque<BinNode<T>> nodeQue = new LinkedList<BinNode<T>>();

		if (arrObj != null) {
			for (T obj : arrObj) {

				BinNode currentNode = createBinNode(obj);
				nodeQue.add(currentNode);

				if (rootBin == null) {
					rootBin = currentNode;
					continue;
				}

				BinNode headNode = nodeQue.getFirst();

				if (headNode.hasLeftNode() == false) {
					headNode.setLeftNode(currentNode);
				} else if (headNode.hasRightNode() == false) {
					headNode.setRightNode(currentNode);
					nodeQue.removeFirst();
				}

			}
		}

		return rootBin;
	}

	private <T extends Comparable> BinNode createBinNode(T obj) {

		BinNode node = new BinNode(obj);

		return node;
	}

}
