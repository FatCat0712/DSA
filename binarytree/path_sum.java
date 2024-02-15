package binarytree;

public class path_sum {
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    public boolean duyet(TreeNode root, int currentSum, int targetSum){
        if(root == null){
            return false;
        }
        currentSum += root.value;
        if(isLeaf(root)){
            if(currentSum == targetSum){
                return true;
            }
        }
        boolean duyetBenTrai = duyet(root.left,currentSum,targetSum);
        boolean duyenBenPhai = duyet(root.right,currentSum,targetSum);

        return duyetBenTrai || duyenBenPhai;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return duyet(root,0,targetSum);
    }

}
