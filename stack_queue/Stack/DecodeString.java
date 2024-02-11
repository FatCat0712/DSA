package stack_queue.Stack;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s){
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c == ']'){
                // Xử lý chính
                // Pop until meet '['
                String loopString = "";
                while (stack.peek()  != '['){
                    loopString = stack.pop() + loopString;
                }

                // Remove '['
                stack.pop();
                // Get number
                String numberString = "";
                while (stack.isEmpty() == false && Character.isDigit(stack.peek())){
                    numberString = stack.pop() + numberString;
                }


                // Repeat the string
                int nLoop = Integer.parseInt(numberString);
                loopString = loopString.repeat(nLoop);

                // Add the result back to the stack
                for(int j =0 ; j < loopString.length(); j++){
                    stack.push(loopString.charAt(j));
                }
            }
            else{
                stack.push(c);
            }
        }

        // get the result from stack
        String result = "";
        while(stack.empty() == false){
            result = stack.pop() + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[abc2[de]]"));

    }
}
