package com.azalea.common;

public class BinSearchTree<T extends Comparable> {
	public BinNode<T> rootNode;
	BinTreeGennerater gen = new BinTreeGennerater();

	public BinSearchTree(T[] arrObj) {
		// TODO Auto-generated constructor stub
		this.rootNode = gen.getBinSearchTree(arrObj);
	}

	private void putNode(T obj) {
		gen.buildBinSearchNode(this.rootNode, gen.createBinNode(obj));
	}

	public void makeEmpty() {
		this.rootNode = null;
	}

	public boolean isEmpty() {
		return this.rootNode == null;
	}

	public boolean contains(T obj) {

		if (this.rootNode == null) {
			return false;
		}

		BinNode<T> node = gen.createBinNode(obj);

		if (this.rootNode != null) {

			BinNode<T> curNode = this.rootNode;
			while (curNode != null) {
				int compareValue = node.compareTo(curNode);
				if (compareValue < 0) {
					if (curNode.hasLeftNode()) {
						curNode = curNode.getLeftNode();
					} else {
						return false;
					}
				} else if (compareValue > 0) {
					if (curNode.hasRightNode()) {
						curNode = curNode.getRightNode();
					} else {
						return false;
					}
				} else {
					return true;
				}
			}
		}

		return false;
	}

	private T findMin(BinNode<T> node) {

		BinNode<T> curNode = node;
		while (curNode != null) {
			if (curNode.hasLeftNode()) {
				curNode = curNode.getLeftNode();
			} else {
				break;
			}
		}
		return curNode.getData();
	}

	private T findMax(BinNode<T> node) {

		BinNode<T> curNode = node;
		while (curNode != null) {
			if (curNode.hasRightNode()) {
				curNode = curNode.getRightNode();
			} else {
				break;
			}
		}
		return curNode.getData();

	}

	public T findMin() {
		return findMin(this.rootNode);
	}

	public T findMax() {
		return findMax(this.rootNode);
	}

	public void insert(T obj) {
		putNode(obj);
	}

	public void insert(T[] objs) {
		putNode(objs);
	}

	public boolean remove(T obj) {

		return remove(this.rootNode, obj);
	}

	private boolean remove(BinNode<T> node, T obj) {

		BinNode<T> nodeForSearch = gen.createBinNode(obj);
		BinNode<T> curNode = node;

		while (curNode != null) {

			int compareValue = nodeForSearch.compareTo(curNode);
			if (compareValue < 0) {
				curNode = curNode.getLeftNode();
			} else if (compareValue > 0) {
				curNode = curNode.getRightNode();
			} else {
				if ((curNode.hasLeftNode()) && (curNode.hasRightNode())) {

					BinNode<T> deleteNode = curNode;

				} else {
					curNode = (curNode.hasLeftNode()) ? curNode.getLeftNode()
							: curNode.getRightNode();
				}
			}
		}
		return false;

	}

	private void putNode(T[] objs) {
		for (T obj : objs) {

			this.putNode(obj);

		}
	}

	public BinNode<T> getTree() {
		return this.rootNode;
	}
}
