package binarysearchtree;

import java.util.Stack;

class Node<T>{
    T data;
    Node<T> left,right;
    
     Node(T incoming){
         this.data=incoming;
     }
}

public class bst<Intger> {
    
    Node<Intger> root;
    
    bst(Node<Intger> incoming){
        root =incoming;
    }
    
    bst(){
        
    }
    void insert(int data ){
        root =insertRec((Node<Integer>) root,data);
    }
    
    Node insertRec(Node<Integer> node,int data){
        if(node==null){
            node = new Node(data);
            return node;
        }else if(data < node.data){
            node.left=insertRec(node.left,data);
        }else if(data > node.data){
            node.right=insertRec(node.right,data);
        }
        return node;
    }
    
    
    Node search(Node<Integer> node,int data){
        if(node==null || node.data==data){
            return node;
        }else if(data<node.data){
            return search(node.left, data);
        }
        return search(node.right, data);
    }
    
    
    Node deleteNode(int key, Node<Integer> node){
        
        if(node == null){
            return node;
        }else if(key<node.data){
            node.left = deleteNode(key,node.left);
        }else if(key>node.data){
            node.right=deleteNode(key,node.right);
        }else{
            
            if(node.left==null){
                return node.right;
            }else if(node.right==null){
                return node.left;
            }
            node.data=minValue(root.right);
            
            
        }
        return node;
    }
    
    
    
    private Integer minValue(Node<Intger> right) {
        int minv=0;
        while(right!=null){
            minv=(int) right.data;
            right = right.left;
        }
        return minv;
    }
    
    void inOrderSuccessorPredecissor(Node<Integer> root, int key,Node pre, Node suc){
        if(root ==null){
            return;
        }
        
        if(root.data==key){
            if(root.left!=null){
                pre.data = rightMax(root.left).data;
            }if(root.right!=null){
                suc.data = leftMax(root.right).data;
            }
        }
        
        if(key<root.data){
            suc.data = root.data;
            inOrderSuccessorPredecissor(root.left, key,pre,suc);
        }
        if(key>root.data){
            pre.data=root.data;
            inOrderSuccessorPredecissor(root.right, key,pre,suc);
        }
    }
    
    void inOrderUsingStack(Stack<Node> stack,Node<Integer> node,int count){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        
        while(!stack.isEmpty()){
            Node element = stack.pop();
            if(count==3){
                System.out.print(element.data+" ");
            }
            count++;
            if(element.right!=null){
                node = element.right;
                while(node!=null){
                    stack.push(node);
                    node = node.left;
                }
            }
            
        }
    }
    
    boolean isBst(Node<Integer> node){
        if(node == null){
            return true;
        }else if(
                (node.left ==null || 
                node.data>node.left.data
                && isBst(node.left))
                &&  (node.right ==null || node.data <node.right.data 
                && isBst(node.right))){
            return true;
        }
        return false;
    }

    private Node rightMax(Node<Integer> node) {
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }
    
    private Node leftMax(Node<Integer> node) {
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
    
    
    private int lca(Node<Integer> node, int data1, int data2){
        if(node==null){
            return 0;
        }else if(node.data<data1 && node.data<data2){
            return lca(node.right,data1,data2);
        }else if(node.data>data1 && node.data>data2){
            return lca(node.left,data1,data2);
        }else{
            return node.data;
        }
    }

    public static void main(String [] args){
        bst tree = new bst();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        inOrderTraversal(tree.root);
        System.out.println(tree.search(tree.root, 50).data);
        
      //  tree.deleteNode(20,tree.root);
        //inOrderTraversal(tree.root);
        Node pre = new Node(-1);
        Node suc = new Node(-1);
       tree.inOrderSuccessorPredecissor(tree.root,30,pre,suc);
       
       System.out.println(pre.data);
       System.out.println(suc.data);
       
       System.out.println(tree.isBst(tree.root));
       
       System.out.println(tree.lca(tree.root,20,40));
       Stack stack = new Stack();
       tree.inOrderUsingStack(stack,tree.root,0);
    }

    private static void inOrderTraversal(Node root) {
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
        
    }
}
