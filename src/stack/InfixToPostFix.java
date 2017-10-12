package stack;

import java.text.DecimalFormat;
import java.util.Stack;

public class InfixToPostFix {

    public static void main(String [] args){
        
        Stack<Character> stack = new Stack<Character>();
        
       // String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String exp = "a+b*c+d";
        
        StringBuffer output = new StringBuffer();
        Character c;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println((float)Math.round(1.125*100)/100);
        for(int i =0;i<exp.length();i++){
            c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                output.append(c);
            }else if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty()&& stack.peek()!='('){
                    output.append(stack.pop());
                }
                
                if(!stack.isEmpty()&&stack.peek()!='('){
                    throw new RuntimeException("invalid expression");
                }
                stack.pop();
            }else{
                while(!stack.isEmpty()&&prec(c)<=prec(stack.peek())){
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()){
            output.append(stack.pop());
        }
        
        System.out.println("result "+output.toString());
    }

    private static int prec(Character peek) {
        switch(peek){
        case '+':
        case'-':
            return 1;
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;

    }
}
