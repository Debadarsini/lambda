package javalambada;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javalambada.c.Trie;

public class c {
    
    class TrieNode{
        
        char c;
        Map<Character,TrieNode> children;
        boolean isEnd;
        
        TrieNode(char c ){
            c =c;
            children = new HashMap();
        }
        
        
    }

    class Trie{
        TrieNode root;
        
        Trie(){
            root = new TrieNode((char)0);
        }
        
        void insert(String key,int length){
            TrieNode node = root;
            char charAt;
            for(int i =0;i<length;i++){
                charAt = key.charAt(i);
                if(node.children.containsKey(charAt)){
                    node = node.children.get(charAt);
                }else{
                    TrieNode root = new TrieNode(charAt);
                    node.children.put(charAt,root);
                    node = root;
                }
            }
            node.isEnd=true;
        }
        
        int getMatchingLength(String key,int length){
            int count=0;
            char charAt;
            TrieNode node = root;
            for(int k=0;k<length;k++){
                charAt = key.charAt(k);
                if(node.children.containsKey(charAt)){
                    count++;
                    node = node.children.get(charAt);
                }else{
                    return count;
                }
            }
            return count;
        }
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int no = sc.nextInt();
        
        String input;
        int count;
        String subString;
        c sol = new c();
        for(int i=0;i<no;i++){
            input = sc.next();
            Trie trie = sol.new Trie();
            int length = input.length();
            trie.insert(input,length);
            count=0;
            char zero= input.charAt(0);
            for(int k=0;k<length;k++){
                subString = input.substring(k);
                if(zero==subString.charAt(0)){
                    count+=trie.getMatchingLength(subString,length-k);
                }
                continue;
            }
            System.out.println(count);
        }
        
    }
}