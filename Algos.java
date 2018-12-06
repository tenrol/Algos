// In-order
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList();
        inorder(root, inorderList);
        return inorderList;
    }
    private void inorder(TreeNode t, List<Integer> l){
        if(t == null) return;
        inorder(t.left, l);
        l.add(t.val);
        inorder(t.right, l);
    }
}
/*
Time complexity : 
O(n). The time complexity is O(n) because the recursive function is T(n) = 2 \cdot T(n/2)+1T(n)=2⋅T(n/2)+1.
Space complexity : 
The worst case space required is O(n), and in the average case it's O(log(n)) where nn is number of nodes.
*/


// Unique BST
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private List<TreeNode> generateTree(int start, int end) {
        
        List<TreeNode> allTrees = new ArrayList<TreeNode>();
        
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        
        for(int i = start; i <= end; i++) {
            
            List<TreeNode> leftTrees = generateTree(start, i - 1);
            List<TreeNode> rightTrees = generateTree(i + 1, end);
            
            for(TreeNode l : leftTrees) {
                for(TreeNode r : rightTrees) {
                    
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    }
    
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        return generateTree(1, n);
    }
}