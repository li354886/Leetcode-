/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    ArrayList<TreeNode> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<TreeNode>();
        iterator(root, list);
        
        index = 0;
    }
    
    public void iterator (TreeNode root, ArrayList<TreeNode> ret) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            
            if (s.isEmpty()) {
                break;
            }
            
            cur = s.pop();
            
            ret.add(cur);
            cur = cur.right;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        }
        
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++).val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */