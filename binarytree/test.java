package binarytree;

public class test {
    public static void main(String[] args) {
//        MyBinaryTree myTree = new MyBinaryTree();
//        myTree.init();
          MyBST myTree = new MyBST();
          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,5);
          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,1);
          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,6);
          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,0);
          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,3);
          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,7);
          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,2);
          myTree.mRoot = myTree.insertIntoBST(myTree.mRoot,4);

            myTree.deleteNode(myTree.mRoot,1);
        System.out.println("DONE");
    }
}
