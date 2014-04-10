package ch3_dataStructures;

import java.util.Stack;

/**
 * @author Tomasz Lelek
 * @since 2014-04-10
 */
public class InterviewProblems {

    /**
     *
     * @param s
     * @return if 0 then s is correct, if =! 0 then returned index of first offending parenthesis
     */
    public static int isBalancedParenthesis(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (isOpen(character)) {
                if(i == s.length() - 1){
                    return i;
                }
                stack.push(character);
            } else {
                if (stackIsEmpty(stack)) {
                    return i;
                }

                Character charFromStack = stack.pop();
                if (!isOpen(charFromStack)) {
                    System.out.println("offending parenthesis at position : " + i);
                    return i;
                }
            }
        }
        return 0;
    }

    private static boolean stackIsEmpty(Stack<Character> stack) {
        return stack.size() == 0;
    }

    private static boolean isOpen(Character character) {
        return character.equals('(');
    }
}
