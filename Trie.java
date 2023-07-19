import java.util.*;
class Trie<T> {
    private Node<T> root;

    public Trie() {
        this.root = new Node<>(null);
    }

    public void insert(List<T> text) {
        Node<T> currentNode = root;
        for (T letra : text) {
            Node<T> child = findChild(currentNode, letra);
            if (child == null) {
                child = new Node<>(letra);
                currentNode.addChild(child);
            }
            currentNode = child;
        }
    }

    public boolean search(List<T> text) {
        Node<T> currentNode = root;
        for (T letra : text) {
            Node<T> child = findChild(currentNode, letra);
            if (child == null) {
                return false;
            }
            currentNode = child;
        }
        return true;
    }

    private Node<T> findChild(Node<T> node, T character) {
        for (Node<T> child : node.getChildren()) {
            if (child.getData().equals(character)) {
                return child;
            }
        }
        return null;
    }
}