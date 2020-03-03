package red_black_tree;

import java.util.ArrayList;
import java.util.Scanner;


public class RED_BLACK_TREE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("select:\n1.run of static input\n2.Give User Input");
        int sel = sc.nextInt();
        
        RB_Tree tree1 = new RB_Tree();
        RB_Tree tree2 = new RB_Tree();
        
        
        if(sel==2){
            //for first tree
            System.out.print("Enter the no. of nodes: ");
            int N1 = sc.nextInt();
            for(int i=0 ;i<N1 ;i++){
                System.out.print("enter data:");
                tree1.insert(sc.nextInt());
            }
            Node root1=tree1.getRoot();
            System.out.println("");
            tree1.inOrder(root1);
            System.out.println("");
            System.out.println("Height: "+tree1.height(root1));
            
            
            //for second tree
            System.out.print("Enter the no. of nodes: ");
            int N2 = sc.nextInt();
            for(int i=0 ;i<N2 ;i++){
                System.out.print("enter data:");
                tree2.insert(sc.nextInt());
            }
            Node root2=tree2.getRoot();
            System.out.println("");
            tree2.inOrder(root2);
            System.out.println("");
            System.out.println("Height: "+tree2.height(root2));
            
            ArrayList<Integer> inorder = new ArrayList<>();
            inorder = tree1.getinOrder(root1, inorder);

            System.out.println(inorder);


            while(!inorder.isEmpty()) {
                tree2.insert(inorder.remove(0));
            }
            System.out.println("******IN ORDER OF NEW TREE********");
            tree2.inOrder(root2);
            System.out.println("\n**********************************");

            System.out.println("HEIGHT:"+tree2.height(root2));
            
        
        }else if(sel==1){
            int[] tree1contents = {1,2,3,4,5,6,7,8,9};
            int[] tree2contents = {13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
            for(int i=0 ;i<tree1contents.length ;i++){
                tree1.insert(tree1contents[i]);
            }
            Node root1=tree1.getRoot();
            System.out.println("");
            tree1.inOrder(root1);
            System.out.println("");
            System.out.println("Height: "+tree1.height(root1));
            
            
            for(int i=0 ;i<tree2contents.length ;i++){
                tree2.insert(tree2contents[i]);
            }
            Node root2=tree2.getRoot();
            System.out.println("");
            tree2.inOrder(root2);
            System.out.println("");
            System.out.println("Height: "+tree2.height(root2));
            
            
            ArrayList<Integer> inorder = new ArrayList<>();
            inorder = tree1.getinOrder(root1, inorder);

            System.out.println(inorder);


            while(!inorder.isEmpty()) {
                tree2.insert(inorder.remove(0));
            }
            System.out.println("******IN ORDER OF NEW TREE********");
            tree2.inOrder(root2);
            System.out.println("\n**********************************");

            System.out.println("HEIGHT:"+tree2.height(root2));
            
        }else{System.out.println("Ivalid Input");return;}
    }
}
