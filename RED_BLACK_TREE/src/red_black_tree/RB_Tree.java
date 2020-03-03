package red_black_tree;

import java.util.ArrayList;

public class RB_Tree {
    private int height=0;
    private Node Tnil;
    private Node root;
    RB_Tree(){
        Tnil = new Node();
        Tnil.setColor('B');
        Tnil.setL_child(null);
        Tnil.setR_child(null);
        root = Tnil;
    }
    Node getRoot(){
        return root;
    }
    void insert(int data){
        
        Node z = new Node();
        z.setData(data);
        z.setParent(null);
        z.setL_child(Tnil);
        z.setR_child(Tnil);
        z.setColor('R');
        Node y=null;
        Node x = root;
        while(x!=Tnil){
            y=x;
            if(x.getData()<z.getData())
                x=x.getR_child();
            else if(x.getData()>z.getData())
                x=x.getL_child();
            else
                return;
        }
        z.setParent(y);
        if(y==null){
            root=z;
        }else{
            if(y.getData()<z.getData()){
                y.setR_child(z);
            }else{
                y.setL_child(z);
            }
        }
        if(z.getParent()==null){
            z.setColor('B');
            return ;
        }
        if(z.getParent().getParent() == null){
            return ;
        }
        insert_fix(z);
    }
    
    private void insert_fix(Node z){
        Node y;
        
        while(z.getParent().getColor()=='R'){
            if(z.getParent()== z.getParent().getParent().getL_child()){
                y=z.getParent().getParent().getR_child();
                if(y.getColor()=='R'){
                    y.setColor('B');
                    z.getParent().setColor('B');
                    z.getParent().getParent().setColor('R');
                    z=z.getParent().getParent();
                }else{
                    if(z==z.getParent().getR_child()){
                        z=z.getParent();
                        rotateLeft(z);
                    }
                    z.getParent().setColor('B');
                    z.getParent().getParent().setColor('R');
                    rotateRight(z.getParent().getParent());
                }
            }else if(z.getParent()== z.getParent().getParent().getR_child()){
                y=z.getParent().getParent().getL_child();
                if(y.getColor()=='R'){
                    y.setColor('B');
                    z.getParent().setColor('B');
                    z.getParent().getParent().setColor('R');
                    z=z.getParent().getParent();
                }else{
                    if(z==z.getParent().getL_child()){
                        z=z.getParent();
                        rotateRight(z);
                    }
                    z.getParent().setColor('B');
                    z.getParent().getParent().setColor('R');
                    rotateLeft(z.getParent().getParent());
                } 
            }
            if(z==root){
                break;
            }
        }
        root.setColor('B');
    }
    
    private void rotateLeft(Node z){
        Node y = z.getR_child();
        z.setR_child(y.getL_child());
        
        if(y.getL_child()!= Tnil){
            y.getL_child().setParent(z);
        }
        y.setParent(z.getParent());
        
        if(z.getParent()==null){
            root=y;
        }else{
            if(z==z.getParent().getL_child()){
                z.getParent().setL_child(y);
            }else{
                z.getParent().setR_child(y);
            }
        }
        y.setL_child(z);
        z.setParent(y);
        
    }
    private void rotateRight(Node z){
        Node y = z.getL_child();
        z.setL_child(y.getR_child());
        
        if(y.getR_child()!= Tnil){
            y.getR_child().setParent(z);
        }
        y.setParent(z.getParent());
        
        if(z.getParent()==null){
            root=y;
        }else{
            if(z==z.getParent().getR_child()){
                z.getParent().setR_child(y);
            }else{
                z.getParent().setL_child(y);
            }
        }
        y.setR_child(z);
        z.setParent(y);
    }
    
    void inOrder(Node node){
        if(node == Tnil){
            return ;
        }
            inOrder(node.getL_child());
            System.out.print("->"+node.getData()+"("+node.getColor()+")");
            inOrder(node.getR_child());
    }
    
    ArrayList<Integer> getinOrder(Node node,ArrayList<Integer> inorderList){
        if(node == Tnil){
            return inorderList;
        }
            getinOrder(node.getL_child(),inorderList);
            inorderList.add(node.getData());
            getinOrder(node.getR_child(),inorderList);
        return inorderList;
    }
    
    int height(Node root){
        int h2=0;
        Node node = root;
        while(node!=Tnil){
            node=node.getL_child();
            if(node.getColor()=='B'){
                h2++;
            }
        }
        return h2-1;
    }
    
}