package stack;

import java.time.LocalDateTime;

public class Solution {
    
    public static void main(String [] args){
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        
        Solution s = new Solution();
        Stack st =  s. new Stack(10);
        st.push(10);
        System.out.println(st.top()==-1?"Empty":st.top());
        st.pop();
        System.out.println(st.top()==-1?"Empty":st.top());
        st.push(5);
        st.push(6);
        st.push(7);
        st.inc(2, 2);
        System.out.println(st.top()==-1?"Empty":st.top());
    }

    
     class Stack{
        int [] arr;
        int size;
        int top;
        
        Stack(int siz){
            arr = new int[siz];
            top = -1;
            size =siz;
        }
        
        void push(int element){
            if(top==size){
                return;
            }
            arr[++top]=element;
        }
        
        int pop(){
            if(top==-1){
                return -1;
            }
            int element = arr[top];
            arr[top--]=-1;
            return element;
        }
        
        void inc(int e, int k){
            for(int j=top;j>top-e;j--){
                arr[j]+=k;
            }
        }
        
        int top(){
            if(top==-1){
                return -1;
            }
            return arr[top];
        }
    }


 
}
