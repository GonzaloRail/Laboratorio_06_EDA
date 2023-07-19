package avanceFinalAndreDelgado;
class Trie<T> {
    private Node<T> root;

    public Trie() {
        this.root = new Node<>(null); // Se crea el nodo raíz del Trie sin valor asociado
    }

    // Método para insertar una palabra en el Trie
    public void insert(String word) {
        Node<T> currentNode = root; // Se comienza desde el nodo raíz

        // Se recorre cada carácter de la palabra
        for (char character : word.toCharArray()) {
            T data = (T) Character.valueOf(character); // Se convierte el carácter en el tipo genérico T
            Node<T> child = findChild(currentNode, data); // Se busca un hijo con el carácter actual

            if (child == null) {
                child = new Node<>(data); // Si no existe un hijo con el carácter, se crea uno nuevo
                currentNode.addChild(child); // Se agrega el nuevo hijo al nodo actual
            }

            currentNode = child; // Se actualiza el nodo actual al hijo correspondiente
        }
    }

    // Método para buscar una palabra en el Trie
    public boolean search(String word) {
        Node<T> currentNode = root; // Se comienza desde el nodo raíz

        // Se recorre cada carácter de la palabra
        for (char character : word.toCharArray()) {
            T data = (T) Character.valueOf(character); // Se convierte el carácter en el tipo genérico T
            Node<T> child = findChild(currentNode, data); // Se busca un hijo con el carácter actual

            if (child == null) {
                return false; // Si no se encuentra un hijo con el carácter, la palabra no está en el Trie
            }

            currentNode = child; // Se actualiza el nodo actual al hijo correspondiente
        }

        return true; // Se encontraron todos los caracteres, la palabra está en el Trie
    }

    // Método auxiliar para buscar un hijo con un valor específico en un nodo
    private Node<T> findChild(Node<T> node, T data) {
        for (Node<T> child : node.getChildren()) {
            if (child.getData().equals(data)) {
                return child; // Se encontró un hijo con el valor específico
            }
        }

        return null; // No se encontró un hijo con el valor específico
    }
}