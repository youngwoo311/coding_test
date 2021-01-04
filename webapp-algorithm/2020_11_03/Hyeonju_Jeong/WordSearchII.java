package exam.complete;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/word-search-ii/
//Complete
public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(findWords(board, words));

    }

//    BFS
    public static List<String> findWords(char[][] board, String[] words) {

        ArrayList<String> answer = new ArrayList<>();

//        Avoid duplication

        for(int w = 0 ; w < words.length; w++) {
            if(exists(board, words[w])){
                answer.add(words[w]);
            }
        }
        Collections.sort(answer);
        return answer;
    }

    private static boolean exists(char[][] board, String word) {

        Stack<IdxSet> stack = new Stack<>();
        int colLength = board.length;
        int rowLength = board[0].length;
        int[] neighborIdxListX = {0,0,-1,1};
        int[] neighborIdxListY = {-1,1,0,0};

        for(int i = 0; i < colLength; i++) {
            for(int j = 0 ; j < rowLength; j++) {
                String nowStr =board[i][j]+"";
                if(nowStr.equals(word)) return true;
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] pathIdxList = new boolean[colLength][rowLength];
                    pathIdxList[i][j] = true;
                    stack.add(new IdxSet(nowStr, i, j, pathIdxList));
                }
            }
        }

        while(true) {
            if(stack.size() < 1) return false;

            IdxSet nowSet =  stack.pop();
            String nowString = nowSet.getWord();

            if(nowString.equals(word)) return true;
            if(nowString.length() >= word.length()) continue;

            for(int i = 0 ; i < neighborIdxListX.length; i++) {
                int nextIdxX  = nowSet.getIdxX() + neighborIdxListX[i];
                int nextIdxY = nowSet.getIdxY() + neighborIdxListY[i];

                if(nextIdxX >= 0 && nextIdxX < colLength && nextIdxY >=0  && nextIdxY < rowLength) {
                    String nextValue = nowString + board[nextIdxX][nextIdxY];
                    boolean[][] flag = nowSet.getCopyObjList();
                    if(nextValue.equals(word.substring(0, nextValue.length())) && !flag[nextIdxX][nextIdxY]) {
                        flag[nextIdxX][nextIdxY] = true;
                        IdxSet idxSet = new IdxSet(nextValue, nextIdxX, nextIdxY, flag);
                        stack.add(idxSet);
                    }
                }
            }
        }
    }

    private static class IdxSet {
        private String word;
        private int idxX;
        private int idxY;


        private boolean[][] pathIdxList ;


        public IdxSet(String word, int idxX, int idxY, boolean[][] pathIdxList) {
            this.word = word;
            this.idxX = idxX;
            this.idxY = idxY;
            this.pathIdxList = pathIdxList;
        }

        public String getWord() {
            return word;
        }

        public int getIdxX() {
            return idxX;
        }

        public int getIdxY() {
            return idxY;
        }

        public boolean[][] getCopyObjList() {
            boolean[][] booleans = new boolean[pathIdxList.length][pathIdxList[0].length];
            for(int i = 0 ; i < pathIdxList.length; i++) {
                for(int j = 0; j < pathIdxList[0].length; j++) {
                    booleans[i][j] = pathIdxList[i][j];
                }
            }
            return booleans;
        }
    }
}
