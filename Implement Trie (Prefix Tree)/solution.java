/*
 * 普通的字典树。
 * 为了节省空间煞笔地用了Map，结果跑得后10%。。。
 */

class TrieNode {
    // Initialize your data structure here.
    boolean end;
    char val;
    Map<Character, TrieNode> map;
    public TrieNode(char val) {
        this.val = val;
        map = new HashMap<>();
    }
}

public class Trie {
    private TrieNode root;
    private int nodeCnt;

    public Trie() {
        root = new TrieNode('0');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); ++i) {
            char nextCharacter = word.charAt(i);
            if (!currentNode.map.containsKey(nextCharacter))
                currentNode.map.put(nextCharacter, new TrieNode(nextCharacter));
            currentNode = currentNode.map.get(nextCharacter);
        }
        currentNode.end = true;
    }

    private TrieNode getLastNode(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); ++i) {
            char nextCharacter = word.charAt(i);
            if (!currentNode.map.containsKey(nextCharacter))
                return null;
            currentNode = currentNode.map.get(nextCharacter);
        }
        return currentNode;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode lastNode = getLastNode(word);
        if (lastNode == null || !lastNode.end)
            return false;
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode lastNode = getLastNode(prefix);
        return lastNode != null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
