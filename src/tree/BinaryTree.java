package tree;

import java.util.ArrayList;

public class BinaryTree {
    static int num = 15;
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) {
        list.add(new Node(0));
        Node root = null;

        for (int i = 1; i <= num; i++) {
            list.add(new Node(i));
        }

        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0) {
                list.get(i/2).left = list.get(i);
            } else {
                list.get(i/2).right = list.get(i);
            }
        }

        root = list.get(1);
        preorder(root);
        System.out.println();

        inorder(root);
        System.out.println();

        postorder(root);
        System.out.println();

    }

    static void preorder(Node root) {
        System.out.print(root.root + " ");
        if (root.left != null) preorder(root.left);
        if (root.right != null) preorder(root.right);
    }

    static void inorder(Node root) {
        if (root.left != null) inorder(root.left);
        System.out.print(root.root + " ");
        if (root.right != null) inorder(root.right);
    }

    static void postorder(Node root) {
        if (root.left != null) postorder(root.left);
        if (root.right != null) postorder(root.right);
        System.out.print(root.root + " ");
    }
}

class Node {
    Node left;
    Node right;
    int root;

    public Node(int root) {
        this.root = root;
    }
}
