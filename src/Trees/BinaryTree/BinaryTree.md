# Binary Tree:
    A tree data structure where each node has at most 2 children
    Sinceeach element in a binary tree can have only 2 children,
    we typically name them the left and right child.

    Binary tree is a family of data structures (BST, Heap tree, AVL tree, Red Black tree, Syntax Tree)

    Why binary tree ?
        - Prerequisite for more advance trees like BST, AVL
        - Huffman coding problem, heap priority problem and expression parsing problem can be solved effectively 


# Representation of Binary Tree:

    Binary tree can be represent in two ways
    1.Using LinkedList
    2.Using Array

# LinkedList Representation (Binary Tree Node):

    Contains following parts:
        1.Data
        2.Pointer to left child
        3.Pointer to right child

# Array Representation:

    - Zeroth index of array increase mathematical complexity so we ignore zeroth index of the array 
    - Mathematical Formulas:

        1.For left child index:
            index = 2x
        2.For right child index:
            index = 2x-1

        x = index of parent





# Binary Tree Operations:

    1.Inserting a node
    2.Removing a node
    3.Searching for a specific node
    4.Traversing
    5.Find the Size,height and level of the tree

# Properties

    1.Maximum nodes at level l = 2 power l
    2.Maximum nodes of height h = 2 power h minus 1 = ((2^h)-1)
    3.In a non-empty binary tree, if n is the total number of nodes and e is the total number of edges, then e = n-1
    4. In a Binary tree where every node has 0 or 2 children, the number of leaf nodes is always one more than nodes with two children


# Types of Binary Tree:

    1.Perfect Binary Tree:

        All non leaf nodes have two children and they are on same lavel or at same depth
        e.g 
                                  No of Levels         Atmost nodes
                    n1          <---    Level 0               (1)
                  /    \
                 n2     n3      <---    Level 1               (2)
               /   \   /  \
              n4   n5 n6  n7    <---    Level 2               (4)


    2.Full Binary Tree:

        Each node of binary tree has zero or two children not one.
        e.g 
                                  No of Levels         Atmost nodes
                    n1          <---    Level 0               (1)
                  /    \
                 n2     n3      <---    Level 1               (2)
                /  \
               n4  n5           <---    Level 2               (4)

    3.Complete Binary Tree:

        All level are completly filled except last level
        e.g
                                   No of Levels         Atmost nodes
                    n1          <---    Level 0               (1)
                  /    \
                 n2     n3      <---    Level 1               (2)
                /  \   /
               n4  n5 n6        <---    Level 2               (4)

    4. Balance Binary Tree:

        A balanced binary tree, also referred to as a height-balanced binary tree, is defined as a binary tree in which the height of the left and right subtree of any node differ by not more than 1.







