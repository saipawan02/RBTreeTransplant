
package red_black_tree;

public class Node {
    private Node parent;
    private Node l_child;
    private Node r_child;
    private char color;

    public void setColor(char color) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }
    private int data;

    public Node getParent() {
        return parent;
    }

    public Node getL_child() {
        return l_child;
    }

    public Node getR_child() {
        return r_child;
    }

    public int getData() {
        return data;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setL_child(Node l_child) {
        this.l_child = l_child;
    }

    public void setR_child(Node r_child) {
        this.r_child = r_child;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String p,l,r;
        if(parent == null)
            p = "null";
        else
            p = parent.data+"";
        
        if(l_child == null)
            l = "null";
        else
            l = l_child.data+"";
        
        if(r_child == null)
            r = "null";
        else
            r = r_child.data+"";
        
        return "Node{" +  "data=" + data + ", parent=" + p + ", l_child=" + l + ", r_child=" + r + ", color=" + color + '}';
    }
    
}

