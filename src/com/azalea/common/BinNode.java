package com.azalea.common;

public class BinNode<T> {
	private Comparable<T> node;

	private BinNode<T> leftNode;
	private BinNode<T> rightNode;
	
	public Comparable<T> getData(){
		return node;
	}
	
	public boolean hasLeftNode(){
		return leftNode!=null;
	}
	
	public boolean hasRightNode(){
		return rightNode!=null;
	}
}
