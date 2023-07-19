import java.util.*;

class Trie<T> {
    private Node<T> root;

    public Trie() {
        this.root = new Node<>(null);
    }

    public void insert(String word) {
        Node<T> currentNode = root;
        for (char character : word.toCharArray()) {
            T data = (T) Character.valueOf(character);
            Node<T> child = findChild(currentNode, data);
            if (child == null) {
                child = new Node<>(data);
                currentNode.addChild(child);
            }
            currentNode = child;
        }
    }

    public boolean search(String word) {
        Node<T> currentNode = root;
        for (char character : word.toCharArray()) {
            T data = (T) Character.valueOf(character);
            Node<T> child = findChild(currentNode, data);
            if (child == null) {
                return false;
            }
            currentNode = child;
        }
        return true;
    }

    private Node<T> findChild(Node<T> node, T data) {
        for (Node<T> child : node.getChildren()) {
            if (child.getData().equals(data)) {
                return child;
            }
        }
        return null;
    }
}