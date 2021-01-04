package exam.complete;


//https://leetcode.com/problems/design-add-and-search-words-data-structure/
//Complete

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True

    }


    Map<Integer, List<String>> map ;
    public WordDictionary() {
        map = new HashMap<>();

    }

    public void addWord(String word) {
        if (!map.containsKey(word.length())) {
            ArrayList<String> list = new ArrayList<>();
            list.add(word);
            map.put(word.length(), list);
        }
        else map.get(word.length()).add(word);
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();

//        Finding in the map
        return map.containsKey(word.length()) && map.get(word.length()).stream().anyMatch(e -> matchCheck(e, chars));
    }

    private boolean matchCheck(String e, char[] chars) {
        boolean answer = true;
        if(e.length() != chars.length) return false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '.') answer = chars[i] == e.charAt(i);
            if(!answer) break;
        }
        return answer;
    }


}