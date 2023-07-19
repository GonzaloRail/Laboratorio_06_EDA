package avanceFinalAndreDelgado;
public class Main {
    public static void main(String[] args) {
        Trie<String> trie = new Trie<>();

        // Insertar palabras en el Trie
        trie.insert("manzana");
        trie.insert("banana");
        trie.insert("gato");

        // Realizar búsquedas en el Trie
        System.out.println(trie.search("manzana")); // Debería imprimir: true
        System.out.println(trie.search("banana")); // Debería imprimir: true
        System.out.println(trie.search("perro")); // Debería imprimir: false
    }
}
