package stackqueue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import stack.Solution;

public class QueueUsingStack {
    
    public static int fibonacci(int n) {
        int [] memory = new int[n+1];
        return fibonacci(n,memory);
        // Complete the function.
    }
    
    private static int fibonacci(int n, int[] memmory){
        if(n==0 || n==1){
            memmory[n] =1;
        }else if(memmory[n]==0){
                memmory[n]= fibonacci(n-1,memmory)+fibonacci(n-2,memmory);
        }
        return memmory[n];


    }



    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        System.out.println(QueueUsingStack.fibonacci(2));

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
Integer element;
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                element = queue.peek();
                if(element!=null){
              System.out.println(queue.peek());
                }
            }
        }
        scan.close();
    }

}

/*class MyQueue<T> {

    Stack<T> stack;
    Stack<T> stack2;

    MyQueue() {
        stack = new Stack<T>();
        stack2 = new Stack<T>();
    }

    void enqueue(T element) {
       stack.push(element);
    }

    void dequeue() {
        if(stack.isEmpty() && stack2.isEmpty())
        {
            System.out.println("Q is empty");
            System.exit(0);
        }
        if(stack2.isEmpty()){
            while(!stack.isEmpty())
            {
                stack2.push(stack.pop());
            }
        }
        stack2.pop();
    }

    T peek() {
        T element = null;
        if (!stack2.isEmpty()) {
            element = stack2.peek();
        }
        return element;
    }

}*/

class MyQueue<T>{
    
    Stack<T> stack;
    Stack<T> stack2;
    
    MyQueue(){
      stack = new Stack<T>(); 
      stack2= new Stack<T>();
    }
    
    void enqueue(T element){
       stack.push(element);
    }
    
    void dequeue(){
        praparestack2();
        stack2.pop();
    }

    private void praparestack2() {
        if(stack.isEmpty()&&stack2.isEmpty()){
            return;
        }
        
        if(stack2.isEmpty()){
            while(!stack.isEmpty()){
                stack2.push(stack.pop()) ;         
            }
        }
    }
 
    T peek(){
        T element=null;
        praparestack2();
        if(!stack2.isEmpty()){
            element = stack2.peek();
        }
        return element;
    }
    
}
