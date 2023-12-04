package Lap10_Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BST <E> root; 
	private E data;
	private BST<E> left;
	private BST<E> right;
	
	public BST(E data) {
	this.data = data;
	this.left = null;
	this.right = null;
	}
	public BST(E data, BST<E> left, BST<E> right) {
	this.data = data;
	this.left = left;
	this.right = right;
	}
//public class BST<E extends Comparable<E>>{
private Comparable<E> node;
public BST() {
	this.root = null;
}
//Add element e into BST
public void add(E e) {
root = addRecursive(root, e);
}
private BST<E> addRecursive(BST<E> root2, E e) {
	if (root2 == null) {
		return new BST<>(e);
	}
	if (e.compareTo(root2.data) < 0) {
		root2.left = addRecursive(root2.left, e);
	}
	else if(e.compareTo(root2.data) > 0) {
		root2.right = addRecursive(root2.right, e);
	}
	return root2;
}
//Add a collection of elements col into BST
public void add(Collection<E> col) {
for (E e : col) {
	add(e);
}
}
//compute the depth of a node in BST
public int depth(E node) {
return depthRecursive(root, node, 0);
}
private int depthRecursive(BST<E> root2, E node, int i) {
	if (root2 == null) {
		return -1;
	}
	if (root2.data.equals(node)) {
		return i;
	}
	int leftDepth = depthRecursive(root2.left, node, i + 1);
	int rightDepth = depthRecursive(root2.right, node, i + 1);
	
	if (leftDepth == -1 && rightDepth == -1) {
		return -1;
	}else if(leftDepth == -1) {
		return rightDepth;
	}else {
	return leftDepth;
	}
}
//compute the height of BST
public int height() {
//TODO
return heightRecursive(root);
}
private int heightRecursive(BST<E> root2) {
	if (root2 == null) {
		return -1;
	}
	int leftHeight = heightRecursive(root2.left);
	int rightHeight = heightRecursive(root2.right);
	return Math.max(leftHeight, rightHeight) + 1;
}
//Compute total nodes in BST
public int size() {
//TODO
return sizeRecursive(root);
}
private int sizeRecursive(BST<E> root2) {
	if (root2 == null) {
		return 0;
	}
	int leftHeight = heightRecursive(root2.left);
	int rightHeight = heightRecursive(root2.right);
	return leftHeight + rightHeight + 1;
}
//Check whether element e is in BST
public boolean contains(E e) {
return containsRecursive(root, e) != null;
}
private BST<E> containsRecursive(BST<E> current, E e) {
    if (current == null) {
        return current;
    }
    if (e.compareTo(current.data) < 0) {
        return containsRecursive(current.left, e);
    } else {
        return containsRecursive(current.right, e);
    }
}
//Find the minimum element in BST
public E findMin() {
if (root == null) {
	return null;
}
BST<E> root2 = root;
while (root2.left != null) {
	root2 = root2.left;
}
return root2.data;
}
//Find the maximum element in BST
public E findMax() {
if (root == null) {
	return null;
}
BST<E> root2 = root;
while (root2.right != null) {
	root2 = root2.right;
}
return root2.data;
}
//Remove element e from BST
public boolean remove(E e) {
if (root == null) {
	return false;
}
	root = removeRecursive(root, e);
	return true;
}
private BST<E> removeRecursive(BST<E> root2, E e) {
	if (root2 == null) {
		return null;
	}
	int compareResult = e.compareTo(root2.data);
	if (compareResult < 0) {
		root2.left = removeRecursive(root2.left, e);
	}else if (compareResult > 0) {
		root2.right = removeRecursive(root2.right, e);
	}else {
		//ptu đc tìm thấy -> xóa
		if (root2.left == null && root2.right == null) {
			//Th1: nút ko có con trái và ko có con phải
			return null;
		}else if (root2.left == null) {
			//Th2: -nút chỉ có con phải 
			return root2.right;
		}else if (root2.right == null) {
			// - nút chỉ có con trái
			return root2.left;
		}else {
			//Th3: nút có cả con trái và phải
			//Tìm ptu nhỏ nhất tr cây con bên phải
			BST<E> s = findMinNode(root2.right);
			root2.data = s.data;
			root2.right = removeRecursive(root2.right, s.data);
		}
	}
	return root2;

}
private BST<E> findMinNode(BST<E> right) {
	while (right.left != null) {
		right = right.left;
	}
	return right;
}
//get the descendants of a node
public List<E> descendants(E data) {
		int comp = node.compareTo(data);
		List<E> list = new ArrayList<E>();

		if (comp == 0) {
			if (left != null) {
				list.add(left.data);
				descendants(left.data);
				list.addAll(left.descendants(left.data));
			}

			if (right != null) {
				list.add(right.data);
				descendants(right.data);
				list.addAll(right.descendants(right.data));
			}
		} else if (comp > 0) {
			if (right != null) {
				right.descendants(right.data);
				list.addAll(right.descendants(right.data));
			}
		} else {
			if (left != null) {
				left.descendants(left.data);
				list.addAll(left.descendants(left.data));
			}
		}
		return list;
	}
	
//get the ancestors of a node
public List<E> ancestors(E data) {
List<E> list = new ArrayList<>();
findAncestors (root, data, list);
return list;
}
private boolean findAncestors(BST<E> root2, E data, List<E> list) {
	if (root2 == null) {
		return false;
	}
	if (root2.data.equals(data)) {
		return true;
	}
	if (findAncestors(root2.left, data, list) || findAncestors(root2.right, data, list)) {
		list.add(root2.data);
		return true;
	}
	return false;

}
//Task2
//display BST using inorder approach
public void inorder() {
    inorderTraversal(root);
}

private void inorderTraversal(BST<E> root2) {
	if (root2 != null) {
        inorderTraversal(root2.left);
        System.out.print(root2.data + " ");
        inorderTraversal(root2.right);
}
}

//display BST using preorder approach
public void postorder() {
	preorderTraversal(root);
	}
private void preorderTraversal(BST<E> root2) {
	if (root2 != null) {
        System.out.print(root2.data + " ");
        preorderTraversal(root2.left);
        preorderTraversal(root2.right);
	
	}
}
}
