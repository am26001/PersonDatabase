// data structure for the class BinaryTreeNode
package h10;

// template class
public class BinaryTreeNode<T> {
    
    // attributes
    protected T element;
    protected BinaryTreeNode left, right;

    // parameterized constructor
    public BinaryTreeNode(T obj) {
        element = obj;
        left = null;
        right = null;
    }

    // gets & sets
    
    public T getValue() {
        return element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

} // end class

