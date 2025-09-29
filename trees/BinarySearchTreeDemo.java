// a binary tree is a tree where each node has no more than 2 children

// a binary search tree is a binary tree where values are arranged in a certain order
// the root node should be greater than the left child, but less than the right child

// example:
/*
                    4
                   / \
                 2     6
                / \   / \
               1   3 5   7
*/
// this property holds true as the tree produces new nodes

// the idea behind binary search trees is that when we search for something, we compare it to a root and determine where to search for that data, rather than 
// searching the whole tree. if it's less than that root value, we search the left // half of the tree and don't bother searching the right half. if it's more 
// than the root value, we search the right half of the tree and ignore the left. if // it's equal to the root, then we've found our data. the idea is to avoid 
// searching throughout the entire data structure and reduce time by only searching half the original tree, then half of however subtrees exist within that portion of the tree.

// has best case runtime of O(log n)
// has worst case runtime of O(n), where the closer a lowest or highest value in a number range is used as the starting root of the tree
// examples with numbers 1 through 100:
/*
lowest value in range as root             highest value in range as root
    1                                           100
     \                                           /
      2                                         99
       \                                       /
        3                                     98  
         \                                   /
          4                                 etc...
           \
            5
             \
              etc...

*/

public class BinarySearchTreeDemo {
    public static void main (String[] args) {
        
        // Node class
        class Node {
            int data;
            Node left;
            Node right;

            public Node (int data) {
                this.data = data;
            }
        }

        // BinarySearchTree class
        class BinarySearchTree {
            Node root;

            public void insert(Node node) {
                root = insertHelper(root, node);
            }

            private Node insertHelper(Node root, Node node) {
                int data = node.data;

                if(root == null) {
                    root = node;
                    return root;
                }
                else if(data < root.data) {
                    root.left = insertHelper(root.left, node);
                }
                else {
                    root.right = insertHelper(root.right, node);
                }
                
                return root;
            }

            public void display() {
                displayHelper(root);
            }

            private void displayHelper(Node root) {
                if(root != null) {
                    displayHelper(root.left);
                    System.out.println(root.data);
                    displayHelper(root.right);
                }
            }

            public boolean search(int data) {
                return searchHelper(root, data);
            }


            private boolean searchHelper(Node root, int data) {
                if(root == null) {
                    return false;
                }
                else if(root.data == data) {
                    return true;
                }
                else if(root.data > data) {
                    return searchHelper(root.left, data);
                }
                else {
                    return searchHelper(root.right, data);
                }

            }

            public void remove(int data) {
                if(search(data)) { // if we find the data we're looking for, invoke helper method
                    removeHelper(root, data);
                }
                else {
                    System.out.println(data + " could not be found.");
                }
            }

            public Node removeHelper(Node root, int data) {
                if(root == null) {
                    return root;
                }
                else if(data < root.data) {
                    root.left = removeHelper(root.left, data);
                }
                else if(data > root.data) {
                    root.right = removeHelper(root.right, data);
                }
                else { // node found
                    // if found node has no children
                    if(root.left == null && root.right == null) {
                        root = null;
                    }
                    // if found node has right child, need to find successor
                    else if(root.right != null) {
                        root.data = successor(root);
                        root.right = removeHelper(root.right, root.data);
                    }
                    // if found node has left child, need to find predecessor
                    else {
                        root.data = predecessor(root);
                        root.left = removeHelper(root.left, root.data);
                    }
                }
                return root;
            }


            // all elements of right side of trees root will fulfill the condition of "greater than the root",
            // so here, we need to find the least value below the right child of this root node
            private int successor(Node root) { // attempting to find 
                root = root.right;
                while(root.left != null) { // we check left first because in all other subtrees, left will always be lesser than right values
                    root = root.left;
                }
                return root.data;
            }

            // all elements of left side of trees root will fulfill the condition of "less than the root",
            // so here, we need to find the greatest value below the left child of this root node
            private int predecessor(Node root) {
                root = root.left;
                while(root.right != null) { // we check left first because in all other subtrees, left will always be lesser than right values
                    root = root.right;
                }
                return root.data;
            }

        }

        // start of code
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));

        tree.display();
        System.out.println(tree.search(0)); // no zero, should return false
        System.out.println(tree.search(3)); // 3 is in the tree, should return true
        tree.remove(0); // not in tree, should return print message
        tree.remove(9);
        tree.display();
    }
}

