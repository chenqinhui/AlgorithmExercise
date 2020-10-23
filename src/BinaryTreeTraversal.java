import java.util.Stack;

public class BinaryTreeTraversal {
    public void recursiveInorderTraversal(TreeNode rootNode){
        if(rootNode!=null){
            recursiveInorderTraversal(rootNode.leftNode);
            System.out.println(rootNode.val);
            recursiveInorderTraversal(rootNode.rightNode);
        }
    }

    // 每次循环将当前节点进栈，向左找到最左的节点，如果没有左节点就将栈顶节点出栈，然后栈顶的右儿子作为当前节点
    public void inorderTraversal(TreeNode rootNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = rootNode;
        while(currentNode!=null||!stack.empty()){
            if(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.leftNode;
            }
            else{
                currentNode = stack.pop();
                System.out.println(currentNode.val);
                currentNode = currentNode.rightNode;
            }
        }
    }

    // 每次循环时栈顶节点出栈，然后栈顶节点的右儿子、左儿子依次进栈
    public void preorderTraversal(TreeNode rootNode){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);
        while(!stack.empty()){
            TreeNode current = stack.pop();
            System.out.println(current.val);
            if(current.rightNode!=null)
                stack.push(current.rightNode);
            if(current.leftNode!=null)
                stack.push(current.leftNode);
        }
    }

    public void postorderTraversal(TreeNode rootNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = rootNode;
        TreeNode preNode = null;
        while(!stack.empty()||currentNode!=null){
            while(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.leftNode;
            }

            currentNode = stack.peek(); //访问到最左节点后，取到该节点
            if(currentNode.rightNode==null||currentNode.rightNode==preNode){
                currentNode = stack.pop();
                System.out.println(currentNode.val);
                preNode = currentNode; //pre为了记录根节点的右节点是否被访问
                currentNode = null;

            }
            else{
                currentNode = currentNode.rightNode;
            }
        }
    }
}

class Traversal{
    public static void main(String[] args){
        BinaryTreeTraversal b = new BinaryTreeTraversal();
        TreeNode root = new TreeNode(15);
        root.leftNode = new TreeNode(6);
        root.rightNode = new TreeNode(23);
        TreeNode left = root.leftNode;
        TreeNode right = root.rightNode;
        left.leftNode = new TreeNode(4);
        left.rightNode = new TreeNode(7);
        left = left.leftNode;
        left.leftNode = new TreeNode(2);
        left.rightNode = new TreeNode(5);
        right.leftNode = new TreeNode(19);
        //b.inorderTraversal(root);
        b.postorderTraversal(root);
    }
}
