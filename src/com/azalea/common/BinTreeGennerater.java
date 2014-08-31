package com.azalea.common;

import java.util.Deque;
import java.util.LinkedList;

public class BinTreeGennerater {

	public <T extends Comparable<?>> BinNode<T> getBinSearchTree(T[] arrObj) {
		BinNode<T> rootNode = null;
		for (int i = 0; i < arrObj.length; ++i) {
			if (rootNode == null) {
				rootNode = createBinNode(arrObj[i]);
			} else {
				buildBinSearchNode(rootNode, createBinNode(arrObj[i]));
			}
		}
		return rootNode;
	}

	public <T extends Comparable<?>> void buildBinSearchNode(
			BinNode<T> rootNode, BinNode<T> node) {

		if (rootNode != null) {

			BinNode<T> curNode = rootNode;
			while (curNode != null) {
				int compareValue = node.compareTo(curNode);
				if (compareValue < 0) {

					if (curNode.hasLeftNode()) {
						curNode = curNode.getLeftNode();
					} else {
						curNode.setLeftNode(node);
						node.setParrentNode(curNode);
						return;
					}
				} else if (compareValue > 0) {

					if (curNode.hasRightNode()) {
						curNode = curNode.getRightNode();
					} else {
						curNode.setRightNode(node);
						node.setParrentNode(curNode);
						return;
					}
				} else {
					return;
				}
			}
		}
	}

	public <T extends Comparable> BinNode<T> getBinTree(T[] arrObj) {

		BinNode<T> rootBin = null;

		Deque<BinNode<T>> nodeQue = new LinkedList<BinNode<T>>();

		if (arrObj != null) {
			for (T obj : arrObj) {

				BinNode<T> currentNode = createBinNode(obj);
				nodeQue.add(currentNode);

				if (rootBin == null) {
					rootBin = currentNode;
					continue;
				}

				BinNode<T> headNode = nodeQue.getFirst();

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

	public <T extends Comparable> BinNode createBinNode(T obj) {

		BinNode node = new BinNode(obj);

		return node;
	}

}
