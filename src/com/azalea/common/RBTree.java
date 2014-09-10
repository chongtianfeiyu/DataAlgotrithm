package com.azalea.common;

public class RBTree<T extends Comparable<?>> {

	private RedBlacknode<T> rootNode = null;

	protected void left_Rotate(RedBlacknode<T> pivot) {
		if (pivot == null) {
			return;
		}
		if (pivot.hasRightNode()) {

			// find the rightnode tmp
			BinNode<T> tmp = pivot.getRightNode();

			// link the tmp's leftnode and pivot
			pivot.setRightNode(tmp.getLeftNode());
			tmp.getLeftNode().setParrentNode(pivot);

			// link the pivot's parrentnode and tmp
			if (pivot.hasParrentNode()) {
				if (pivot.getParrentNode().getLeftNode() == pivot) {
					pivot.getParrentNode().setLeftNode(tmp);
				} else {
					pivot.getParrentNode().setRightNode(tmp);
				}
				tmp.setParrentNode(pivot.getParrentNode());
			} else {
				this.rootNode = (RedBlacknode<T>) tmp;
			}

			// link the pivot and tmp
			tmp.setLeftNode(pivot);
			pivot.setParrentNode(tmp);
		}

	}

	protected void right_Rotate(RedBlacknode<T> pivot) {

		if (pivot == null) {
			return;
		}

		if (pivot.hasLeftNode()) {

			// find the leftnode tmp
			BinNode<T> tmp = pivot.getLeftNode();

			// link the tmp's rightnode to the pivot's left
			pivot.setLeftNode(tmp.getRightNode());
			tmp.getRightNode().setParrentNode(pivot);

			// link the pivot's parrentnode and tmp
			if (pivot.hasParrentNode()) {
				if (pivot.getParrentNode().getLeftNode() == pivot) {
					pivot.getParrentNode().setLeftNode(tmp);
				} else {
					pivot.getParrentNode().setRightNode(tmp);
				}
				tmp.setParrentNode(pivot.getParrentNode());
			} else {
				this.rootNode = (RedBlacknode<T>) tmp;
			}

			// link the pivot and tmp
			tmp.setRightNode(pivot);
			pivot.setParrentNode(tmp);
		}
	}

	public void insert(RedBlacknode<T> node) {

		if (this.rootNode != null) {

			BinNode<T> curNode = this.rootNode;
			BinNode<T> parrentNode = null;

			while (curNode != null) {

				parrentNode = curNode;
				int comparaValue = node.compareTo(curNode);
				if (comparaValue < 0) {
					curNode = curNode.getLeftNode();
				} else if (comparaValue > 0) {
					curNode = curNode.getRightNode();
				} else {
					break;
				}

			}
			// if node exist !!!
			if (curNode != null) {
				return;

			}/* if node doesn't exist ! */else {

				node.setParrentNode(parrentNode);
				int compValue = node.compareTo(parrentNode);

				if (compValue < 0) {
					parrentNode.setLeftNode(node);
				} else {
					parrentNode.setRightNode(node);
				}
			}

		} else {
			this.rootNode = node;
		}
		node.setColor(RedBlacknode.RED);
		insertFixup(node);
	}

	protected void insertFixup(RedBlacknode<T> node) {

		// if the node isn't rootnode
		if (node.hasParrentNode()) {
				
			if(node.getParrentNode().getColor() == BinNode.RED){
				
			}
			
		}/* if the node is rootnode */else {
			node.setColor(RedBlacknode.BLACK);
		}
	}

}
