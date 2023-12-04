package Lap10_Tree;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(25);
		bst.add(15);
		bst.add(10);
		bst.add(4);
		bst.add(12);
		bst.add(22);
		bst.add(18);
		bst.add(24);
		bst.add(50);
		bst.add(35);
		bst.add(31);
		bst.add(44);
		bst.add(70);
		bst.add(66);
		bst.add(90);
		
		System.out.println();
		//In độ sâu của một nút
		int depth = bst.depth(4);
		System.out.println(depth);
		
		//Thêm một tập hợp các ptu vào BST
		bst.add(Arrays.asList(1,2,3));
		depth = bst.depth(3);
		System.out.println(depth);
		
		//test height
		int height = bst.height();
		System.out.println(height);
		
		//Test size
		int size = bst.size();
		System.out.println(size);
		
		//Test contains
		boolean c = bst.contains(100);
		System.out.println(c);
		
		//Test findMin
		Integer min = bst.findMin();
		System.out.println(min);
		
		//Test findMax
		Integer max = bst.findMax();
		System.out.println(max);
		
		//Test remove
		boolean r = bst.remove(4);
		System.out.println(r);
		
		//Test descendants
		Integer node = 15;
		System.out.println(node +": "+ bst.descendants(node));
		
		//Test ancestors
		Integer node2 = 4;
        System.out.println(node2 + ": " + bst.ancestors(node2));
        
        System.out.println("Inorder traversal:");
        bst.inorder();  // Output: 1 3 4 5 6 7 8

        System.out.println("\nPreorder traversal:");
        bst.postorder();  // Output: 5 3 1 4 7 6 8
	}

}
