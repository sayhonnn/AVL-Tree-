package treetest;

public class Tree {

    protected TreeNode root;

    // Construct an empty Tree of integers
    public Tree() {
        root = null;
    }

//     Insert a new node in the binary search tree.
//     If the root node is null, create the root node here.
//     Otherwise, call the insert method of class TreeNode.
    public synchronized void insertNode(Integer d) {
        if (root == null) {
            root = new TreeNode(d);

        } else {
            root.insert(d);
        }

    }

    // Preorder Traversal
    public synchronized int preorderTraversal(TreeNode node) {
        int count = 0;
        count += preorderHelper(node);
        return count;
    }

    // Recursive method to perform preorder traversal
    private synchronized int preorderHelper(TreeNode node) {
        int count = 0;
        if (node == null) {
            return count;
        }
        count++;
        System.out.print(node.data + " ");

        count += preorderHelper(node.left);
        count += preorderHelper(node.right);
        return count;
    }

    // Inorder Traversal
    public synchronized int inorderTraversal(TreeNode node) {
        int count = 0;
        count += inorderHelper(node);
        return count;
    }

    // Recursive method to perform inorder traversal
    private synchronized int inorderHelper(TreeNode node) {
        int count = 0;
        if (node == null) {
            return count;
        }
        count++;
        inorderHelper(node.left);
        System.out.print(node.data + " ");
        inorderHelper(node.right);
        return count;
    }

    // Postorder Traversal
    public synchronized int postorderTraversal(TreeNode node) {
        int count = 0;
        count += postorderHelper(node);
        return count;
    }

    // Recursive method to perform postorder traversal
    private synchronized int postorderHelper(TreeNode node) {
        int count = 0;
        if (node == null) {
            return count;
        }

        count++;
        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.print(node.data + " ");
        return count;
    }

    public synchronized void inorderPrintLeaves() {
        inorderPrintLeavesHelper(root);
    }

    private synchronized void inorderPrintLeavesHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            if (node.getRight() == null) {
                //its a leaf
                System.out.print(node.data);
                System.out.print(" ");
            }
        }

        inorderPrintLeavesHelper(node.left);
        inorderPrintLeavesHelper(node.right);

    }

    public synchronized void inorderPrintNonLeaves() {
        inorderPrintNonLeavesHelper(root);
    }

    // Recursive method to perform in order traversal
    private synchronized void inorderPrintNonLeavesHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        //must have at least one child.
        if (node.getLeft() != null || node.getRight() != null) {
            System.out.print(node.data);
            System.out.print(" ");
        }

        inorderPrintNonLeavesHelper(node.left);
        inorderPrintNonLeavesHelper(node.right);
    }

    public TreeNode searchNode(int key) {
        TreeNode temp = this.root;
        while (temp != null && !temp.getData().equals(key)) {
            if (key <= (int) temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return temp;
    }

    public int findDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = 0;
        int maxRight = 0;
        maxLeft += findDepth(node.left);
        maxRight += findDepth(node.right);

        int depth = Math.max(maxLeft, maxRight) + 1;

        return depth;
    }

    public void printNumberOfNodes(int key) {
        TreeNode node = searchNode(key);
        if (node == null) {
            System.out.println("Error: Node <" + key + "> not found!");
        } else {
            System.out.println("Number of Nodes in the subtree starting from " + node.getData() + " is: " + TreeNode.countNodes(node));
        }
    }

    private TreeNode helpFindSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private TreeNode helpFindPredecessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    public TreeNode getSuccessor(int key) {
        TreeNode node = searchNode(key);
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return helpFindSuccessor(node.getRight());
        }
        TreeNode successorNode = (TreeNode) node.getData();
        while (successorNode != null && successorNode.getLeft() != node) {
            node = successorNode;
            successorNode = (TreeNode) successorNode.getData();
        }
        return successorNode;
    }

    public TreeNode getPredecessor(int key) {
        TreeNode node = searchNode(key);
        if (node == null) {
            return null;
        }
        if (node.getLeft() != null) {
            return helpFindPredecessor(node.getLeft());
        }
        TreeNode predecessorNode = (TreeNode) node.getData();
        while (predecessorNode != null && node != predecessorNode.getRight()) {
            node = predecessorNode;
            predecessorNode = (TreeNode) predecessorNode.getData();
        }
        return predecessorNode;
    }

    public void delete(Integer data) {

        deleteNode(this.root, data);
    }

    private TreeNode deleteNode(TreeNode root, Integer data) {

        if (root == null) {
            return root;
        }

        if (data < root.getKey()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if (data > root.getKey()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            // node with no leaf nodes
            if (root.getLeft() == null && root.getRight() == null) {
                System.out.println("deleting " + data);
                return null;
            } else if (root.getLeft() == null) {
                // node with one node (no left node)
                System.out.println("deleting " + data);
                return root.getRight();
            } else if (root.getRight() == null) {
                // node with one node (no right node)
                System.out.println("deleting " + data);
                return root.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Integer minValue = minValue(root.getRight());
                root.setKey(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
                System.out.println("deleting " + data);
            }
        }

        return root;
    }

    private Integer minValue(TreeNode node) {

        if (node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return (Integer) node.getData();
    }

}
