package data_structures.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }
    private final TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    // Insertion in TrieNode
    public void insert(String word){
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        // Mark the current nodes endOfWord as true.
        current.isEndOfWord = true;
    }

    // Search/retrieval in Trie
    public boolean search(String word){
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            TrieNode node = current.children.get(ch);
            if(node == null)
                return false;
            current = node;
        }
        return current.isEndOfWord;
    }
}
