package avanceFinalAndreDelgado;
public class Main {
    public static void main(String[] args) {
        Trie<String> trie = new Trie<>();

        // Insertar palabras en el Trie
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("cat");

        // Realizar búsquedas en el Trie
        System.out.println(trie.search("apple")); // Debería imprimir: true
        System.out.println(trie.search("banana")); // Debería imprimir: true
        System.out.println(trie.search("dog")); // Debería imprimir: false
    }
}
