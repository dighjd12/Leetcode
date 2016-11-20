Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Thoughts

If you are given an array, the problem is quite straightforward. 
But things get a little more complicated when you have a singly linked list instead of an array. 
Now you no longer have random access to an element in O(1) time. 
Therefore, you need to create nodes bottom-up, and assign them to its parents. 
The bottom-up approach enables us to access the list in its order at the same time as creating nodes.


//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
		next = null;
	}
}
 
// Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
 
	TreeNode(int x) {
		val = x;
	}
}
 
public class Solution {
	static ListNode h;
 
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 
	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode left = sortedListToBST(start, mid - 1);
		//after left is built, the head has proceeded mid times, so h is at mid right now.
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
}