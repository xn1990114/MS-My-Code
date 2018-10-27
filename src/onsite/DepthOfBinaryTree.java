package onsite;
import java.util.*;
/*
 * 用一个array表示一个二叉树，然后求二叉树最深的depth，很难受，作出来个o(n^2)的，写了代码，然后优化出了o(n)，可惜没时间写代码了。
   比如  [2, 3, 3, -1, 2] 就是，深度是3     
               3
              / \
             2   1
            / \
           4   0
 */
/*
 *  assumption: per description, it seems the num in each array represent the parent node
 *  and no duplicate in the input
 */

public class DepthOfBinaryTree {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val) {
			this.val=val;
		}
	}
	public int findMaxDepth(int[] nums) {
		TreeNode root=reconstructTree(nums);
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.offer(root);
		int depth=0;
		while(!qu.isEmpty()) {
			depth++;
			int size=qu.size();
			for(int round=0;round<size;round++) {
				TreeNode top=qu.poll();
				if(top.left!=null) {
					qu.offer(top.left);
				}
				if(top.right!=null) {
					qu.offer(top.right);
				}
			}
		}
		return depth;
	}
	private TreeNode reconstructTree(int[] nums) {
		TreeNode root=null;
		Map<Integer,TreeNode> map=new HashMap<Integer,TreeNode>();
		for(int i=0;i<nums.length;i++) {
			map.put(i, new TreeNode(i));
		}
		for(int i=0;i<nums.length;i++) {
			int p=nums[i];
			if(p==-1) {
				root=map.get(i);
			}
			else {
				TreeNode pNode=map.get(p);
				TreeNode cNode=map.get(i);
				if(pNode.left==null) {
					pNode.left=cNode;
				}
				else {
					pNode.right=cNode;
				}
			}
		}
		return root;
	}
}
