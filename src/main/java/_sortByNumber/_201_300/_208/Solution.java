package _sortByNumber._201_300._208;

class Trie {

    private final int R = 26;
    private Trie[] children = new Trie[R];
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie tmp = this;
        for (char i : word.toCharArray()) {
            if (tmp.children[i - 'a'] == null) {
                tmp.children[i - 'a'] = new Trie();
            }
            tmp = tmp.children[i - 'a'];
        }
        tmp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie tmp = this;
        for (char i : word.toCharArray()) {
            if (tmp.children[i - 'a'] == null) {
                return false;
            }
            tmp  = tmp.children[i - 'a'];
        }
        return tmp.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie tmp = this;
        for (char i : prefix.toCharArray()) {
            if (tmp.children[i - 'a'] == null) {
                return false;
            }
            tmp = tmp.children[i - 'a'];
        }
        return true;
    }
}

public class Solution {


}
