package LinkedList;

public class LinkedListDemo{


        Node head;                      //Reference to the head Node of the list


        //Constructor without value
        LinkedListDemo(){
            this.head= null;
        }
        //Constructir with head Value
        LinkedListDemo(Node head){
            this.head = head;
        }


        //Append element to the last of the linked list
        public void insetAtLast(int value){ 

            Node newNode = new Node(value);
            if (head == null ){
                System.out.println("In IF of Insert");
                head= newNode;
            }
            else{
                Node currentNode = head;
                while (currentNode.nextNode != null)
                    currentNode = currentNode.nextNode;
                System.out.println("In ELSE of insert ");
                currentNode = newNode;
                
            }
        }

        //Method that check list is empty aur not
        public boolean isEmpty (){
           if(head == null)
                    return true;
            else 
                    return false;
        }


        //Print the list
        public void display (){
            Node currentNode = head;
            while (currentNode!= null) {
                System.out.print(currentNode.value +" ");
                currentNode= currentNode.nextNode;
            }

        }
        //Get reference of head Node
        public Node getHead (){
            return head;
        }


        //Main Method
        public static void main(String[] args) {
            LinkedListDemo newLinkedlist = new LinkedListDemo();

            System.out.println("Hello From Main");
            System.out.println("Inserting 33" );
            newLinkedlist.insetAtLast(33);
            System.out.println("Inserting 22" );
            newLinkedlist.insetAtLast(22);
            System.out.println("Inserting 15" );
            newLinkedlist.insetAtLast(15);
            System.out.println("Inserting 78" );
            newLinkedlist.insetAtLast(78);
            System.out.println("Head value is : " + newLinkedlist.getHead().value);
            System.out.println("Reference to next node is : "+ newLinkedlist.getHead().nextNode);
            
            newLinkedlist.display();
        }
}

class Node {
    int value;
    Node nextNode;
    Node(){
        this.value =0;
        this.nextNode=null;
    }
    Node(int value){
        this.value = value;
        this.nextNode = null;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

}
