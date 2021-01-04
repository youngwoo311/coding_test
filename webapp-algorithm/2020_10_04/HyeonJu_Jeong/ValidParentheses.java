//https://leetcode.com/problems/valid-parentheses/submissions/
package exam;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{}[][](()){[[]]}"));
    }


//    stack
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++) {
            char aa = s.charAt(i);
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                  stack.push(s.charAt(i));
            } else {
                if(stack.size() ==0) return false;
                else if(s.charAt(i) == '}' && stack.pop() != '{') return false;
                else if(s.charAt(i) == ')' && stack.pop() != '(') return false;
                else if(s.charAt(i) == ']' && stack.pop() != '[') return false;
            }
        }

        return stack.size() == 0;
    }
}
