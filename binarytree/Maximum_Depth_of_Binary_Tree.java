package binarytree;

public class Maximum_Depth_of_Binary_Tree {
    //maxDepth(root) => Đi tìm chiều cao của cây
    public static int maxDepth(TreeNode root){
        //B1 : Điều kiện dừng | Bài toán cơ sở
        if(root == null)
            return 0;
        //B2 : công thức đệ quy
        int chieuCaoCayBenTrai = maxDepth(root.left);
        int chieuCaoCayBenPhai = maxDepth(root.right);
        int result = Math.max(chieuCaoCayBenPhai,chieuCaoCayBenTrai) + 1;
        return result;
    }

    public static void main(String[] args) {

    }
}
