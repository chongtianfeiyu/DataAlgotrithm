package com.azalea.common;

public class BinNode<T extends Comparable> {

	private T node;

	private BinNode<T> leftNode;
	private BinNode<T> rightNode;

	public BinNode(T node) {
		this.node = node;
	}

	public T getData() {
		return node;
	}

	public boolean hasLeftNode() {
		return leftNode != null;
	}

	public boolean hasRightNode() {
		return rightNode != null;
	}

	public T getNode() {
		return node;
	}

	public void setNode(T node) {
		this.node = node;
	}

	public BinNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public BinNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinNode<T> rightNode) {
		this.rightNode = rightNode;
	}

}
