public class ReconstructBinaryTree {
    public TreeNode reconstruct(int[] pre,
                                int[] in,
                                TreeNode rootNode){
        //通过前序确定根节点
        int root = pre[0];
        rootNode.val = root;

        //找到根节点值在中序中的位置
        int left = 0;
        int right = 0;
        for(int i=0;i<in.length;i++){
            if(in[i]==root){
                left = i;
                right = in.length-i-1;
                break;
            }
        }
//        System.out.println(left);
//        System.out.println(right);

        int[] leftInTree = new int[left];
        int[] rightInTree = new int[right];
        int[] leftPreTree = new int[left];
        int[] rightPreTree = new int[right];
        for(int i=0;i<left;i++){
            leftInTree[i] = in[i];
            leftPreTree[i] = pre[i+1];
        }
        for(int i=0;i<right;i++){
            rightInTree[i] = in[i+left+1];
            rightPreTree[i] = pre[i+left+1];
        }

        if(left!=0) {
            TreeNode leftNode = new TreeNode(pre[1]);
            rootNode.leftNode = leftNode;
            reconstruct(leftPreTree,leftInTree,leftNode);
        }
        if(right!=0){
            TreeNode rightNode = new TreeNode(pre[left]);
            rootNode.rightNode = rightNode;
            reconstruct(rightPreTree,rightInTree,rightNode);
        }
        System.out.println(rootNode.val);
        return rootNode;
    }
}

class M7{
    public static void main(String[] args){
        ReconstructBinaryTree r = new ReconstructBinaryTree();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new TreeNode(pre[0]);
        TreeNode tree = r.reconstruct(pre,in,root);
        System.out.println(tree.val);
    }
}
