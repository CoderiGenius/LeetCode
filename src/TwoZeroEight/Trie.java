package TwoZeroEight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CoderiGenius
 * @version 2021/4/2 1:15 上午
 */
public class Trie {

    Map<Character,Node> firstLetter;

    /** Initialize your data structure here. */
    public Trie() {
        firstLetter = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node;
        Map<Character,Node> lastMap = firstLetter;
        if(word.length()>0){
            node = firstLetter.get(word.charAt(0));
        }else {
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if(node==null){
                node = new Node(word.charAt(i));
                lastMap.put(word.charAt(i),node);
            }
            if(i==word.length()-1){
                node.aWord = true;
            }
            if(i<word.length()-1){
                lastMap = node.map;
                node = node.map.get(word.charAt(i+1));
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length()<=0){
            return false;
        }
        Map<Character,Node> lastMap = firstLetter;
        for (int i = 0; i < word.length();i++ ) {
            Node node = lastMap.get(word.charAt(i));
            if(node==null)return false;
            if(i==word.length()-1){
                return node.aWord;
            }
            lastMap = node.map;

        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length()<=0){
            return false;
        }
        Map<Character,Node> lastMap = firstLetter;
        for (int i = 0; i < prefix.length();i++ ) {
            Node node = lastMap.get(prefix.charAt(i));
            if(node==null)return false;
            if(i==prefix.length()-1){
                return true;
            }
            lastMap = node.map;

        }
        return true;
    }

    class Node{
        Character data;
        Boolean aWord = false;
        Map<Character,Node> map = new HashMap<>();

        public Node(Character data) {
            this.data = data;
        }

        public Node(Character data, Boolean aWord) {
            this.data = data;
            this.aWord = aWord;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("trie");
        System.out.println(trie.startsWith("tr"));
    }
}

