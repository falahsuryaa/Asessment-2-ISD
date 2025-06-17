import java.util.Scanner;

class Node {
    String kata;
    Node kiri, kanan;

    public Node(String kata) {
        this.kata = kata.toLowerCase();
        kiri = kanan = null;
    }
}

class Kamus {
    private Node root;

    public void tambahKata(String kata) {
        root = insert(root, kata.toLowerCase());
    }

    private Node insert(Node node, String kata) {
        if (node == null) return new Node(kata);
        if (kata.compareTo(node.kata) < 0)
            node.kiri = insert(node.kiri, kata);
        else if (kata.compareTo(node.kata) > 0)
            node.kanan = insert(node.kanan, kata);
        return node; 
    }

    
    public boolean cariKata(String kata) {
        return search(root, kata.toLowerCase());
    }

    private boolean search(Node node, String kata) {
        if (node == null) return false;
        if (kata.equals(node.kata)) return true;
        if (kata.compareTo(node.kata) < 0)
            return search(node.kiri, kata);
        else
            return search(node.kanan, kata);
    }

    public void tampilkanKamus() {
        if (root == null) {
            System.out.println("Kamus kosong.");
        } else {
            System.out.println("Kosakata yang telah disimpan:");
            inorder(root);
        }
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.kiri);
            System.out.println("- " + node.kata);
            inorder(node.kanan);
        }
    }
}

