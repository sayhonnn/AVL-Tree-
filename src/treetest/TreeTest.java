package treetest;

import java.util.Scanner;

public class TreeTest {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int count = 0;
        String data = "";

        while (true) {
            System.out.println("\nSelect your option:");
            System.out.println("\n1. Print the pre-order, in-order, and post-order of the BST, in sequence");
            System.out.println("\n2. Print all leaf nodes of the BST, and all non-leaf nodes (separately)");
            System.out.println("\n3. Print the total number of nodes of a sub-tree");
            System.out.println("\n4. Print the depth of a subtree rooted at a particular node");
            System.out.println("\n5. Insert a new integer key into the BST");
            System.out.println("\n6. Delete an integer key from the BST");
            System.out.println("\n7. Exit\n");
            input = sc.nextInt();
            Scanner scanner = new Scanner(System.in);

            if (input == 1) {

                System.out.println("\nPre-order:");
                count += tree.preorderTraversal(tree.root);

                System.out.println("\nIn-order:");
                count += tree.inorderTraversal(tree.root);

                System.out.println("\nPodt-order:");
                count += tree.postorderTraversal(tree.root);

            } else if (input == 2) {

                System.out.println("\n Print leaves");
                tree.inorderPrintLeaves();

                System.out.println("\n Print non-leaves");
                tree.inorderPrintNonLeaves();

            } else if (input == 3) {
                System.out.println("\n\nEnter the integer to seach subroot: ");
                int value = sc.nextInt();
                tree.printNumberOfNodes(value);
            } else if (input == 4) {
                System.out.println("Enter value to search for depth: ");
                int num = sc.nextInt();
                TreeNode node = tree.searchNode(num);

                if (node == null) {
                    System.out.println("Error: Value " + num + " not found!");
                } else {
                    System.out.println("Depth of Tree in the subtree starting from " + node.getData() + " is: " + tree.findDepth(node));
                }

            } else if (input == 5) {
                System.out.println("\nPlease insert the value which you would like to add");
                int value = scanner.nextInt();

                tree.insertNode(value);

            } else if (input == 6) {
                System.out.println("\nPlease insert the value which you would like to delete");
                int value = scanner.nextInt();
                tree.delete(value);

                System.out.println("\n " + value + " deleted from tree.");
            } else if (input == 7) {
                System.exit(0);
            }
            System.out.println("\nEnter another option");
        }

        /*System.out.println(
                "Inserting the following values: ");

        // insert 10 random integers from 0-99 in tree
        for (int i = 0;
                i < 10; i++) {
            value = a[i];
            System.out.print(value + " ");

            tree.insertNode(value);
        }

        // perform preorder traveral of tree
        System.out.println(
                "\n\nPreorder traversal");
        tree.preorderTraversal();

        // perform inorder traveral of tree
        System.out.println(
                "\n\nInorder traversal");
        tree.inorderTraversal();

        // perform postorder traveral of tree
        System.out.println(
                "\n\nPostorder traversal");
        tree.postorderTraversal();

        System.out.println();*/
    }

}
