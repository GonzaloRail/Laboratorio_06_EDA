import java.util.*;
public class Trie {

    private TrieNode root;

    public Trie() {
	root = new TrieNode(); // root is empty 
    }

    class TrieNode {
	TrieNode[] children;
	boolean isWord;

	public TrieNode() {
	    this.children = new TrieNode[26]; // storing english words - a -> z    	    
	    this.isWord = false;
	}
    }

	public void insert(String word) {
	    if (word == null || word.isEmpty()) {
	        throw new IllegalArgumentException("Invalid input");
	    }

	    word = word.toLowerCase();

	    TrieNode current = root;
	    for (int i = 0; i < word.length(); i++) {
	        char c = word.charAt(i);
	        int index = c - 'a';
	        if (current.children[index] == null) {
                    TrieNode node = new TrieNode();
	            current.children[index] = node;
	            current = node;
	        } else {
	            current = current.children[index];
	        }
	    }
	    current.isWord = true;

	}

	public boolean search(String word) {
	    if (word == null || word.isEmpty()) {
	        return false;
	    }

	    word = word.toLowerCase();

	    TrieNode current = root;
	    for (int i = 0; i < word.length(); i++) {
	        char c = word.charAt(i);
	        int index = c - 'a';
	        if (current.children[index] == null) {
                    return false;
	        }
	        current = current.children[index];
	    }

	    return current.isWord;
	}

	public void delete(String word) {
            if (word == null || word.isEmpty()) {
                throw new IllegalArgumentException("Invalid input");
            }

            word = word.toLowerCase();

            if (!search(word)) {
                throw new NoSuchElementException("Word not found in the Trie");
            }

            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (current.children[index] == null) {
                    throw new NoSuchElementException("Word not found in the Trie");
                }
                current = current.children[index];
            }

            current.isWord = false;
        }

        public void replace(String wordToReplace, String replacementWord) {
            if (wordToReplace == null || wordToReplace.isEmpty() || replacementWord == null || replacementWord.isEmpty()) {
                throw new IllegalArgumentException("Invalid input");
            }

            wordToReplace = wordToReplace.toLowerCase();
            replacementWord = replacementWord.toLowerCase();

            delete(wordToReplace);
            insert(replacementWord);
    }
}