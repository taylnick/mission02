package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.DoublyLinkedList;
import edu.isu.cs.cs3308.structures.impl.LinkedStack;

import java.util.Scanner;

/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 */
public class PostFix {

    private static final String plus = "+";
    private static final String minus = "-";
    private static final String mult = "*";
    private static final String div = "/";

    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @param infix A string representing an postfix notation expression where
     * each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */

    public static int evalPostFix(String infix) {
        if(infix == null || infix.isEmpty()) return 0;
        //String postFix = infix.replaceAll(" ", "");
        String[] postFix = infix.split(" ");
        if(postFix.length == 0) return 0;

        LinkedStack<Integer> postFixStack = new LinkedStack<>();

        for(int i = 0; i < postFix.length; i++){
            if(postFixStack.size() < 2 && (postFix[i].equals(plus) || postFix[i].equals(minus) ||postFix[i].equals(mult) || postFix[i].equals(div)))
                throw new IllegalArgumentException("Too few operands");
            switch (postFix[i]){
                case plus: {
                    int result = postFixStack.pop() + postFixStack.pop();
                    postFixStack.push(result);
                    break;
                }
                case minus: {
                    int op1 = postFixStack.pop();
                    int op2 = postFixStack.pop();
                    int result = op2 - op1;
                    postFixStack.push(result);
                    break;
                }
                case mult: {
                    int result = postFixStack.pop() * postFixStack.pop();
                    postFixStack.push(result);
                    break;
                }
                case div: {
                    int op1 = postFixStack.pop();
                    int op2 = postFixStack.pop();
                    int result = op2 / op1;
                    postFixStack.push(result);
                    break;
                }
                default: postFixStack.push(Integer.parseInt(postFix[i]));
            }

        }

        //throw new UnsupportedOperationException("Not supported yet.");
        return postFixStack.pop();
    }
}
