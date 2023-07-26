import java.util.*;
public class Trie {
    private TrieNode root;
    private LinkedList<String> content;

    public Trie() {
        root = new TrieNode(); //root is empty
        content = new LinkedList<>();
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26]; // storing english words - a -> z    	
            isWord = false;
        }
    }

    private int getIndex(char c) {
        return c - 'a'; 
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
        	throw new IllegalArgumentException("Invalid input");
        }

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = getIndex(c);
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = getIndex(c);
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isWord;
    }

    public void replace(String word, String replacement) {
        if (word == null || word.isEmpty() || replacement == null) {
        	throw new IllegalArgumentException("Invalid input");
        }
        
        if(word.equals(replacement)) {
        	throw new IllegalArgumentException("Same words");
        }
        
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).equals(word)) {
                content.set(i, replacement);
            }
        }
        
        delete(word); //eliminar del trie
        insert(replacement); //agregar al trie
    }

    public void delete(String word) {
        if (word == null || word.isEmpty()) {
        	throw new IllegalArgumentException("Invalid input");
        }

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = getIndex(c);
            if (current.children[index] == null) {
            	throw new NoSuchElementException("Word not found in the Trie");
            }
            current = current.children[index];
        }
        current.isWord = false;
    }
    
    public String getContent() {
        StringBuilder contentGlobal = new StringBuilder();
        for (String word : content) {
            contentGlobal.append(word).append(" ");
        }
        return contentGlobal.toString();
    }

    public void insertList(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (String word : words) {
            insert(word);
            content.add(word);
        }
    }

    public void clear() {
        root = new TrieNode();
        content.clear();
    }

    
}

