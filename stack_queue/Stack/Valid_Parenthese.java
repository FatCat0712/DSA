package stack_queue.Stack;

import java.util.Stack;

public class Valid_Parenthese {
    public boolean isValid(String s){
        Stack<Character> myStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                myStack.push(c);
            }
            else{
                if(myStack.isEmpty()){
                    return false;
                }
                char openPeek = myStack.peek();
                if((c == ')' && openPeek == '(') || (c == ']' && openPeek == '[') || (c == '}' && openPeek == '}')){
                    myStack.pop();
                }
                else{
                    return false;
                }
            }

        }
        return myStack.isEmpty();

    }
    public static void main(String[] args) {

    }
}
