class Node {
     int data;
     Node next;
     Node(int data){
         this.data=data;
     }
  }



public class MergeList {
    Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission. 
        // You only need to complete this method 
       if(headA==null && headB==null){
           return null;
       }
       if(headA==null){
           return headB;
       }
       
       if(headB==null){
           return headA;
       }
       
       if(headA.data<headB.data){
           headA.next = mergeLists(headA.next,headB);
       }else{
           Node temp = headB;
           headB = headB.next;
           temp.next = headA;
           headA = temp;
           headA.next = mergeLists(headA.next,headB);
           
       }
       return headA;
      

   }
    int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method. 
        Node currentA = headA;
        Node currentB = headB;
        
        while(currentA!=currentB){
            if(currentA.next==null){
                currentA = headB;
            }else{
                currentA = currentA.next;
            }
            
            
            if(currentB.next==null){
                currentB = headA;
            }else{
                currentB = currentB.next;
            }
        }
        
        return currentB.data;

    }
    
    public static void main(String[] args){
        
        Node headA = new Node(1);
        headA.next = new Node(3);
        headA.next.next= new Node(5);
        headA.next.next.next = new Node(6);
        
        Node headB = new Node(2);
        headB.next =  new Node(4);
        headB.next.next =  new Node(7);
        
        MergeList list = new MergeList();
        list.mergeLists(headA, headB);
        
        Node headC = new Node(1);
        Node data = new Node(3);
        headC.next = data;
        headC.next.next= new Node(7);
        
        Node headD = new Node(2);
        headD.next =  data;
        headD.next.next =  new Node(8);
        
       System.out.println( list.FindMergeNode(headC, headD));
    }

}
