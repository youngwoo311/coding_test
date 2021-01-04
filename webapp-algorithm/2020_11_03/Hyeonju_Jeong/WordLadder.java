package exam.complete;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/word-ladder/
//Complete
public class WordLadder {
    public static void main(String[] args) {
//        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ladderLength("a","c", Arrays.asList("a","b", "c")));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int answer = 0;

//        Exception Handling
        if(wordList.size() < 1) return answer;
        else if(!wordList.contains(endWord)) return answer;

        Queue<StrSet> queue = new ArrayDeque<>();
        boolean[] flag = new boolean[wordList.size()];

//        Initialization
        if (beginWord.equals(endWord)) {
            return 1;
        }
        for(int i = 0 ; i < wordList.size(); i++) {
            String nowWord = wordList.get(i);
            if (checkVal(beginWord, nowWord)) {
                if (nowWord.equals(endWord)) {
                    return 1;
                }
                flag[i] = true;
                queue.add(new StrSet(nowWord, 2));
            }
        }


        while (true) {
            if (queue.size() < 1) {
                break;
            }

            StrSet nowSet = queue.poll();
            String nowWord = nowSet.word;
            for (int i = 0; i < wordList.size(); i++) {
                String nextWord = wordList.get(i);
                if(!flag[i] && checkVal(nowWord, nextWord)){
                    flag[i] = true;
                    if (nextWord.equals(endWord)) {
                        return nowSet.circleVal +1;
                    }
                    queue.add(new StrSet(nextWord, nowSet.circleVal + 1));
                }
            }

        }

        return answer;

    }


//    Check
    private static boolean checkVal(String beginWord, String nowWord) {
        char[] beginWordArray = beginWord.toCharArray();
        char[] targetWordArray = nowWord.toCharArray();

        int sameCharCnt = 0 ;
        for (int i = 0; i < beginWordArray.length; i++) {
            if (beginWordArray[i] != targetWordArray[i]) {
                sameCharCnt++;
            }
        }

        return sameCharCnt == 1;
    }

    private static class StrSet {
        private String word;
        private int circleVal ;

        public StrSet(String word,  int circleVal) {
            this.word = word;
            this.circleVal = circleVal;
        }

        public int getCircleVal() {
            return circleVal;
        }

        public void setCircleVal(int circleVal) {
            this.circleVal = circleVal;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

    }
}
