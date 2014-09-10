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

	private BinNode<T> find(T obj) {

		return null;
	}

	private BinNode<T> findMin(BinNode<T> node) {

		BinNode<T> curNode = node;
		while (curNode != null) {
			if (curNode.hasLeftNode()) {
				curNode = curNode.getLeftNode();
			} else {
				break;
			}
		}
		return curNode;
	}

	private BinNode<T> findMax(BinNode<T> node) {

		BinNode<T> curNode = node;
		while (curNode != null) {
			if (curNode.hasRightNode()) {
				curNode = curNode.getRightNode();
			} else {
				break;
			}
		}
		return curNode;

	}

	public T findMin() {
		return findMin(this.rootNode).getData();
	}

	public T findMax() {
		return findMax(this.rootNode).getData();
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
		BinNode<T> deleteNode = node;

		while (deleteNode != null) {
			int compareValue = nodeForSearch.compareTo(deleteNode);
			if (compareValue < 0) {
				deleteNode = deleteNode.getLeftNode();
			} else if (compareValue > 0) {
				deleteNode = deleteNode.getRightNode();
			} else {
				if ((deleteNode.hasLeftNode()) && (deleteNode.hasRightNode())) {
					
					BinNode<T> replaceNode = findMin(deleteNode.getRightNode());
					
					if (replaceNode.getParrentNode() == deleteNode) {
						
						transPlant(deleteNode, replaceNode);
						replaceNode.setLeftNode(deleteNode.getLeftNode());
						replaceNode.getLeftNode().setParrentNode(replaceNode);
						
					} else {
						transPlant(replaceNode, replaceNode.getRightNode());
						replaceNode.setRightNode(deleteNode.getRightNode());
						replaceNode.getRightNode().setParrentNode(replaceNode);
					}

					// curNode = replaceNode;
					// replaceNode = replaceNode.getRightNode();

				} else if (deleteNode.hasLeftNode()) {
					transPlant(deleteNode, deleteNode.getLeftNode());
				} else {
					transPlant(deleteNode, deleteNode.getRightNode());
				}

				return true;
			}
		}
		return false;
	}

	private void transPlant(BinNode<T> deleteNode, BinNode<T> replaceNode) {
		// if it is not the root node
		if (deleteNode.hasParrentNode()) {
			if (deleteNode.getParrentNode().getLeftNode() == deleteNode) {

				deleteNode.getParrentNode().setLeftNode(replaceNode);
			} else {
				deleteNode.getParrentNode().setRightNode(replaceNode);
			}
		}
		// if it is the root node
		else {
			this.rootNode = replaceNode;
		}
		replaceNode.setParrentNode(deleteNode.getParrentNode());

		deleteNode = null;
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
