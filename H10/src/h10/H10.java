/* this program maintains the names, birth dates, phone numbers of friends and relatives, it models a database,
   & uses a Person, BinaryTreeNode, & BST class
   @author Alan Martinez-Lopez
 */
package h10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class H10 {

    public static void main(String[] args) {

        // open the file
        File f = new File("H10input.txt");

        // make scanner to read input
        Scanner fileInput = null;

        // try - catch 
        try {
            fileInput = new Scanner(f);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(-1);
        }

        // create tree by calling BST default constructor
        BST myTree = new BST();

        // create BinaryTreeNode of Person type & set root node to null
        BinaryTreeNode<Person> root = null;

        // declare string vars to be used throughout main
        String firstName;
        String lastName;
        String bDay;
        String phoneNo;

        // loop until file is empty
        while (fileInput.hasNext()) {
            // take input to create person object node 
            firstName = fileInput.next();
            lastName = fileInput.next();
            bDay = fileInput.next();
            phoneNo = fileInput.next();
            // create person object
            Person personObj = new Person(firstName, lastName, bDay, phoneNo);
            // insert person object to tree
            root = myTree.insert(root, personObj);
        } // end loop

        // create scanner
        Scanner scnr = new Scanner(System.in);

        // make boolean to break out of loop
        boolean exit = false;

        // while boolean is false, continue loop
        while (exit == false) {
            // prompt user with options
            System.out.println("1. Enter 1 to add a person and their info");
            System.out.println("2. Enter 2 to retrieve a person's info by their lastname");
            System.out.println("3. Enter 3 to retrieve all info");
            System.out.println("4. Enter 4 to retrieve everyone's info by their month");
            System.out.println("5. Enter 5 to quit");
            // take input
            int option = scnr.nextInt();
            // check which option the user input
            switch (option) {
                // if 1, add person to list
                case 1:
                    // prompt
                    System.out.println("Enter first and lastname (e.g., John Smith)");
                    // take input
                    firstName = scnr.next();
                    lastName = scnr.next();
                    // prompt
                    System.out.println("Enter birthday (e.g., 01/02/1993)");
                    // take input
                    bDay = scnr.next();
                    // prompt
                    System.out.println("Enter phone number (e.g., 123-456-7890)");
                    // take input
                    phoneNo = scnr.next();
                    // create person object
                    Person personObj = new Person(firstName, lastName, bDay, phoneNo);
                    // insert to tree
                    myTree.insert(root, personObj);
                    break;
                // if 2, find person by last name
                case 2:
                    // prompt
                    System.out.println("Enter lastname (e.g., Smith)");
                    // take input
                    lastName = scnr.next();
                    // print person not found if null, else return person
                    if (myTree.matchLastName(root, lastName) == null) {
                        System.out.println("Person NOT found for lastname: " + lastName + "\n");
                    } else {
                        System.out.println(myTree.matchLastName(root, lastName));
                    }
                    break;
                // if 3, retrieve all people and their info
                case 3:
                    // prompt
                    System.out.println("Info of all people listed below\n");
                    // call method to print all people in sorted order
                    myTree.inOrder(root);
                    break;
                // if 4, find people by month
                case 4:
                    // prompt
                    System.out.println("Enter month (e.g., 10 for October)");
                    // take input
                    bDay = scnr.next();
                    // print person by month entered
                    myTree.matchMonth(root, bDay);
                    break;
                // if 5, quit
                case 5:
                    // update boolean
                    exit = true;
                    break;
            } // end switch case
        } // end while

    } // end main

} // end class
