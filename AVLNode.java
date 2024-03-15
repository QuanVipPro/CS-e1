package a_pe_csd_de1;
public class AVLNode {
    public Country data;
    public AVLNode left;
    public AVLNode right;
    public int height;
    
    public AVLNode(Country data) {
        this.data = data;
        this.height = 1;
    }

    public Country getData() {
        return data;
    }

    public void setData(Country data) {
        this.data = data;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }
}
