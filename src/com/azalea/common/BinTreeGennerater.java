package com.azalea.common;

public class BinTreeGennerater {
	
	public static <T extends Comparable>  BinNode getBinTree(T[] arrObj){
		
		BinNode rootBin = null;
		if(arrObj != null){
			for(T obj:arrObj){
				
			}
		}
		
		return rootBin;
	}
	
	private static <T extends Comparable> BinNode createBinNode(T obj){
		
		BinNode node = new BinNode (obj);
		
		return node;
	}
	
}
