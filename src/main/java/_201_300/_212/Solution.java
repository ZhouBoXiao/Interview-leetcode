package _201_300._212;



import java.util.*;

public class Solution {

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> result = new LinkedList<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, visited, i, j, m, n,result,trie);
            }
        }

        return result;

    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, List<String> result, Trie trie) {

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] )
            return;

        trie = trie.children[board[i][j] - 'a'];
        if (trie == null)
            return;

        visited[i][j] = true;
        if (trie.isEnd) {
            result.add(trie.val);
            trie.isEnd = false;
        }

        find(board, visited,i+1, j, m, n, result, trie);
        find(board, visited, i, j+1, m, n, result, trie);
        find(board, visited,i-1, j, m, n, result, trie);
        find(board, visited,i, j-1, m, n, result, trie);

        visited[i][j] = false;

    }


    private class Trie {
        String val;
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
            tmp.val = word;
            tmp.isEnd = true;
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};

        System.out.println(new Solution().findWords(board, words));
    }

}