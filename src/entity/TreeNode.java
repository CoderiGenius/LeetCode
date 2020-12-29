package entity;

import java.util.Enumeration;

public class TreeNode implements javax.swing.tree.TreeNode {

      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }





    @Override
    public javax.swing.tree.TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public javax.swing.tree.TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(javax.swing.tree.TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration children() {
        return null;
    }
}
