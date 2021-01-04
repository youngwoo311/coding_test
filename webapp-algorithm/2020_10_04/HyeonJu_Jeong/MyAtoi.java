//https://leetcode.com/problems/string-to-integer-atoi/
package exam;

public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483646"));
    }


    public static int myAtoi(String s) {
//        Discard whitespaces
        s = s.trim();
        int signFlag = 1;
        int startIdx = -1;

//        Empty check
        if(s.length() == 0) {
            return 0;
        } else if(s.length() == 1 && (s.charAt(0) - '0' < 0 || s.charAt(0) -'0' > 9)){
            return 0;
        }

//      Filtering digits
//        start Idx
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            if(s.charAt(1) - '0' >= 0 && s.charAt(1) -'0' <= 9) {
                startIdx = 1;
            }
        } else if (s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <= 9) {
            startIdx = 0;
        } else {
            return 0;
        }

//
        if(startIdx == -1) return 0;

        StringBuilder stringArray  = new StringBuilder();

        boolean flag = false;
        for(int i = startIdx; i < s.length(); i++) {
            int nowChar = s.charAt(i) - '0';
            if(nowChar < 0 || nowChar > 9 ) {
                break;
            } else if( nowChar == 0 && !flag) {
                continue;
            } else {
                stringArray.append(nowChar);
                flag =true;
            }

        }

        if(stringArray.length() ==0) return 0;

        if(stringArray.length() > 10) {
            if(startIdx >0 && s.charAt(startIdx -1) == '-') {
               return Integer.MIN_VALUE;
            } else return Integer.MAX_VALUE;
        }


        long parseLong = Long.parseLong(stringArray.toString());
        //      Check sign
        if(startIdx >0 && s.charAt(startIdx -1) == '-') {
            parseLong *= -1;
        }
//       Check Integer Range
        int answer = 0 ;
        if(parseLong > Integer.MAX_VALUE) answer = Integer.MAX_VALUE -1;
        else if(parseLong < Integer.MIN_VALUE) answer = Integer.MIN_VALUE;
        else answer = (int) parseLong;


        return answer;
    }

}
