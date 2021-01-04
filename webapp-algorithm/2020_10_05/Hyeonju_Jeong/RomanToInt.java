package exam;
//https://leetcode.com/problems/roman-to-integer/

import java.util.TreeMap;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCDXCIII"));
        System.out.println(romanToInt("DCCC"));
    }

    public static int romanToInt(String s) {
        int answer = 0;
        //        Create a combination treemap
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("I", 1);
        treeMap.put("V", 5);
        treeMap.put("X", 10);
        treeMap.put("L",50);
        treeMap.put("C", 100 );
        treeMap.put("D", 500);
        treeMap.put("M",1000);

//        5
        treeMap.put("IV", 4);
//        10
        treeMap.put("IX", 9);
//        50
        treeMap.put("XL", 40);
//        100
        treeMap.put("XC",90);
//        500
        treeMap.put("CD",400);
//       1000
        treeMap.put("CM", 900);


        for(int i = 0 ; i < s.length(); i++) {
            if(i + 1 < s.length() && treeMap.containsKey(s.substring(i, i+2))) {
                answer += treeMap.get(s.substring(i, i+2));
                i++;
            } else {
                answer += treeMap.get(s.substring(i, i+1));
            }
        }
        return answer;
    }

}
