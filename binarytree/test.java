package binarytree;

public class test {
    public static void main(String[] args) {
//        MyBinaryTree myTree = new MyBinaryTree();
//        myTree.init();
//            MyBST myTree = new MyBST();
//          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,5);
//          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,1);
//          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,6);
//          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,0);
//          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,3);
//          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,7);
//          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,2);
//          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,4);
        //myTree.deleteNode(myTree.mRoot,1);

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n0.left = n1; n0.right = n2;
        n1.left = n3; n1.right = n4;
        n2.right = n5;
        n4.left = n6; n4.right = n7;

        //MyBST.preOrder(n0);
        //MyBST.inOrder(n0);
        MyBST.postOrder(n0);
        System.out.println("DONE");
    }
}
