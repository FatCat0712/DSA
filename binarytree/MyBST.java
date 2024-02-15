package binarytree;

public class MyBST {
    public TreeNode mRoot;

    public MyBST(){

    }


    // insert Node sử dụng vòng lặp
    public TreeNode insert(TreeNode root, int value){
        TreeNode newNode = new TreeNode(value);
        if(root == null){
            root = newNode;
            return root;
        }
        else{
            TreeNode temp = root;
            while(true){
                if(value > temp.value){
                    if(temp.right == null){
                        temp.right = newNode;
                        break;
                    }
                    else{
                        temp = temp.right;
                    }
                }
                else{
                    // value nhỏ hơn
                    if(temp.left == null){
                       temp.left = newNode;
                       break;
                    }
                    else{
                        temp = temp.left;
                    }
                }
            }
            return root;
        }
    }

    // Insert Node sử dụng đệ quy
    public TreeNode insertIntoBST(TreeNode rootNode, int value){
        TreeNode newNode = new TreeNode(value);
        if(rootNode == null){
            rootNode = newNode;
            return rootNode;
        }
        else{
            if(value < rootNode.value){
                if(rootNode.left == null){
                    rootNode.left = newNode;
                }
                else{
                    insertIntoBST(rootNode.left,value);
                }

            }
            else{
                if(rootNode.right == null){
                    rootNode.right = newNode;
                }
                else{
                    insertIntoBST(rootNode.right, value);
                }

            }

        }
        return rootNode;
    }

    // Tìm node con trái cùng của root
    public TreeNode findLeftMostNode(TreeNode root){
        if(root == null) return null;
        TreeNode leftMostNode = root;
        while (leftMostNode.left != null){
            leftMostNode = leftMostNode.left;
        }
        return leftMostNode;
    }

    //xoa node key trong cay root
    // return : cay moi da duoc xoa node key
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;

            //B1: Đi tìm node xóa
        }
        if(key < root.value){
           root.left = deleteNode(root.left,key);
        }
        else if(key > root.value){
            root.right = deleteNode(root.right,key);
        }
        else{
            //root.val = key => xoa root | xac dinh duoc node xoa
            //B2: xóa node root

            //TH1 = root là node lá:
            if(root.left == null && root.right == null){
                return null;
            }
            //TH2 = chỉ có 1 con bên trái
            if(root.left != null && root.right == null){
                return root.left;
            }
            //TH2 =  chỉ có 1 con bên phải
            if(root.left == null && root.right != null){
                return root.right;
            }

            //TH3: tồn tại 2 con
            // Tìm node con trái cùng của cây con bên phải
            TreeNode leftMostNode = findLeftMostNode(root.right);
            root.value = leftMostNode.value;
            root.right = deleteNode(root.right,leftMostNode.value);
        }
        return root;
    }





}
