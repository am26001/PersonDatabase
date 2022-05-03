// data structure for the class BST 
package h10;

// template class
public class BST<T extends Comparable> {

    // attributes
    private BinaryTreeNode root;

    // default constructor
    public void BST() {
        root = null;
    }

    // check if empty
    public boolean isEmpty() {
        return root == null;
    }

    // insert node at appropriate spot
    public BinaryTreeNode insert(BinaryTreeNode node, T data) {
        if (node == null) {
            node = new BinaryTreeNode(data);
        } else {
            T data2 = (T) node.getElement();
            if (data.compareTo(data2) < 0) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    // sort node content from small to big
    public void inOrder(BinaryTreeNode t) {
        if (t != null) {
            inOrder(t.getLeft());
            System.out.println(t.getValue());
            inOrder(t.getRight());
        }
    }

    // get root
    public BinaryTreeNode getRoot() {
        return root;
    }

    // returns person with matched last name
    public static Person matchLastName(BinaryTreeNode t, String lastName) {

        // uppercase first letter to take into account if user does not capitialize first letter
        String modLastName = lastName.substring(0, 1);
        modLastName = modLastName.toUpperCase();
        lastName = modLastName + lastName.substring(1);

        // create person 
        Person p = new Person();

        // set person's last name to passed arg
        p.setLastname(lastName);

        // set to null, allows us to print an error message if person is NOT found
        Person found = null;

        // loop until binary tree is empty
        while (t != null) {
            Person currPerson = (Person) t.getValue();
            // return person if person's last name == current person's last name
            if (p.getLastname().compareTo(currPerson.getLastname()) == 0) {
                found = (Person) t.getValue();
                break;
                // traverse to right of binary tree if person's last name > current person's last name
            } else if (p.getLastname().compareTo(currPerson.getLastname()) > 0) {
                // get right node
                t = t.getRight();
                // else traverse to left of binary tree if person's last name < current person's last name
            } else {
                // get left node
                t = t.getLeft();
            } // end else

        } // end loop

        // found person
        return found;
    }

    // prints person with matched month
    public static void matchMonth(BinaryTreeNode t, String m) {

        // concat a 0 to take into account if user enters one digit
        if (m.length() == 1) {
            m = "0" + m;
        }

        // check if person has month
        if (t != null) {
            // traverse
            matchMonth(t.getLeft(), m);
            // get value
            Person p = (Person) t.getValue();
            String month = p.getBday();
            // get only two digits
            month = month.substring(0, 2);

            // check if same
            if (m.compareTo(month) == 0) {
                // print contents of person
                p.writeOutput();
                // new line
                System.out.println();
            }

            // traverse
            matchMonth(t.getRight(), m);
        }
    }

} // end class
