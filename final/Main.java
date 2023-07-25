import java.util.*;
 
public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insertar palabras en el Trie
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");
        trie.insert("app");

        // Buscar palabras en el Trie
        System.out.println("Search 'apple': " + trie.search("apple")); // Debe imprimir true
        System.out.println("Search 'app': " + trie.search("app")); // Debe imprimir true
        System.out.println("Search 'orange': " + trie.search("orange")); // Debe imprimir true
        System.out.println("Search 'grape': " + trie.search("grape")); // Debe imprimir false

        // Eliminar palabras del Trie
        trie.delete("apple");
        System.out.println("Search 'apple' after delete: " + trie.search("apple")); // Debe imprimir false

        trie.delete("app");
        System.out.println("Search 'app' after delete: " + trie.search("app")); // Debe imprimir false
    }
}