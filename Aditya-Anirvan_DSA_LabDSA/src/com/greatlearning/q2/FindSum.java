package com.greatlearning.q2;
import java.util.*;
public class FindSum {
	
	private static node insertnode(node root,int i) {
		if(root==null) {
			return new node(i);
		}
		if(i<root.key) {
			root.left = insertnode(root.left,i);
		}
		else {
			root.right = insertnode(root.right,i);
		}
		return root;
	}
	public static void main(String[] args) {
		node root = null;
		root = insertnode(root, 40);
		root = insertnode(root, 20);
		root = insertnode(root, 60);
		root = insertnode(root, 10);
		root = insertnode(root, 30);
		root = insertnode(root, 50);
		root = insertnode(root, 70);
		int sum = 50;
		boolean result = findSumPair(root,sum);
		if(!result)System.out.println("no such pair exists");
		
	}
	private static boolean findSumPair(node root, int sum) {
		HashSet<Integer> data = new HashSet<Integer>();
		return pairExists(root,data,sum);
	}
	private static boolean pairExists(node root, HashSet<Integer> data, int sum) {
		if(root==null) {
		return false;
	}
		int comp = sum - root.key;
		
		if(data.contains(comp)) {
			System.out.println("Sum pair exists for sum " + sum + ": (" + root.key + ',' + comp +')' );
			return true;
		}
		else {
			data.add(root.key);
		}
      return (pairExists(root.left,data,sum)||pairExists(root.right,data,sum));
	}
}
