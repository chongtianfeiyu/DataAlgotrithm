package com.azalea.common;

/**
 * @author i-xiepenggang
 * 
 * @param <T>
 */
public class BinNode<T extends Comparable> implements Comparable<BinNode<T>> {

	private T data;

	private BinNode<T> leftNode = null;
	private BinNode<T> rightNode = null;
	private BinNode<T> parrentNode = null;

	public boolean hasLeftNode() {
		return leftNode != null;
	}

	public boolean hasRightNode() {
		return rightNode != null;
	}

	public boolean hasParrentNode() {
		return parrentNode != null;
	}

	public BinNode<T> getParrentNode() {
		return parrentNode;
	}

	public void setParrentNode(BinNode<T> parrentNode) {
		this.parrentNode = parrentNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinNode(T data) {
		super();
		this.data = data;
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

	@Override
	public String toString() {
		return "[" + this.data + "]";
	}

	@Override
	public int compareTo(BinNode node) {
		// TODO Auto-generated method stub
		return this.data.compareTo(node.data);
	}
}
