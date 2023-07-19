import java.util.*;
 
// Clase para almacenar un nodo Trie
class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    private boolean isEndOfWord;
    private List<TrieNode> children = null;
 
    // Constructor
    TrieNode() {
        isEndOfWord = false;
        children = new ArrayList<>(Collections.nCopies(ALPHABET_SIZE, null));
    }
 
    // Método iterativo para insertar una cadena en un Trie
    public void insert(String word) {
        System.out.println("Inserting \"" + word + "\"");
        TrieNode current = this;
 
        // Recorre cada carácter de la palabra
        for (char c : word.toCharArray()) {
            int index = c - 'a';
 
            // Crea un nuevo nodo Trie si la ruta no existe
            if (current.children.get(index) == null) {
                current.children.set(index, new TrieNode());
            }
 
            // Ir al siguiente nodo
            current = current.children.get(index);
        }
 
        // Marcar el nodo actual como una hoja
        current.isEndOfWord = true;
    }
 
    // Método iterativo para buscar una palabra en un Trie.
    // Retorna verdadero si la palabra se encuentra en el Trie; de lo contrario, retorna falso
    public boolean search(String word) {
        System.out.print("Searching \"" + word + "\" : ");
        TrieNode current = this;
 
        // Recorre cada carácter de la palabra
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            current = current.children.get(index);
 
            // Si la cadena no es válida (llegó al final de una ruta en el Trie)
            if (current == null) {
                return false;
            }
        }
 
        // Retorna verdadero si el nodo actual es un nodo hoja y se llega al final de la palabra
        return current.isEndOfWord;
    }
}
 
public class Main {
    public static void main(String[] args) {
        // Construye un nuevo Trie
        TrieNode trie = new TrieNode();
 
        trie.insert("java");
        trie.insert("javascript");
        trie.insert("python");
 
        System.out.println(trie.search("java"));         // true
        System.out.println(trie.search("javascript"));   // true
        System.out.println(trie.search("python"));       // true
        System.out.println(trie.search("c"));          // false
 
        trie.insert("c");
 
        System.out.println(trie.search("java"));         // true
        System.out.println(trie.search("javascript"));   // true
        System.out.println(trie.search("python"));       // true
        System.out.println(trie.search("c"));          // true
    }
}
