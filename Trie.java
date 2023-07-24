public class Trie {

	   private TrieNode root;

	   public Trie() {
	      root = new TrieNode(); // root is empty 
	   }

	   private class TrieNode {
	      private TrieNode[] children;
	      private boolean isWord;

	      public TrieNode() {
	         this.children = new TrieNode[26]; // storing english words - a -> z    	    this.isWord = false;
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
	         return;
	      }

	      word = word.toLowerCase();

	      delete(root, word, 0);
	   }

	   private boolean delete(TrieNode current, String word, int index) {
	      if (index == word.length()) {
	         if (!current.isWord) {
	            return false; // The word doesn't exist in the Trie
	         }
	         current.isWord = false;
	         // Return true if the current node has no other children (can be deleted)
	         return noChildren(current);
	      }

	      char c = word.charAt(index);
	      int childIndex = c - 'a';
	      TrieNode child = current.children[childIndex];
	      if (child == null) {
	         return false; // The word doesn't exist in the Trie
	      }

	      boolean shouldDeleteChild = delete(child, word, index + 1);
	      if (shouldDeleteChild) {
	         current.children[childIndex] = null;
	         // Return true if the current node has no other children (can be deleted)
	         return !current.isWord && noChildren(current);
	      }

	      return false;
	   }

	   private boolean noChildren(TrieNode node) {
	      for (TrieNode child : node.children) {
	         if (child != null) {
	            return false;
	         }
	      }
	      return true;
	   }
}
