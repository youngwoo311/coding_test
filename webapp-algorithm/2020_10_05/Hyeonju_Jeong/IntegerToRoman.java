package exam;
//https://leetcode.com/problems/integer-to-roman/

import java.util.TreeMap;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(800));
    }

//  greedy
    public static String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();

//        Create a combination treemap
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "I");
        treeMap.put(5, "V");
        treeMap.put(10, "X");
        treeMap.put(50, "L");
        treeMap.put(100, "C");
        treeMap.put(500, "D");
        treeMap.put(1000, "M");

//        5
        treeMap.put(4, "IV");
//        10
        treeMap.put(9, "IX");
//        50
        treeMap.put(40, "XL");
//        100
        treeMap.put(90, "XC");
//        500
        treeMap.put(400, "CD");
//       1000
        treeMap.put(900, "CM");




//        treeMap.keySet().forEach(System.out::println);

//        Get the closest number in set ( digits )
        String s = num + "";
        for(int i = 0; i < s.length(); i++) {
            int nowNum = (int)s.charAt(i) - '0';
            for(int j = 0 ; j < s.length() -i -1; j++) nowNum *= 10;

            if(treeMap.containsKey(nowNum)) {
                answer.append(treeMap.get(nowNum));
            } else {
                StringBuilder calRoman = new StringBuilder();
                while(nowNum > 0) {
                    int lowerKey = treeMap.containsKey(nowNum) ? nowNum : treeMap.lowerKey(nowNum);
                    nowNum -= lowerKey;
                    calRoman.append(treeMap.get(lowerKey));
                }
                answer.append(calRoman);
            }
        }

        return answer.toString();

    }
}
